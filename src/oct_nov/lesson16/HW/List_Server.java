package oct_nov.lesson16.HW;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class List_Server implements Externalizable {
    private int port;

    public List_Server(int port) {
        this.port = port;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
    public void start(){
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started at " + new Date() );
            while (true){
                Socket soket = serverSocket.accept();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Date timeReturn (){
        Date date = new Date();
        return date;
    }
}
