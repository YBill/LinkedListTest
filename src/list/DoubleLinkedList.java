package list;

public class DoubleLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
        }
    }

    private Node head;

    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        temp.prev = newNode;
        newNode.next = temp;
        head = newNode;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void add(int index, T data) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }

        int length = 0;
        Node temp = head;
        while (temp != null) {
            if (index == ++length) {
                Node next = temp.next;
                Node newNode = new Node(data);
                newNode.next = next;
                newNode.prev = temp;
                temp.next = newNode;
                if (next != null) {
                    next.prev = newNode;
                }
                return;
            }
            temp = temp.next;
        }
    }

    public T removeFirst() {
        if (head != null) {
            T data = (T) head.data;
            Node next = head.next;
            if (next != null) {
                next.prev = null;
            }
            head = next;
            return data;
        }
        return null;
    }

    public T removeLast() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return removeFirst();
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Node next = temp.next;
        T data = (T) next.data;
        next.prev = null;
        temp.next = null;
        return data;
    }

    public T remove(int index) {
        if (index < 0) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }

        int position = 0;
        Node temp = head;
        while (temp != null) {
            if (index == ++position) {
                if (temp.next != null) {
                    Node delNode = temp.next;
                    if (temp.next.next != null) {
                        temp.next.next.prev = temp;
                    }
                    temp.next = temp.next.next;

                    T data = (T) delNode.data;
                    delNode.prev = null;
                    delNode.next = null;
                    return data;
                }
                return null;
            }
            temp = temp.next;
        }
        return null;
    }

    public int length() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println("data:" + temp.data + "|prev:" + (temp.prev == null ? "(head)" : temp.prev.data) + "|next:" + (temp.next == null ? "(tail)" : temp.next.data));
            temp = temp.next;
        }
    }

}
