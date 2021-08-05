package org.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端，接受消息
 */
public class Server {

    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(8081);
            Socket accept = ss.accept();
            InputStream inputStream = accept.getInputStream()) {

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while((msg = br.readLine()) != null){
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
