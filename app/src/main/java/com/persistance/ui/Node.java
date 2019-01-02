package com.persistance.ui;

public class Node {
    Node pre, next;
    int data;

    Node(int data) {
        this.data = data;
        pre = next = null;
    }
}
