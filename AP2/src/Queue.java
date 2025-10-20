public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        front = null;
        rear = null;
    }

    public void enqueue(String id, String description) {
        Node newNode = new Node(id, description);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Node dequeue() {
        if (front == null) return null;
        Node dequeuedNode = front;
        front = front.next;
        if (front == null) rear = null;
        return dequeuedNode;
    }

    public void printQueue() {
        Node current = front;
        System.out.println("Pedidos Pendentes:");
        while (current != null) {
            System.out.println("ID: " + current.id + ", Descrição: " + current.description);
            current = current.next;
        }
        System.out.println();
    }
}