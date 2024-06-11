package Graph;

public class DoubleLinkedList {
    Node28 head;
    int size;

    public DoubleLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int item, int jarak) {
        if (isEmpty()) {
            head = new Node28(null, item, jarak, null);
        } else {
            Node28 newNode = new Node28(null, item, jarak, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int get(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("nilai index di luar batas");
        }
        Node28 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public int getJarak(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("nilai index di luar batas");
        }
        Node28 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.jarak;
    }

    public void remove(int item) throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong");
        }
        Node28 current = head;
        while (current != null) {
            if (current.data == item) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
        throw new Exception("Item tidak ditemukan");
    }
}
