import list.DoubleLinkedList;
import list.SingleLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    static class MyBean {
        public int id;
        public MyBean(int id){
            this.id = id;
        }

        @Override
        public String toString() {
            return "MyBean{" +
                    "id=" + id +
                    '}';
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
//        doubleLinkedList.add(3, 9);
        System.out.println("length:" + doubleLinkedList.length());
        doubleLinkedList.printList();
        System.out.println("---------------------------------------------");

        System.out.println("remove:" + doubleLinkedList.remove(1));
        System.out.println("---------------------------------------------");

        System.out.println("length:" + doubleLinkedList.length());
        doubleLinkedList.printList();

//        SingleLinkedList list = new SingleLinkedList();
//        list.addFirst(1);
//        list.addFirst(true);
//        list.addFirst("Hello");
//        list.addFirst(1.0f);

       /* MyBean bean1 = new MyBean(1);
        list.addFirst(bean1);

        MyBean bean2 = new MyBean(2);
        list.addFirst(bean2);

        MyBean bean3 = new MyBean(3);
        list.add(1, bean3);

        MyBean bean4 = new MyBean(4);
        list.addLast(bean4);

        MyBean bean5 = new MyBean(5);
        list.addFirst(bean5);

        System.out.println("length:" + list.length());
        list.printList();
        System.out.println("---------------------------------------------");*/

        /*System.out.println("remove:" + list.removeLast());
        System.out.println("---------------------------------------------");

        System.out.println("length:" + list.length());
        list.printList();*/



        List arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add(0, "2");
        arrayList.remove(0);
        arrayList.remove("1");

        LinkedList linkedList = new LinkedList();
        linkedList.add("0");
        linkedList.add(0, "1");
        linkedList.addFirst("0");
        linkedList.addLast("0");

        linkedList.remove();

    }

}
