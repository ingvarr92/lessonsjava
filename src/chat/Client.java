package chat;

import oct_nov.lesson16.printApp.Message;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;

public class Client {
    public void start(){
        System.out.println("Ввидите имя:");
        ConsoleHelper.writeString("Enter name:");
        String name = ConsoleHelper.readString();

        while (true){
            ConsoleHelper.writeString("Enter message");
            String message = ConsoleHelper.readString();
        }
//        try (Socket socket = new Socket("Local host", 8080)){
//            //IOConnection connection = new IOConnection(socket);
//           // connection.send (new Message(message,name));
//            ConsoleHelper.writeString(connection.recive().getMessText());
//
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
