package ch17;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Random;

public class DailyAdviceServer {
//Array of daily advice    
  final private String[] adviceList = {
          "Take smaller bites",
          "Go for the tight jeans. No they do NOT make you look fat.",
          "One word: inappropriate",
          "Just for today, be honest. Tell your boss what you *really* think",
          "You might want to rethink that haircut."};
  
  private final Random random = new Random();

  public void go() {
//Try-with-resources for autoclosing e.g. writer & socket channel
//Server application makes ServerSocketChannel and binds it to specific port
//This starts the server app listening for client requests coming in for port 5000
    try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
      serverChannel.bind(new InetSocketAddress(5000));

//Server goes into permanent loop, waiting for(and servicing) client requests      
      while (serverChannel.isOpen()) {
//Accept method blocks(just sits there), until a request comes in then
//the method returns a SocketChannel for communicating with client
        SocketChannel clientChannel = serverChannel.accept();
//Create output stream for the client's channel and wrap into a PrintWriter
//NOTE: Can use newOutPutStream or newWriter as connection stream (bridge between
//channel bytes and print-writer characters
        PrintWriter writer = new PrintWriter(Channels.newOutputStream(clientChannel));
//Call getAdvice() method below
        String advice = getAdvice(); 
//Send client a String advice message
        writer.println(advice);
//Close the writer which also closes the client SocketChannel        
        writer.close();
        System.out.println(advice);
      }

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private String getAdvice() {
//Get random int FROM 0(incl element at index 0) TO arraylength(excl length max 
//number, to incl element at index 'length - 1')
    int nextAdvice = random.nextInt(adviceList.length);
//return random advice form list    
    return adviceList[nextAdvice];
  }

  public static void main(String[] args) {
    new DailyAdviceServer().go();
  }
}