package oct_nov.lesson16.printApp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class PrintClient {

    private SocketAddress socketAddress; // для работы с адресами
    private Scanner scanner;

    public PrintClient(SocketAddress address, Scanner scanner) {
        this.socketAddress = address;
        this.scanner = scanner;
    }
    private void start() throws IOException {
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        while (true){
            System.out.println("Enter your massage");
            String msg = scanner.nextLine();

            buildMassage (msg, name);
        }
    }

    private void buildMassage (String name, String mess) throws IOException {
        Message message = new Message (name, mess);
        sendMessage (message);
    }
    private void sendMessage(Message message) throws IOException {
        try (Socket socket = new Socket()){
            socket.connect(socketAddress);
            try (OutputStream out = socket.getOutputStream()){
                ObjectOutputStream objOut = new ObjectOutputStream(out);
                objOut.writeObject(message);
                objOut.flush();
            }


        }


    }


    public static SocketAddress parseAddress(String address){
        String[] strings = address.split(":");
        return new InetSocketAddress(strings[0],Integer.parseInt(strings[1]));

    }

    public static void main(String[] args) {

        String address = null;
        if (args != null && args.length > 0){
            address = args[0];
        }
        Scanner scanner = new Scanner(System.in);
        if (address == null){
            System.out.println("Enter server IP and port");
            address = scanner.nextLine();
        }
        // 124.0.5.8.5:8080 local host




        PrintClient client = new PrintClient(parseAddress(address), scanner);
        try {
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


