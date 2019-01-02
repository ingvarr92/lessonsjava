package lesson26Logged;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpServer extends Thread{
    @Override
    public void run() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(12345);
            byte[] buf = new byte[1];

            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            datagramSocket.receive(packet);
            System.out.println(buf[0] + " " + packet.getLength());




        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UdpClient extends Thread{
    @Override
    public void run() {
        DatagramPacket packet = new DatagramPacket(new byte[]{10},1, new InetSocketAddress("localhost", 12345));


        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) {
        new UdpServer().start();
        new UdpClient().start();
    }
}
