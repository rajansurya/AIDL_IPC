package com.persistance.ui;

public class LinkedListDeletion {

    Node insertUi(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }
        if (key < node.data) {
            return insertUi(node.pre, key);
        } else if (key > node.data) {
            return insertUi(node.next, key);
        }
        return null;
    }

    int minValue(Node node) {
        int min = -1;

        while (node.pre != null) {
            min = node.pre.data;
            node = node.pre;
        }
        return min;
    }

    void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.pre);
            System.out.println(node.data);
            inorderRec(node.next);
        }
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return root;
        if (key < root.data) {
            root.pre = deleteRec(root.pre, key);
        } else if (key > root.data) {
            root.next = deleteRec(root.next, key);
        } else {
            if (root.pre == null) {
                return root.next;
            } else if (root.next == null) {
                return root.pre;
            }
            root.data = minValue(root.next);
            root.next = deleteRec(root.next, root.data);

        }
        return root;
    }
}
