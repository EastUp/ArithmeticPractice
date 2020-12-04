package practice3;

import basic_class_03.Code_14_FindFirstIntersectNode;

public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if(head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopStartHead(head1);
        Node loop2 = getLoopStartHead(head2);

        if(loop1 == null && loop2 == null)
            return noLoop(head1,head2);

        if(loop1!=null && loop2!=null){
            return bothLoop(head1,loop1,head2,loop2);
        }

        return null;
    }

    private static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2) {
        Node cru1 = null;
        Node cru2 = null;
        if(loop1 == loop2){ //相交点在环前面，相交点就在环起点
            cru1 = head1;
            cru2 = head2;
            int n = 0;
            while (cru1!=loop1){
                n++;
                cru1 = cru1.next;
            }

            while (cru2!=loop2){
                n--;
                cru2 = cru2.next;
            }

            cru1 = n > 0 ? head1 : head2;
            cru2 = cru1 == head1 ? head2 :head1;

            n = Math.abs(n);
            if(n == 0)
                return loop1;
            else{
                while (n!=0){
                    n--;
                    cru1 = cru1.next;
                }

                while (cru1 != cru2){
                    cru1 = cru1.next;
                    cru2 = cru2.next;
                }
                return cru1;
            }
        }else{
            cru1 = loop1.next;
            while (cru1!=loop1){
                if(cru1==loop2)
                    return loop1;
                cru1 = cru1.next;
            }
            return null;
        }
    }

    private static Node noLoop(Node head1, Node head2) {
        Node cru1 = head1;
        Node cru2 = head2;
        int n = 0;
        while (cru1!=null){
            n++;
            cru1 = cru1.next;
        }

        while (cru2!=null){
            n--;
            cru2 = cru2.next;
        }

        cru1 = n > 0 ? head1 : head2;
        cru2 = cru1 == head1 ? head2 :head1;

        n = Math.abs(n);
        while (n!=0){
            n--;
            cru1 = cru1.next;
        }

        while (cru1 != cru2){
            cru1 = cru1.next;
            cru2 = cru2.next;
        }
        return cru1;
    }

    private static Node getLoopStartHead(Node head) {
        Node n1 = head.next;
        Node n2 = head.next.next;

        while (n1!=n2){
            if(n2.next==null || n2.next.next==null)
                return null;
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;

        //再次从开头走，相遇的第一个点就是节点循环的初始点
        while (n1!=n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
