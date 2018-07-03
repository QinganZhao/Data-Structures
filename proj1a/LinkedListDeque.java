public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        Node(T i, Node prev, Node next) {
            item = i;
            prev = prev;
            next = next;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque(){
        sentinel = new Node(null, sentinel, sentinel);
        size = 0;
    }

    public void addFirst(T x){
        if (size >= 1) {
            sentinel.next = new Node(x, sentinel.prev, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
            sentinel.next.prev = sentinel.next;
        } else {
            sentinel.next = new Node(x, sentinel.prev, sentinel.next);
            sentinel.prev = sentinel.next;
            sentinel.prev.next = sentinel;
            sentinel.prev.prev = sentinel.next.next;
        }
        size += 1;
    }
}
