package mylib.datastructures.linear;
import mylib.datastructures.nodes.DNode;
public class DoublyLinkedList {
    
    public DNode head;
    public DNode tail;
    public int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DoublyLinkedList(DNode h) {
        this.head = h;
        this.tail = h;
        this.size = 1;
    }

    public void InsertHead(DNode n) {
        n.next = head;
        head = n;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void InsertTail(DNode n) {
        if (tail == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public void Insert(DNode n, int p) {
        if (p < 0 || p > size) {
            throw new IndexOutOfBoundsException();
        }
        if (p == 0) {
            InsertHead(n);
        } else if (p == size) {
            InsertTail(n);
        } else {
            DNode prev = getNode(p - 1);
            n.next = prev.next;
            prev.next = n;
            size++;
        }
    }

    private DNode getNode(int p) {
        if (p < 0 || p >= size) {
            throw new IndexOutOfBoundsException();
        }
        DNode curr = head;
        for (int i = 0; i < p; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void Sort() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        DNode curr = head;
        while (curr != null) {
            DNode next = curr.next;
            while (next != null) {
                if (curr.data > next.data) {
                    int temp = curr.data;
                    curr.data = next.data;
                    next.data = temp;
                }
                next = next.next;
            }
            curr = curr.next;
        }
    }


    
    public void SortedInsert(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        if (node.data < head.data) {
            InsertHead(node);
            return;
        }
        if (node.data > tail.data) {
            InsertTail(node);
            return;
        }
        DNode curr = head;
        while (curr.next != null && curr.next.data < node.data) {
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
        size++;
    }

    public void Print() {
        DNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    
    public void DeleteHead() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        head = head.next;
        size--;
    }
    
    public void DeleteTail() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        DNode curr = head;
        while (curr.next != tail) {
            curr = curr.next;
        }
        curr.next = null;
        tail = curr;
        size--;
    }


    public void Delete(DNode node) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        if (head.data == node.data) {
            DeleteHead();
            return;
        }
        if (tail.data == node.data) {
            DeleteTail();
            return;
        }
        DNode curr = head;
        while (curr.next != null && curr.next.data != node.data) {
            curr = curr.next;
        }
        if (curr.next == null) {
            throw new IndexOutOfBoundsException();
        }
        curr.next = curr.next.next;
        size--;
    }

   
    public void Clear() {
        head = null;
        tail = null;
        size = 0;
    }


    public DNode Search(DNode node) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        DNode curr = head;
        while (curr != null) {
            if (curr == node) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

}
