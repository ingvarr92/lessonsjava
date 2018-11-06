package lesson6.linkinPark;

public class Node {
    private int index;
    private Object object;
     public Node nodeNext;
     public Node nodePriv;

    public Node(int index, Object object) {
        this.index = index;
        this.object = object;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Node getNodeNext() {
        return nodeNext;
    }

    public void setNodeNext(Node nodeNext) {
        this.nodeNext = nodeNext;
    }

    public Node getNodePriv() {
        return nodePriv;
    }

    public void setNodePriv(Node nodePriv) {
        this.nodePriv = nodePriv;
    }

}
