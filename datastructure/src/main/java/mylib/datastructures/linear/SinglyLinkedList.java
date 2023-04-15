package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class SinglyLinkedList {
    public DNode head;
    public DNode tail;
    public int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public SinglyLinkedList(DNode h) {
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

    public DNode Search(DNode n) {
        DNode curr = head;
        while (curr != null) {
            if (curr.data == n.data) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
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
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            DNode curr = head;
            while (curr.next != tail) {
                curr = curr.next;
            }
            curr.next = null;
            tail = curr;
        }
        size--;
    }

    public void Delete(DNode n) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else if (head.data == n.data) {
            DeleteHead();
        } else if (tail.data == n.data) {
            DeleteTail();
        } else {
            DNode curr = head;
            while (curr.next.data != n.data && curr.next != null) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;
    }

 
    public void SortedInsert(DNode n) {
        if (head == null) {
            head = n;
            tail = n;
            size++;
        } else if (n.data < head.data) {
            InsertHead(n);
        } else if (n.data > tail.data) {
            InsertTail(n);
        } else {
            DNode curr = head;
            while (curr.next != null && curr.next.data < n.data) {
                curr = curr.next;
            }
            n.next = curr.next;
            curr.next = n;
            size++;
        }
    }

    
    public void Sort() {
        if (head == null) {
            return;
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

    public void Print() {
        DNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void Clear() {
        head = null;
        tail = null;
        size = 0;
    }

}
