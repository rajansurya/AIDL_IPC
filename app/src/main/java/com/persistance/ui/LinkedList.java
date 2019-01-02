package com.persistance.ui;

public class LinkedList {


    Node head;

    Node sortedListToBST() {
        /*Count the number of nodes in Linked List */
        int n = countNode(head);

        /* Construct BST */
        return sortedListToBSTRecur(n);
    }

    Node sortedListToBSTRecur(int n) {
        if (n <= 0) {
            return null;
        }
        Node left = sortedListToBSTRecur(n / 2);
        Node root = head;
        root.pre = left;
        head = head.next;
        root.next = sortedListToBSTRecur(n - n / 2 - 1);
        return root;
    }

    int countNode(Node head) {
        int count = 0;
        Node tmp;
        while (head.next != null) {
            //tmp=head.next;
            count++;
        }
        return count;

    }

    void push(int new_item) {
        Node new_node = new Node(new_item);
        new_node.pre = null;
        new_node.next = head;
        if (head != null) {
            head.pre = new_node;
        }
        head = new_node;
    }

    void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /* A utility function to print preorder traversal of BST */
    void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.pre);
        preOrder(node.next);
    }


    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();

        /* Let us create a sorted linked list to test the functions
           Created linked list will be 7->6->5->4->3->2->1 */
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List ");
        llist.printList();

        /* Convert List to BST */
        Node root = llist.sortedListToBST();
        System.out.println("");
        System.out.println("Pre-Order Traversal of constructed BST ");
        llist.preOrder(root);
    }


}
