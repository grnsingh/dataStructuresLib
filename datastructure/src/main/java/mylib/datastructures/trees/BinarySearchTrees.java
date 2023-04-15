package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTrees {

    public TNode root;

    public BinarySearchTrees() {
        this.root = null;
    }

    public BinarySearchTrees(int val) {
        this.root = new TNode(val);
    }

    public BinarySearchTrees(TNode obj) {
        this.root = obj;
    }

    public TNode getRoot() {
        return this.root;
    }

    public void setRoot(TNode node) {
        this.root = node;
    }

    public void Insert(int data) {
        TNode node = new TNode(data);
        if (this.root == null) {
            this.root = node;
        } else {
            TNode current = this.root;
            TNode parent = null;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    public void insert(TNode node) {
        if (this.root == null) {
            this.root = node;
        } else {
            TNode current = this.root;
            while (true) {
                if (node.data < current.data) {
                    if (current.left == null) {
                        current.left = node;
                        return;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = node;
                        return;
                    }
                    current = current.right;
                }
            }
        }
    }
    

    public void Delete(int val) {
        TNode current = this.root;
        TNode parent = null;
        boolean isLeftChild = false;
    
        if (current == null) {
            System.out.println("Tree is empty");
            return;
        }
    
        while (current != null && current.data != val) {
            parent = current;
            if (val < current.data) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
        }
    
        if (current == null) {
            System.out.println("Value not found");
            return;
        }
    
        if (current.left == null && current.right == null) { // Case 1: Node has no children
            if (current == this.root) {
                this.root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.left == null) { // Case 2: Node has one child (right child)
            if (current == this.root) {
                this.root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.right == null) { // Case 2: Node has one child (left child)
            if (current == this.root) {
                this.root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else { // Case 3: Node has two children
            TNode successor = getSuccessor(current);
            if (current == this.root) {
                this.root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
    }
    
    private TNode getSuccessor(TNode node) {
        TNode parentOfSuccessor = node;
        TNode successor = node;
        TNode current = node.right;
    
        while (current != null) {
            parentOfSuccessor = successor;
            successor = current;
            current = current.left;
        }
    
        if (successor != node.right) {
            parentOfSuccessor.left = successor.right;
            successor.right = node.right;
        }
    
        return successor;
    }
    

    // public TNode getSuccessor(TNode deleleNode) {
    //     TNode successsor = null;
    //     TNode successsorParent = null;
    //     TNode current = deleleNode.right;
    //     while (current != null) {
    //         successsorParent = successsor;
    //         successsor = current;
    //         current = current.left;
    //     }

    //     if (successsor != deleleNode.right) {
    //         successsorParent.left = successsor.right;
    //         successsor.right = deleleNode.right;
    //     }
    //     return successsor;
    // }

    public TNode search(int val) {
        TNode current = this.root;
        while (current != null) {
            int cmp = Integer.compare(val, current.data);
            if (cmp == 0) {
                return current;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public void printInOrder() {
        printInOrder(this.root);
    }

    public void printInOrder(TNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    public void printBF() {
        Queue<TNode> queue = new LinkedList<TNode>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            TNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

}
