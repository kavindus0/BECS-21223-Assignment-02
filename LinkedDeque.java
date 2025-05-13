public class LinkedDeque<T> {

    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedDeque() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void insertFront(T element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }

        size++;
    }

    public void insertRear(T element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    public T deleteFront() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return null;
        }

        T removed = front.data;

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }

        size--;
        return removed;
    }

    public T deleteRear() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return null;
        }

        T removed = rear.data;

        if (front == rear) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }

        size--;
        return removed;
    }

    public T getFront() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return null;
        }

        return front.data;
    }

    public T getRear() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return null;
        }

        return rear.data;
    }
}
