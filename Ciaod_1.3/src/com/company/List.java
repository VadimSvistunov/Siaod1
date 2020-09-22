package com.company;

public class List<T extends Comparable<T>> {

    private Node head = null;
    private Node last = null;

    void add(String lastName, String number) {
        if(head == null) {
            head = new Node(lastName, number);
            last = head;
        } else {
            Node temp = new Node(lastName, number);
            if(temp.compareTo(head) <= 0) {
                temp.next = head;
                head = temp;
            } else if(head == last){
                head.next = temp;
                last = temp;
            } else {
                putElement(temp);
            }
        }
    }

    void putElement (Node node) {
        Node currentPrevious = head;
        Node current = head.next;
        do {
            if (node.compareTo(current) <= 0) {
                currentPrevious.next = node;
                node.next = current;
                break;
            } else if(current == last) {
                current.next = node;
                last = node;
                break;
            }
            currentPrevious = current;
        } while((current = current.next) != null);
    }

    String searchLastName(String number) {
        Node current = head;
        do {
            if(current.number.equals(number)) {
                return current.lastName;
            }
        } while((current = current.next) != null);
        return "No matches.";
    }

    String searchNumber(String lastName) {
        Node current = head;
        do {
            if(current.lastName.equals(lastName)) {
                return current.number;
            }
        } while((current = current.next) != null);
        return "No matches.";
    }

    void show() {
        Node current = head;
        System.out.println("LastName:\t\t\tNumber:\t\t\t");
        System.out.println("");
        do {
            System.out.printf("%16s\t%8s", current.lastName, current.number);
            System.out.println("");
        } while((current = current.next) != null);
    }

    boolean isEmpty() {
        return head == null;
    }

    public class Node implements Comparable<Node> {
        Node next;
        String lastName;
        String number;

        Node(String lastName, String number) {
            this.lastName = lastName;
            this.number = number;
            next = null;
        }

        @Override
        public int compareTo(Node node) {
            return lastName.compareTo(node.lastName);
        }

    }
}
