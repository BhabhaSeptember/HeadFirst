package ch17_revisit;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

//Program makes SocketChannel & BufferedReader(with the help of channel's Reader
//Then reads a single line from the server app(whatever is running at port 5000)
public class DailyAdviceClient {
    
  public void go() {
//InetSocketAddress represents the full address of the machine we want to connect to
//Constructor takes server IP address & TCP port number as arguments 
//Here the code is running on localhost
    InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
//Use SocketChannel to communicate with another machine    
//Call its static 'open()' method to create a new SocketChannel by opening it 
//and connect it to the given address
//Here we use try-with-resources to automatically close SocketChannel when
//the code is complete
    try (SocketChannel socketChannel = SocketChannel.open(serverAddress)) {
//Reader is a bridge between low-level byte stream(SocketChannel) and 
//high-level character stream(BufferedReader)
//Use Channels class static helper method(newReader) to create a Reader from 
//the SocketChannel and specify Charset to use for reading values from the network
//Reader reads from the SocketChannel
      Reader channelReader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);
//Chain the BufferedReader to the Reader object from the SocketChannel     
      BufferedReader reader = new BufferedReader(channelReader);
//readLine() method that does the work of reading the data/characters      
      String advice = reader.readLine();
      System.out.println("Today you should: " + advice);
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new DailyAdviceClient().go();
  }
}