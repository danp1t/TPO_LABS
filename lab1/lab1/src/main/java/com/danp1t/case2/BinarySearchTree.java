package com.danp1t.case2;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree insert(String value) {
        value = checkValue(value);
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return this;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (value.compareTo(current.getValue()) >= 0) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }

        newNode.setParent(parent);
        if (value.compareTo(parent.getValue()) >= 0) {
            parent.setRight(newNode);
        } else {
            parent.setLeft(newNode);
        }

        return this;
    }

    private void delete(String value) {
        value = checkValue(value);
        Node node = findNode(value);
        if (node == null) {
            return;
        }

        if (node.getLeft() == null) {
            transplant(node, node.getRight());
        }

        else if (node.getRight() == null) {
            transplant(node, node.getLeft());
        }

        else {
            Node minRight = findMin(node.getRight());
            if (minRight.getParent() != node) {
                transplant(minRight, minRight.getRight());
                minRight.setRight(node.getRight());
                minRight.getRight().setParent(minRight);
            }
            transplant(node, minRight);
            minRight.setLeft(node.getLeft());
            minRight.getLeft().setParent(minRight);
        }
    }

    public boolean search(String value) {
        value = checkValue(value);
        return findNode(value) != null;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root, sb);
        return sb.toString().trim();
    }


    private void inOrderTraversal(Node node, StringBuilder sb) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), sb);
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(node.getValue());
            inOrderTraversal(node.getRight(), sb);
        }
    }

    private void transplant(Node u, Node v) {
        if (u.getParent() == null) {
            root = v;
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }
        if (v != null) {
            v.setParent(u.getParent());
        }
    }

    private Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private Node findNode(String value) {
        Node current = root;
        while (current != null) {
            int cmp = value.compareTo(current.getValue());
            if (cmp == 0) {
                return current;
            } else if (cmp < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }


    private String checkValue(String value) {
        try {
            Integer.parseInt(value);
            value = "0".repeat(4 - value.length()) + value;
        }
        catch (Exception ignored) {}

        if (value.length() > 4) {
            throw new RuntimeException("Value is too long");
        }
        else if (value.isEmpty()) {
            throw new RuntimeException("Value is empty");
        }

        return value;
    }
}

class Node {
    private String value;
    private Node left, right, parent;

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
