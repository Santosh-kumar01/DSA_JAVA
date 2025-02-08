package Queue;

public class Queue_using_Arrays {
    static class Queue {
        int arr[];
        int size;
        int front;
        int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            front = 0;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear < front;
        }

        // Add element to the queue
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        // Remove element from the queue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int frontElement = arr[front];
            front++;
            return frontElement;
        }

        // Peek at the front element of the queue
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
