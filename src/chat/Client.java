package chat;

import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.Scanner;

public class Client {
//    public void start(){
//        System.out.println("Ввидите имя:");
//        ConsoleHelper.writeString("Enter name:");
//        String name = ConsoleHelper.readString();
//
//        while (true){
//            ConsoleHelper.writeString("Enter message");
//            String message = ConsoleHelper.readString();
//        }
//        try (Socket socket = new Socket("Local host", 8080)){
//            IOConnection connection = new IOConnection(socket);
//            connection.send (new Message(message,name));
//            ConsoleHelper.writeString(connection.recive().getMessText());
//
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }



    private IOConnection ioConnection;

    public Client(IOConnection ioConnection) {
        this.ioConnection = ioConnection;
    }

    private Scanner in = new Scanner(System.in);
    public void start() {
        System.out.println("Enter your name");
        String name = in.nextLine();

        Thread reader = new Thread(new Reader(ioConnection));
        reader.start();

        System.out.println("Enter message");

        while (true) {
            String msg = in.nextLine();

            // реализовать возможность выхода их чата(/exit)
            // реализовать возможность сменить имя пользователя (/nick)


            if (msg != null && !msg.isEmpty()) {
                Message message = new Message(name, msg);
                ioConnection.send(message);
            }
        }
    }


            private class Reader implements Runnable{
            private final IOConnection connection;

            private Reader (IOConnection connection){
                this.connection = connection;
            }

                @Override
                public void run() {
                        while (!Thread.currentThread().isInterrupted()){
                            Message message = connection.receive();
                            System.out.println(message);
                        }
                }
            }


    public static void main(String[] args) throws IOException {
        Client client = new Client(new IOConnection(new Socket("127.0.0.1", 8080)));

        client.start();
    }

}
