package oct_nov.lesson6.linkinPark;

public class LinkinList {
    private static int size = 0;
    private Node nFirst = new Node(0,null);
    private Node nLast = new Node (size,null);

    public void push(Object object) {
        if  (nFirst.getObject() == null) {
            nFirst.setObject(object);
            size++;
            nLast.setIndex(size);
            nLast.setNodePriv(nFirst);
        }
            
    }

    public void remove(int index) {
        if (size >= index) {// Как находить нужный узел?


            size--;
        } else {
            System.out.println("Не существует такого индекса");
        }
    }

    public Object get(int index) {

        if (size >= index) {// Как находить нужный узел?
        return "";

        } else {
            System.out.println("Не существует такого индекса");
            return null;
        }

    }

    public void add (Object object, int index){
        Node node = nFirst;
        while (node.nodeNext != null){
            if (node.getIndex()==index){
                Node nodeNew = new Node (index,object);
            }

            node = node.nodeNext;
        }

    }

}



