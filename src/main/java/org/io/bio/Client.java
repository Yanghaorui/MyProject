package org.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端，发送消息
 */
public class Client {

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8081);
            OutputStream outputStream = socket.getOutputStream()) {

            PrintStream printStream = new PrintStream(outputStream);
            Scanner scanner = new Scanner(System.in);
            while(true){
                String next = scanner.next();
                printStream.println(next);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
