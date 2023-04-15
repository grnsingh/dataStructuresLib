package mylib.datastructures.linear;
import mylib.datastructures.nodes.DNode;
public class Queue extends SinglyLinkedList{

    public Queue() {
        super();
    }

    public Queue(DNode h) {
        super(h);
    }

    public void Enqueue(DNode n) {
        super.InsertTail(n);
    }

    public DNode Dequeue() {
        DNode temp = this.head;
        super.DeleteHead();
        return temp;
    }

    public DNode Peek() {
        return this.head;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void Print() {
        super.Print();
    }

    @Override
    public String toString() {
        String str = "";
        DNode curr = this.head;
        while (curr != null) {
            str += curr.data + " ";
            curr = curr.next;
        }
        return str;
    }

    @Override
    public void InsertHead(DNode n) {}
    @Override
    public void InsertTail(DNode n){}
    @Override
    public void Insert(DNode n, int p){}
    @Override
    public void SortedInsert(DNode n) {}
    @Override
    public void DeleteHead() {}
    @Override
    public void DeleteTail() {}
    
    
}
