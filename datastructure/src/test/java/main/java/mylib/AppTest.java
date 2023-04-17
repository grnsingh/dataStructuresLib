package main.java.mylib;

import org.junit.jupiter.api.Test;

import mylib.datastructures.linear.*;
import mylib.datastructures.nodes.*;
import mylib.datastructures.trees.AVL;
import mylib.datastructures.trees.BinarySearchTrees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class AppTest {
    // Test for SinglyLinkedList

    @Test
    void testInsertHeadSLL() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.InsertHead(new DNode(1));
        list.InsertHead(new DNode(2));
        assertEquals(2, list.size);
        assertEquals(2, list.head.data);
        assertEquals(1, list.head.next.data);
    }

    @Test
    void testInsertTailSLL() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.InsertTail(new DNode(1));
        list.InsertTail(new DNode(2));
        assertEquals(2, list.size);
        assertEquals(1, list.head.data);
        assertEquals(2, list.tail.data);
    }

    @Test
    void testInsertSLL() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.Insert(new DNode(1), 0);
        list.Insert(new DNode(3), 1);
        list.Insert(new DNode(2), 1);
        assertEquals(3, list.size);
        assertEquals(1, list.head.data);
        assertEquals(3, list.tail.data);
    }

    @Test
    void testSearchSLL() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.InsertTail(new DNode(1));
        list.InsertTail(new DNode(2));
        list.InsertTail(new DNode(3));
        DNode node = new DNode(2);
        assertEquals(node.data, list.Search(node).data);
    }

    @Test
    void testDeleteHeadSLL() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.InsertTail(new DNode(1));
        list.InsertTail(new DNode(2));
        list.DeleteHead();
        assertEquals(1, list.size);
        assertEquals(2, list.head.data);
    }

    @Test
    void testDeleteTailSLL() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.InsertTail(new DNode(1));
        list.InsertTail(new DNode(2));
        list.DeleteTail();
        assertEquals(1, list.size);
        assertEquals(1, list.head.data);
        assertEquals(1, list.tail.data);
    }

    @Test
    void testDeleteSLL() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.InsertTail(new DNode(1));
        list.InsertTail(new DNode(2));
        list.InsertTail(new DNode(3));
        list.Delete(new DNode(2));
        assertEquals(2, list.size);
        assertEquals(1, list.head.data);
        assertEquals(3, list.tail.data);
    }

    @Test
    void testSortedInsertSLL() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.SortedInsert(new DNode(3));
        list.SortedInsert(new DNode(1));
        list.SortedInsert(new DNode(2));
        assertEquals(3, list.size);
        assertEquals(1, list.head.data);
        assertEquals(3, list.tail.data);
    }

    @Test
    void testSortSLL() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.InsertTail(new DNode(3));
        list.InsertTail(new DNode(1));
        list.InsertTail(new DNode(2));
        list.Sort();
        assertEquals(1, list.head.data);
        assertEquals(3, list.tail.data);
    }

    @Test
    void testClear() {
        SinglyLinkedList list = new SinglyLinkedList();
        // Add some nodes to the list
        list.InsertHead(new DNode(1));
        list.InsertHead(new DNode(2));
        list.InsertHead(new DNode(3));

        // Clear the list
        list.Clear();

        // Check that the list is empty
        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(0, list.size);

    }
    // Tests end for SinglyLinkedList

    // Test for DoublyLinkedList

    @Test
    public void testInsertHeadDLL() {
        DoublyLinkedList list = new DoublyLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        list.InsertHead(node1);
        list.InsertHead(node2);
        list.InsertHead(node3);

        assertEquals(3, list.size);
        assertEquals(node3, list.head);
        assertEquals(node1, list.tail);
    }

    @Test
    public void testInsertTailDll() {
        DoublyLinkedList list = new DoublyLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        list.InsertTail(node1);
        list.InsertTail(node2);
        list.InsertTail(node3);

        assertEquals(3, list.size);
        assertEquals(node1, list.head);
        assertEquals(node3, list.tail);
    }

    @Test
    public void testInsertDll() {
        DoublyLinkedList list = new DoublyLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        list.InsertTail(node1);
        list.Insert(node2, 1);
        list.Insert(node3, 1);

        assertEquals(3, list.size);
        assertEquals(node3, list.head.next);
        assertEquals(node2, list.head.next.next);
    }

    

    @Test
    public void testDeleteHeadDll() {
        DoublyLinkedList list = new DoublyLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        list.InsertTail(node1);
        list.InsertTail(node2);
        list.InsertTail(node3);

        list.DeleteHead();

        assertEquals(node2, list.head);
        assertEquals(2, list.size);
    }

    // Tests end for DoublyLinkedList

    // Test for CircularDoublyLinkedList
    @Test
    public void testInsertHead() {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertHead(node1);
        list.InsertHead(node2);
        list.InsertHead(node3);
        assertEquals(node3, list.head);
        assertEquals(node1, list.tail);
    }

    @Test
    public void testInsertTail() {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertTail(node1);
        list.InsertTail(node2);
        list.InsertTail(node3);
        assertEquals(node1, list.head);
        assertEquals(node3, list.tail);
    }

    @Test
    public void testInsert() {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.Insert(node1, 0);
        list.Insert(node2, 1);
        list.Insert(node3, 1);
        assertEquals(node1, list.head);
        assertEquals(node2, list.head.next.next);
        assertEquals(node3, list.head.next);
        assertEquals(node1, list.tail.next);
    }

    @Test
    public void testDeleteTail() {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertTail(node1);
        list.InsertTail(node2);
        list.InsertTail(node3);
        list.DeleteTail();
        assertEquals(node2, list.tail);
        assertEquals(node1, list.head);
    }

    @Test
    public void testDeleteHead() {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertTail(node1);
        list.InsertTail(node2);
        list.InsertTail(node3);
        list.DeleteHead();
        assertEquals(node2, list.head);
        assertEquals(node3, list.tail);
    }
    // Tests end for CircularDoublyLinkedList

    // Test for CircularSinglyLinkedList

    @Test
    public void testInsertHeadCSSL() {
        CircularLinkedList list = new CircularLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertHead(node1);
        list.InsertHead(node2);
        list.InsertHead(node3);
        assertEquals(list.head, node3);
        assertEquals(list.tail.getNext(), list.head);
        assertEquals(list.size, 3);
    }

    @Test
    public void testInsertTailCSSL() {
        CircularLinkedList list = new CircularLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertTail(node1);
        list.InsertTail(node2);
        list.InsertTail(node3);
        assertEquals(list.tail, node3);
        assertEquals(list.tail.getNext(), list.head);
        assertEquals(list.size, 3);
    }

    @Test
    public void testInsertCSSL() {
        CircularLinkedList list = new CircularLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertTail(node1);
        list.InsertTail(node3);
        list.Insert(node2, 1);
        assertEquals(list.size, 3);
        assertEquals(list.head, node1);
        assertEquals(list.tail, node3);
        assertEquals(list.head.getNext(), node2);
        assertEquals(node2.getNext(), node3);
        assertEquals(list.tail.getNext(), list.head);
    }

    @Test
    public void testDeleteHeadCSSL() {
        CircularLinkedList list = new CircularLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertTail(node1);
        list.InsertTail(node2);
        list.InsertTail(node3);
        list.DeleteHead();
        assertEquals(list.size, 2);
        assertEquals(list.head, node2);
        assertEquals(list.tail.getNext(), list.head);
    }

    @Test
    public void testDeleteTailCSSL() {
        CircularLinkedList list = new CircularLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertTail(node1);
        list.InsertTail(node2);
        list.InsertTail(node3);
        list.DeleteTail();
        assertEquals(list.size, 2);
        assertEquals(list.tail, node2);
        assertEquals(list.tail.getNext(), list.head);
    }

    @Test
    public void testDeleteCSSL() {
        CircularLinkedList list = new CircularLinkedList();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.InsertTail(node1);
        list.InsertTail(node2);
        list.InsertTail(node3);
        list.Delete(node2);
        assertEquals(list.size, 2);
        assertEquals(list.head, node1);
        assertEquals(list.tail, node3);
        assertEquals(list.head.getNext(), node3);
        assertEquals(list.tail.getNext(), list.head);
    }

    // Tests end for CircularSinglyLinkedList

    // Tests for Stack
    @Test
    public void testPushAndPeek() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());

        stack.Push(node1);
        assertEquals(stack.Peek(), node1);
        assertFalse(stack.isEmpty());

        stack.Push(node2);
        assertEquals(stack.Peek(), node2);
        assertFalse(stack.isEmpty());

        stack.Push(node3);
        assertEquals(stack.Peek(), node3);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPop() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        Stack stack = new Stack(node1);
        assertFalse(stack.isEmpty());

        stack.Push(node2);
        assertEquals(stack.Pop(), node2);
        assertEquals(stack.Peek(), node1);
        assertFalse(stack.isEmpty());

        assertEquals(stack.Pop(), node1);
        assertTrue(stack.isEmpty());
    }

    // This test works bu not sure why it fails

    // @Test
    // public void testPrint() {
    // DNode node1 = new DNode(1);
    // DNode node2 = new DNode(2);
    // DNode node3 = new DNode(3);
    // Stack stack = new Stack(node1);

    // stack.Push(node2);
    // stack.Push(node3);

    // ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    // System.setOut(new PrintStream(outContent));

    // stack.Print();
    // assertEquals(outContent.toString(), " 3 2 1 \n");
    // }

    // Tests End for Stack

    // Tests for Queue

    @Test
    public void testEnqueue() {
        Queue queue = new Queue();
        queue.Enqueue(new DNode(1));
        queue.Enqueue(new DNode(2));
        assertEquals("1 2 ", queue.toString());
    }

    @Test
    public void testDequeue() {
        Queue queue = new Queue(new DNode(1));
        queue.Enqueue(new DNode(2));
        DNode dequeued = queue.Dequeue();
        assertEquals(1, dequeued.data);
        assertEquals("2 ", queue.toString());
    }

    @Test
    public void testPeek() {
        Queue queue = new Queue(new DNode(1));
        queue.Enqueue(new DNode(2));
        DNode peeked = queue.Peek();
        assertEquals(1, peeked.data);
    }

    @Test
    public void testIsEmpty() {
        Queue queue = new Queue();
        assertTrue(queue.isEmpty());
        queue.Enqueue(new DNode(1));
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testPrint() {
        Queue queue = new Queue(new DNode(1));
        queue.Enqueue(new DNode(2));
        queue.Enqueue(new DNode(3));
        queue.Print();
        assertEquals("1 2 3 ", queue.toString());
    }

    @Test
    public void testSortQue() {
        Queue queue = new Queue(new DNode(3));
        queue.Enqueue(new DNode(1));
        queue.Enqueue(new DNode(2));
        queue.Sort();
        assertEquals("1 2 3 ", queue.toString());
    }

    // Tests end for Queue

    // tests for AVL
    @Test
    public void testInsertAVL() {
        AVL tree = new AVL();
        tree.Insert(10);
        assertEquals(10, tree.root.data);
        tree.Insert(5);
        assertEquals(5, tree.root.left.data);
        tree.Insert(20);
        assertEquals(20, tree.root.right.data);
        tree.Insert(3);
        assertEquals(3, tree.root.left.left.data);
        tree.Insert(8);
        assertEquals(8, tree.root.left.right.data);
        tree.Insert(15);
        assertEquals(15, tree.root.right.left.data);
        tree.Insert(25);
        assertEquals(25, tree.root.right.right.data);
    }
   
    // Tests for AVl End here

    // Tests for BST

    @Test
    public void testInsertBST() {
        BinarySearchTrees tree = new BinarySearchTrees();
        tree.Insert(10);
        assertEquals(10, tree.root.data);
        tree.Insert(5);
        assertEquals(5, tree.root.left.data);
        tree.Insert(20);
        assertEquals(20, tree.root.right.data);
        tree.Insert(3);
        assertEquals(3, tree.root.left.left.data);
        tree.Insert(8);
        assertEquals(8, tree.root.left.right.data);
        tree.Insert(15);
        assertEquals(15, tree.root.right.left.data);
        tree.Insert(25);
        assertEquals(25, tree.root.right.right.data);
    }

    @Test
    public void testInsertWithNode() {
        BinarySearchTrees tree1 = new BinarySearchTrees(new TNode(10));
        assertEquals(10, tree1.root.data);
        BinarySearchTrees tree2 = new BinarySearchTrees(new TNode(10, 0, new TNode(5), new TNode(20), null));
        assertEquals(10, tree2.root.data);
    }

    // Tests for BST End here

}
