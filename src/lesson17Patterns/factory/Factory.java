package lesson17Patterns.factory;

abstract class Handler{
    abstract void read();
    abstract void write();
}
class TxtHandler extends Handler{

    @Override
    void read() {
        System.out.println("Read from txt");
    }

    @Override
    void write() {
        System.out.println("Write in txt");
    }
}


class XMLHandler extends Handler {

    @Override
    void read() {
        System.out.println("Read from xml");
    }

    @Override
    void write() {
        System.out.println("Write in xml");
    }
}
public class Factory {
    public Handler getFile(String string){
        Handler handler = null;
        if (string.endsWith(".txt")){
            handler = new TxtHandler();
        } else  if (string.endsWith("xml")){
            handler = new XMLHandler();
        }
        return handler;

    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        String file = "qwe.xml";
        Handler handler = factory.getFile(file);
        handler.read();
        handler.write();

    }
}
