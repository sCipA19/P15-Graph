package Graph;

public class Node28 {
    int data;
    int jarak;
    Node28 prev, next;

    Node28(Node28 prev, int data, int jarak, Node28 next) {
        this.prev = prev;
        this.data = data;
        this.jarak = jarak;
        this.next = next;
    }
}
