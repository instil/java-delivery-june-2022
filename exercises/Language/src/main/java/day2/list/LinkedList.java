package day2.list;

public class LinkedList {
    private int size;
    private Node first;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(String item) {
        if (isEmpty()) {
            first = new Node(null, null, item);
        }
        size++;
    }

    public String get(int index) {
        if(index == 0) {
            return first.getPayload();
        }
        return null;
    }
}
