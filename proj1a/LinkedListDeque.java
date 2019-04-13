public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node(null, sentinel, sentinel);
        size = 0;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public void addFirst(T x) {
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

    public void addLast(T x) {
        if (size < 1) {
            sentinel.next = new Node(x, sentinel.prev, sentinel.next);
            sentinel.prev = sentinel.next;
            sentinel.prev.next = sentinel;
            sentinel.next.next = sentinel.prev;
        } else if (size < 2) {
            sentinel.prev = new Node(x, sentinel.next, sentinel);
            sentinel.next.next = sentinel.prev;
        } else {
            sentinel.prev = new Node(x, sentinel.prev, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
            sentinel.prev.prev = sentinel.prev.prev.prev.next;
        }
        size += 1;
    }

    public T get(int index) {
        if (index >= this.size) {
            return null;
        }

        Node p = this.sentinel.next;
        int count = 0;

        while (count != index) {
            p = p.next;
            count += 1;
        }

        return p.item;
    }

    private T recursiveHelper(int index, Node x) {
        if (index == 0) {
            return x.item;
        }

        return recursiveHelper(index - 1, x.next);
    }

    public T getRecursive(int index) {
        if (index >= this.size) {
            return null;
        }

        return recursiveHelper(index, this.sentinel.next);
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }

        Node firstNode = this.sentinel.next;
        T itemToReturn = firstNode.item;

        // re-wire to second node
        this.sentinel.next = firstNode.next;
        firstNode.next.prev = this.sentinel;

        this.size -= 1;
        firstNode = null;
        return itemToReturn;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        Node lastNode = this.sentinel.prev;
        T itemToReturn = lastNode.item;

        this.sentinel.prev = lastNode.prev;
        lastNode.prev.next = this.sentinel;

        this.size -= 1;
        lastNode = null;
        return itemToReturn;
    }

    public void printDeque() {
        Node p = this.sentinel.next;

        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }
}