public class ArrayDequeueLinked<T> {
private T[] array;
private int front;
private int rear;
private int size;
private int capacity;
public ArrayDequeueLinked(int capacity) {
this.capacity = capacity;
this.array = (T[]) new Object[capacity];
this.front = 0;
this.rear = capacity - 1;
this.size = 0;
public boolean isEmpty() {
return (size == 0);
public boolean isFull() {
return (size == capacity);
public int size() {
return size;
}
}
}
}
public void insertFront(T element) {
if (isFull()) {
System.out.println("Dequeue is full");
}
// If first element is being inserted
if (isEmpty()) {
front = 0;
rear = 0;
} else {
// Circular array concept - decrement front with circular wrap
front = (front - 1 + capacity) % capacity;
}
array[front] = element;
size++;
}
6
public void insertRear(T element) {
if (isFull()) {
System.out.println("Dequeue is full");
}
// If first element is being inserted
if (isEmpty()) {
front = 0;
rear = 0;
} else {
// Circular array concept - increment rear with circular wrap
rear = (rear + 1) % capacity;
}
array[rear] = element;
size++;
}
public T deleteFront() {
if (isEmpty()) {
System.out.println("Dequeue is empty");
}
T removed = array[front];
array[front] = null; // Help with garbage collection
// If this was the last element
if (front == rear) {
front = -1;
rear = -1;
} else {
// Circular array concept - increment front with circular wrap
front = (front + 1) % capacity;
}
size--;
return removed;
}
public T deleteRear() {
if (isEmpty()) {
System.out.println("Dequeue is empty");
}
T removed = array[rear];
array[rear] = null; // Help with garbage collection
// If this was the last element
if (front == rear) {
front = -1;
rear = -1;
} else {
// Circular array concept - decrement rear with circular wrap
rear = (rear - 1 + capacity) % capacity;
}
size--;
return removed;
}

public T getFront() {
if (isEmpty()) {
System.out.println("Dequeue is empty");
}
return array[front];
}
public T getRear() {
if (isEmpty()) {
System.out.println("Dequeue is empty");
}
return array[rear];
}
}
