package mylib.datastructures.nodes;

public class TNode {
    //tree node
    public int data;
    public TNode left;
    public TNode right;
    public TNode parent;
    public int balance;
    public int height;

    public TNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        this.data = data;
        this.balance = balance;
        this.parent = P;
        this.left = L;
        this.right = R;
    }

    public void setLeft(TNode node) {
        this.left = node;
        if (node != null) {
            node.parent = this;
        }
    }

    public void setRight(TNode node) {
        this.right = node;
        if (node != null) {
            node.parent = this;
        }
    }

    public TNode getLeft() {
        return this.left;
    }

    public TNode getRight() {
        return this.right;
    }

    public TNode getParent() {
        return this.parent;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    //print: prints the node information to console in a user friendly format
    public void print() {
        System.out.println("Node: " + this.data);
        System.out.println("Left: " + (this.left == null ? "null" : this.left.data));
        System.out.println("Right: " + (this.right == null ? "null" : this.right.data));
        System.out.println("Parent: " + (this.parent == null ? "null" : this.parent.data));
        System.out.println("Balance: " + this.balance);
    }

    //toString: returns the data member as a string (will be used for the tree prints)
    public String toString() {
        return Integer.toString(this.data);
    }



    


}
