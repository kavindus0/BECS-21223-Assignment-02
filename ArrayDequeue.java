public class ArrayDequeue<T> {
    private T[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayDequeue(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = capacity - 1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public int size() {
        return size;
    }

    public void insertFront(T element) {
        if (isFull()) {
            System.out.println("Dequeue is full");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        array[front] = element;
        size++;
    }

    public void insertRear(T element) {
        if (isFull()) {
            System.out.println("Dequeue is full");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        array[rear] = element;
        size++;
    }

    public T deleteFront() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return null;
        }

        T removed = array[front];
        array[front] = null;

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        size--;
        return removed;
    }

    public T deleteRear() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return null;
        }

        T removed = array[rear];
        array[rear] = null;

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }

        size--;
        return removed;
    }

    public T getFront() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return null;
        }

        return array[front];
    }

    public T getRear() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return null;
        }

        return array[rear];
    }
}
