package com.nmittal.datastructure;

/**
 * MyLinkedList Description.
 *
 * @author NarainM
 */
public final class MyLinkedList<T> {

    private MyNode head;
    //private int length;

    public static void main(String[] args) {

        MyLinkedList<String> list = new MyLinkedList<String>();

        list.print();

        list.add("a");
        list.add("b");
        list.add("c");

        list.print();

        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.isEmpty());
        list.add("d");
        list.add("e");
        list.add("f");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(0));
        System.out.println(list.get(5));
        System.out.println(list.get(2));

    }

    // add
    public void add(T item) {
        if (null == item) {
            return;
        }
        if (null == head) {
            head = new MyNode<T>(item);
        } else {
            MyNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new MyNode<T>(item));
        }
        //  length++;
    }

    // remove
    public T remove() {
        if (null == head) {
            return null;
        }
        if (head.getNext() == null) {
            MyNode<T> removed = head;
            head = null;
            return removed.getValue();
        } else {
            MyNode<T> current = head;
            MyNode<T> previous = null;
            while (current.getNext() != null) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(null);
            return current.getValue();
        }

    }
    // get

    // size
    public int size() {
        int count = 0;
        MyNode<T> current = head;
        while (current != null) {
            current = current.getNext();
            count++;
        }
        return count;
    }

    public T get(int index) {
        if (head == null) {
            return null;
        }
        MyNode<T> current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.getValue();
            }
            current = current.getNext();
            count++;
        }

        return null;
    }

    // isempty
    public boolean isEmpty() {
        return head == null;
    }

    public void print() {

        MyNode<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " => ");
            current = current.getNext();
        }
        System.out.println(" ");

    }

    private class MyNode<T> {
        private T value;
        private MyNode next;

        public MyNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public MyNode<T> getNext() {
            return next;
        }

        public void setNext(MyNode next) {
            this.next = next;
        }
    }
}
