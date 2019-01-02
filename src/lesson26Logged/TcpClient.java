package lesson26Logged;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpClient extends Thread{
    @Override
    public void run() {
        try (Socket socket = new Socket()){
            socket.connect(new InetSocketAddress("localhost",12345));
            OutputStream out = socket.getOutputStream();
            out.write(12);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



class TcpServer extends Thread{
    @Override
    public void run() {
        try(ServerSocket serverSocket = new ServerSocket(12345)){
            try (Socket socket = serverSocket.accept()) {
                InputStream in = socket.getInputStream();
                byte data = (byte) in.read();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MainTcp {
    public static void main(String[] args) {
        new TcpServer().start();
        new TcpClient().start();
    }
}