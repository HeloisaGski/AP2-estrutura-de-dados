public class Node {
    String id;
    String description;
    Node next;

    public Node(String id, String description) {
        this.id = id;
        this.description = description;
        this.next = null;
    }
}