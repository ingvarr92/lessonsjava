package chat;

import oct_nov.lesson16.printApp.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class IOConnection {
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    public IOConnection(Socket socket) {
        this.socket = socket;
        try {
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e){
            e.printStackTrace();
    }
    }

    public void send (Message mess){
        try {
            out.writeObject(mess);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Message recive(){
        Message message = null;
        try {
            message = (Message)in.readObject();

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return message;
    }

    public SocketAddress getRemoteSocketAddres(){
        return socket.getRemoteSocketAddress();
    }
}
