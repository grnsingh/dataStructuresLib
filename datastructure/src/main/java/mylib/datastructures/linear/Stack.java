package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class Stack extends SinglyLinkedList {

    public Stack() {
        super();
    }

    public Stack(DNode head) {
        super(head);
    }

    public void Push(DNode n) {
        super.InsertHead(n);
    }

    public DNode Pop() {
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
    public void InsertHead(DNode n) {
    }

    @Override
    public void InsertTail(DNode n) {
    }

    @Override
    public void Insert(DNode n, int p) {
    }

    @Override
    public void SortedInsert(DNode n) {
    }

    @Override
    public void DeleteHead() {
    }

    @Override
    public void DeleteTail() {
    }

    @Override
    public void Delete(DNode n) {
    }

    @Override
    public void Sort() {
    }

}
