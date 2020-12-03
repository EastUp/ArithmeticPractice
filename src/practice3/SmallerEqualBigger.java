package practice3;

import basic_class_03.Code_12_SmallerEqualBigger;

public class SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition(Node head, int pivot) {
        Node lH = null;
        Node lT = null;
        Node eH = null;
        Node eT = null;
        Node mH = null;
        Node mT = null;
        while (head != null) {
            if (head.value < pivot) {
                if (lH == null) {
                    lH = head;
                } else {
                    lT.next = head;
                }
                lT = head;
            } else if (head.value > pivot) {
                if (mH == null) {
                    mH = head;
                } else {
                    mT.next = head;
                }
                mT = head;
            } else {
                if (eH == null) {
                    eH = head;
                } else {
                    eT.next = head;
                }
                eT = head;
            }
            head = head.next;
        }
        if (lT != null)
            lT.next = null;
        if (mT != null)
            mT.next = null;
        if (eT != null)
            eT.next = null;

        Node newNode = null;
        if (lH == null) {
            if (eH == null) {
                newNode = mH;
            } else {
                eT.next = mH;
                newNode = eH;
            }
        } else {
            if (eH == null) {
                lT.next = mH;
            } else {
                lT.next = eH;
                eT.next = mH;
            }
            newNode = lH;
        }
        return newNode;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition(head1, 5);
        printLinkedList(head1);

    }

}
