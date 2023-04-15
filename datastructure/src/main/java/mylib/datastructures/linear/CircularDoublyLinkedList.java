package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class CircularDoublyLinkedList extends DoublyLinkedList {

    public CircularDoublyLinkedList() {
        super();
    }

    public CircularDoublyLinkedList(DNode head) {
        super(head);
        this.tail.next = this.head;
    }

    @Override
    public void InsertHead(DNode node) {
        super.InsertHead(node);
        this.tail.next = this.head;
    }

    @Override
    public void InsertTail(DNode node) {
        super.InsertTail(node);
        this.tail.next = this.head;
    }

    @Override
    public void Insert(DNode node, int position) {
        super.Insert(node, position);
        this.tail.next = this.head;
    }

    @Override
    public void DeleteTail() {
        if (this.head == null) {
            throw new NullPointerException();
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        DNode curr = this.head;
        while (curr.next != this.tail) {
            curr = curr.next;
        }
        curr.next = this.head;
        this.tail = curr;
        size--;
    }

    @Override
    public void Delete(DNode node) {
        if (this.head == null) {
            throw new NullPointerException();
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        DNode curr = this.head;
        while (curr.next != this.head) {
            if (curr.data == node.data) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                size--;
                return;
            }
            curr = curr.next;
        }
        if (curr.data == node.data) {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            size--;
            return;
        }
        throw new NullPointerException();
    }

    @Override
    public void DeleteHead() {
        if (this.head == null) {
            throw new NullPointerException();
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        this.head = this.head.next;
        this.tail.next = this.head;
        size--;
    }

    @Override
    public DNode Search(DNode node) {
        if (this.head == null) {
            throw new NullPointerException();
        }

        DNode curr = this.head;
        while (curr.next != this.head) {
            if (curr.data == node.data) {
                return curr;
            }
            curr = curr.next;
        }
        if (curr.data == node.data) {
            return curr;
        }
        return null;
    }

    @Override
    public void Print() {
        if (this.head == null) {
            throw new NullPointerException();
        }
        DNode curr = this.head;
        while (curr.next != this.head) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println(curr.data);
    }

    @Override
    public void Clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

}
