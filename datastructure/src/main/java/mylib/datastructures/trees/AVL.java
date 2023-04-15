package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;

public class AVL extends BinarySearchTrees {

    public AVL() {
        super();
    }

    public AVL(int val) {
        super(val);
    }

    public AVL(TNode obj) {
        super(obj);
        if (obj.left != null) {
            this.Insert(obj.left);
        }
        if (obj.right != null) {
            this.Insert(obj.right);
        }
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
                        node.parent = parent;
                        this.balanceTree(parent);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        node.parent = parent;
                        this.balanceTree(parent);
                        return;
                    }
                }
            }
        }
    }

    public void Insert(TNode node) {
        if (root == null) {
            root = node;
        } else {
            TNode current = root;
            while (true) {
                if (node.data < current.data) {
                    if (current.left == null) {
                        current.left = node;
                        node.parent = current;
                        balanceTree(current);
                        return;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = node;
                        node.parent = current;
                        balanceTree(current);
                        return;
                    }
                    current = current.right;
                }
            }
        }
    }

    public void balanceTree(TNode node) {
        setBalance(node);
    
        int balance = node.balance;
    
        if (balance == -2) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rotateRight(node);
            } else {
                node = rotateLeftThenRight(node);
            }
        } else if (balance == 2) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node = rotateRightThenLeft(node);
            }
        }
    
        if (node.parent != null) {
            balanceTree(node.parent);
        } else {
            root = node;
        }
    }
    

    public TNode rotateLeft(TNode nodeA) {
        TNode nodeB = nodeA.right;
        nodeB.parent = nodeA.parent;
        nodeA.right = nodeB.left;
        if (nodeA.right != null) {
            nodeA.right.parent = nodeA;
        }
        nodeB.left = nodeA;
        nodeA.parent = nodeB;
        if (nodeB.parent != null) {
            if (nodeB.parent.right == nodeA) {
                nodeB.parent.right = nodeB;
            } else {
                nodeB.parent.left = nodeB;
            }
        }
        setBalance(nodeA, nodeB);
        return nodeB;
    }

    public TNode rotateRight(TNode a) {
        TNode b = a.left;
        b.parent = a.parent;
        a.left = b.right;
        if (a.left != null) {
            a.left.parent = a;
        }
        b.right = a;
        a.parent = b;
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else if (b.parent.left == a) {
                b.parent.left = b;
            }
        }
        this.setBalance(a, b);
        return b;
    }
    

    public TNode rotateLeftThenRight(TNode n) {
        n.left = this.rotateLeft(n.left);
        return this.rotateRight(n);
    }

    public TNode rotateRightThenLeft(TNode n) {
        n.right = this.rotateRight(n.right);
        return this.rotateLeft(n);
    }

    public int height(TNode node) {
        if (node == null) {
            return -1;
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    

    public void setBalance(TNode... nodes) {
        for (TNode n : nodes) {
            this.reheight(n);
            n.balance = this.height(n.right) - this.height(n.left);
        }
    }

    public void reheight(TNode node) {
        if (node != null) {
            node.height = 1 + Math.max(this.height(node.left), this.height(node.right));
        }
    }

    public TNode getRoot() {
        return this.root;
    }

    public void setRoot(TNode root) {
        this.root = root;
        if (root.left != null) {
            this.Insert(root.left);
        }
        else if (root.right != null) {
            this.Insert(root.right);
        }
    }

    public void Delete(int val) {
        if (this.root == null) {
            return;
        }
        TNode node = this.root;
        while (node != null) {
            if (val < node.data) {
                node = node.left;
            } else if (val > node.data) {
                node = node.right;
            } else {
                break;
            }
        }
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {

            if (node.parent == null) {
                this.root = null;
            } else {
                TNode parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                this.balanceTree(parent);
            }
        } else if (node.left == null) {
            if (node.parent == null) {
                this.root = node.right;
            } else {
                TNode parent = node.parent;
                node.right.parent = parent;
                if (parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
                this.balanceTree(parent);
            }
        } else if (node.right == null) {
            if (node.parent == null) {
                this.root = node.left;
            } else {
                TNode parent = node.parent;
                node.left.parent = parent;
                if (parent.left == node) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
                this.balanceTree(parent);
            }
        } else {
            TNode successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            node.data = successor.data;
            if (successor.parent.left == successor) {
                successor.parent.left = successor.right;
            } else {
                successor.parent.right = successor.right;
            }
            if (successor.right != null) {
                successor.right.parent = successor.parent;
            }
            this.balanceTree(successor.parent);
        }
    }
    
    // TNode Search(int val): inherited from parent class

    public TNode Search(int val) {
        TNode node = this.root;
        while (node != null) {
            if (val < node.data) {
                node = node.left;
            } else if (val > node.data) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public void printInOrder() {
        this.printInOrder(this.root);
    }

    public void printInOrder(TNode node) {
        if (node != null) {
            this.printInOrder(node.left);
            this.printInOrder(node.right);
        }
    }

    public void printBF() {
        this.printBF(this.root);
    }

    public void printBF(TNode node) {
        if (node != null) {
            this.printBF(node.left);
            this.printBF(node.right);
        }
    }

    public void PreOrder(TNode root) {
        if (root != null) {
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    public void InOrder(TNode root) {
        if (root != null) {
            InOrder(root.left);
            InOrder(root.right);
        }
    }
}
