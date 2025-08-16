/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.time.format.FormatStyle;
import java.util.concurrent.TimeUnit;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ofLocalizedTime;

/**
 *
 * @author User
 */

//SUMMARY:
//This is a simple network client program.
//It tries to connect to a server running locally at IP 127.0.0.1 on port 5000 
//using a SocketChannel. (use SimpleChatServer example for the server)
//Once connected, it sets up a PrintWriter to send text messages to the server 
//over the socket.
//Inside a loop (runs 10 times):
//It builds a message ("ping 0", "ping 1", … "ping 9").
//Sends the message to the server (writer.println(message)).
//Prints a log on the console showing the current time and what message was 
//sent.
//Waits for 1 second before sending the next ping.
//After 10 pings, the connection is automatically closed 
//(because of try-with-resources).
//If anything goes wrong (I/O or interruption), it prints the stack trace.

public class PingingClient {

    public static void main(String[] args) {
        InetSocketAddress server = new InetSocketAddress("127.0.0.1", 5000);

        try (SocketChannel channel = SocketChannel.open(server)) {
            PrintWriter writer = new PrintWriter(Channels.newWriter(channel, UTF_8));
            System.out.println("Networking established");

            for (int i = 0; i < 10; i++) {
                String message = "ping " + i;
                writer.println(message);
                writer.flush();
                String currentTime = now().format(ofLocalizedTime(FormatStyle.MEDIUM));
                System.out.println(currentTime + " Sent " + message);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
