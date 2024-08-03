package com.dennis.PalindromeChecker;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append (int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public boolean isPalindrome() {

        if(length == 0) {
            return true;
        }

        if(length == 1) {
            return true;
        }

        Node first = head;
        Node end = tail;

        if(length % 2 == 1) {

            while (first != tail) {

                if(first.value != end.value) {
                    return false;
                }

                first = first.next;
                end = end.prev;

            }
            return true;

        } else {

            for (int i = 0; i < length / 2; i++) {

                if(first.value != end.value) {
                    return false;
                }

                first = first.next;
                end = end.prev;
            }
            return true;

        }

    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
        doublyLinkedList.append(2);
        doublyLinkedList.append(2);
        doublyLinkedList.append(2);


        System.out.println(doublyLinkedList.isPalindrome());

    }

}


