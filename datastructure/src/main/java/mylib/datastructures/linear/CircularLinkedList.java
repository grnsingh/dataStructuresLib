package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class CircularLinkedList extends SinglyLinkedList {

    public CircularLinkedList() {
        super();
    }

    public CircularLinkedList(DNode h) {
        this.head = h;
        this.tail = h;
        h.setNext(h);
        size = 1;
    }

    @Override
    public void InsertHead(DNode n) {
        super.InsertHead(n);
        this.tail.setNext(this.head);
    }

    @Override
    public void InsertTail(DNode n) {
        super.InsertTail(n);
        this.tail.setNext(this.head);
    }

    @Override
    public void Insert(DNode n, int p) {
        super.Insert(n, p);
        this.tail.setNext(this.head);
    }

    public void DeleteHead() {
        if (this.head == null) {
            throw new NullPointerException();
        }
        this.head = this.head.getNext();
        this.tail.setNext(this.head);
        size--;
    }

    // override Search method
    @Override
    public DNode Search(DNode n) {
        if (this.head == null) {
            throw new NullPointerException();
        }
        DNode curr = this.head;
        while (curr.getNext() != this.head) {
            if (curr.data == n.data) {
                return curr;
            }
            curr = curr.getNext();
        }
        if (curr.data == n.data) {
            return curr;
        }
        return null;
    }

    public void DeleteTail() {
        if (this.head == null) {
            throw new NullPointerException();
        }
        DNode curr = this.head;
        while (curr.getNext() != this.tail) {
            curr = curr.getNext();
        }
        curr.setNext(this.head);
        this.tail = curr;
        size--;
    }

    public void Delete(DNode n) {
        if (this.head == null) {
            throw new NullPointerException();
        }
        DNode curr = this.head;
        while (curr.getNext().data != n.data && curr.getNext() != this.head) {
            curr = curr.getNext();
        }
        curr.setNext(n.getNext());

        size--;

    }


    @Override
    public void Sort() {
        if (this.head == null) {
            throw new NullPointerException();
        }
        DNode curr = this.head;
        DNode min = curr;
        DNode temp = null;
        while (curr.getNext() != this.head) {
            min = curr;
            temp = curr.getNext();
            while (temp != this.head) {
                if (temp.data < min.data) {
                    min = temp;
                }
                temp = temp.getNext();
            }
            int tempData = curr.data;
            curr.data = min.data;
            min.data = tempData;
            curr = curr.getNext();
        }
    }

    // override clear
    @Override
    public void Clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    // override print
    @Override
    public void Print() {
        if (this.head == null) {
            throw new NullPointerException();
        }

        DNode curr = this.head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.getNext();
            if (curr == this.head) {
                break;
            }
        }
        System.out.println(curr.data);
    }

    @Override
    public void SortedInsert(DNode node) {
        if (this.head == null) {
            throw new NullPointerException();
        }
        DNode curr = this.head;
        while (curr.getNext() != this.head) {
            if (curr.data < node.data && curr.getNext().data > node.data) {
                node.setNext(curr.getNext());
                curr.setNext(node);
                size++;
                return;
            }
            curr = curr.getNext();
        }
        if (curr.data < node.data) {
            node.setNext(curr.getNext());
            curr.setNext(node);
            size++;
        }
    }

}