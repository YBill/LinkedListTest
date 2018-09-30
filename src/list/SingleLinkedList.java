package list;

public class SingleLinkedList<T> {

    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }

    }

    private Node head;

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
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        newNode.next = temp;
        head = newNode;
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
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        }

        throw new IndexOutOfBoundsException("this list length is " + length + ",the index is " + index);
    }

    public T removeFirst() {
        if (head != null) {
            T data = (T) head.data;
            head = head.next;
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
        T data = (T) temp.next.data;
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
                    T data = (T) delNode.data;
                    temp.next = delNode.next;
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
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }

}
