package mylib.datastructures.nodes;

public class DNode {

        public int data;
        public Node prev;
        public DNode next;
    
        public DNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        
    public void setNext(DNode head) {
        this.next = head;
    }

    public DNode getNext() {
        return this.next;
    }

}
