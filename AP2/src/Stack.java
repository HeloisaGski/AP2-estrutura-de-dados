public class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    public void push(String id, String description) {
        Node newNode = new Node(id, description);
        newNode.next = top;
        top = newNode;
    }

    public Node pop() {
        if (top == null) return null;
        Node poppedNode = top;
        top = top.next;
        return poppedNode;
    }

    public void printStack() {
        Node current = top;
        System.out.println("Pedidos Cancelados:");
        while (current != null) {
            System.out.println("ID: " + current.id + ", Descrição: " + current.description);
            current = current.next;
        }
        System.out.println();
    }
}