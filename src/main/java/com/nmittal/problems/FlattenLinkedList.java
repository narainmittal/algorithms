package com.nmittal.problems;

import java.util.Scanner;

/**
 * FlattenLinkedList Description.
 *
 * @author NarainM
 */
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

class FlattenLinkedList {
    Node head;

    void printList(Node node) {
        //Node temp = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        FlattenLinkedList list = new FlattenLinkedList();
        while (t > 0) {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = sc.nextInt();

            Node temp = null;
            Node tempB = null;
            Node pre = null;
            Node preB = null;
            int flag = 1;
            int flag1 = 1;
            for (int i = 0; i < N; i++) {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new Node(a1);
                if (flag == 1) {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                } else {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for (int j = 0; j < m; j++) {
                    int a = sc.nextInt();
                    tempB = new Node(a);
                    if (flag1 == 1) {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    } else {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }

            }
            list.printList(list.head);
            GfG g = new GfG();
            Node root = g.flatten(list.head);
            list.printList(root);

            t--;
        }
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Node class  used in the program
class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}
*/
/*  Function which returns the  root of
    the flattened linked list. */
class GfG {
    Node flatten(Node root) {
        //Node current = root;
        Node result = root;

        while (result != null && result.next != null) {

            Node from;
            Node to;
            //merge headers
            if (result.data > result.next.data) {
                from = result;
                result = result.next;
                //first.right = null;
            } else {
                from = result.next;
                result.next = result.next.next;
            }
            to = result;
            //merge into result
            while (from != null && to.bottom != null) {
                if (from.data < to.bottom.data) {
                    Node next = from.bottom;
                    from.bottom = to.bottom;
                    to.bottom = from;
                    from = next;
                }
                to = to.bottom;
            }
            if (to.bottom == null && from != null) {
                to.bottom = from;
            }

        }

        return result;
    }
}

