package lesson16.printApp;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private String messText;
    private String sender;

    public Message(String messText, String sender) {
        this.messText = messText;
        this.sender = sender;
    }

    public String getMessText() {
        return messText;
    }

    public void setMessText(String messText) {
        this.messText = messText;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
