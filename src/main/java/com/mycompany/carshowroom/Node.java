/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carshowroom;

/**
 *
 * @author mhfah
 */



public class Node {
    String companyName;
    String carName;
    String engineName;
    String carTravelled;
    String carPrice;
    String carPicture;
    int carID;
   
    
    Node prev;
    Node next;

    public Node(String companyName,String carName ,String engineName,String carTravelled,String carPrice,String carPicture,int carID) {
        this.companyName = companyName;
        this.carName = carName;
        this.engineName = engineName;
        this.carTravelled = carTravelled;
        this.carPrice = carPrice;
        this.carPicture = carPicture;
        this.carID=carID;
        this.prev = null;
        this.next = null;
    }
    
    public Node()
    {
    }
    
    public String getCompanyName(){return companyName;}
public String getCarName(){return carName;}
public String getEngineName(){return engineName;}
public String getDistanceTravelled(){return carTravelled;}
public String getCarPrice(){return carPrice;}
public int getCarID(){return carID;}
public String getCarPicture(){return carPicture;}
  

    public Node getPrev() {return prev;}

    public void setPrev(Node prev) {this.prev = prev;}

    public Node getNext() {return next;}

    public void setNext(Node next) {this.next = next;}
   




    public void display()
    {
        System.out.println(companyName);
        System.out.println(carName);
        System.out.println(engineName);
        System.out.println(carPrice);
        System.out.println(carID);
        System.out.println(carPicture);
    }
    
    
    
}

class CircularDoublyLinkedList {
    
    private Node head;
    private Node tail;

     int length=0;
    public CircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    
    
    
    public void insertFront(String companyName,String carName ,String engineName,String carTravelled,String carPrice,String carPicture,int carID) {
        Node newNode = new Node(companyName,carName ,engineName,carTravelled,carPrice,carPicture,carID);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            
        } else {
            newNode.setNext(head);
            newNode.setPrev(tail);
            head.setPrev(newNode);
            tail.setNext(newNode);
            tail = newNode;
                }
        length++;
    }
//    public void insertFront(String companyName,String carName ,String engineName,String carTravelled,String carPrice,String carPicture,int carID) {
//        Node newNode = new Node(companyName,carName ,engineName,carTravelled,carPrice,carPicture,carID);
//        if (head == null) {
//            head = newNode;
//            tail = newNode;
//            newNode.setNext(newNode);
//            newNode.setPrev(newNode);
//        } else {
//            Node current = head;
//            while (current.next != null) {
//                current = current.next;
//            }
//            current.next = newNode;
//            newNode.prev = current;
//        }
//    }

    public void delete(int key) {
        Node current = head;
        while (current != null) {
            if (current.carID==key) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
        }
        length--;
    }

    
     public Node getCurrentNode(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current;
            }
            current = current.next;
            count++;
        }
        return null; // Index out of bounds
    }
//    public void display() {
//        Node current = head;
//        while (current != null) {
//            System.out.println("car company "+current.companyName);
//            System.out.println("car name "+current.carName);
//            System.out.println("car engine "+current.engineName);
//            System.out.println("car travelled "+current.carTravelled);
//            System.out.println("car price "+current.carPrice);
//            System.out.println("car Picture "+current.carPicture);
//            current = current.next;
//        }
//        System.out.println();
//    }
    
     public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do {
             System.out.println("car company "+current.companyName);
            System.out.println("car name "+current.carName);
            System.out.println("car engine "+current.engineName);
            System.out.println("car travelled "+current.carTravelled);
            System.out.println("car price "+current.carPrice);
            System.out.println("car Picture "+current.carPicture);
            current = current.getNext();
        } while (current != head);
    }
    
}

//
//class CircularDoublyLinkedList {
//    private Node head;
//    private Node tail;
//
//    public CircularDoublyLinkedList() {
//        this.head = null;
//        this.tail = null;
//    }
//
//    public void insert(String data) {
//        Node newNode = new Node(data);
//
//        if (head == null) {
//            head = newNode;
//            tail = newNode;
//            newNode.setNext(newNode);
//            newNode.setPrev(newNode);
//        } else {
//            newNode.setNext(head);
//            newNode.setPrev(tail);
//            head.setPrev(newNode);
//            tail.setNext(newNode);
//            tail = newNode;
//        }
//    }
//
//    public void display() {
//        if (head == null) {
//            System.out.println("List is empty.");
//            return;
//        }
//
//        Node current = head;
//        do {
//            System.out.println(current.getData());
//            current = current.getNext();
//        } while (current != head);
//    }
//
//    public void displayBackwards() {
//        if (tail == null) {
//            System.out.println("List is empty.");
//            return;
//        }
//
//        Node current = tail;
//        do {
//            System.out.println(current.getData());
//            current = current.getPrev();
//        } while (current != tail);
//    }
//}
//
//public class CircularDoublyLinkedListExample {
//    public static void main(String[] args) {
//        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
//
//        list.insert("Node 1");
//        list.insert("Node 2");
//        list.insert("Node 3");
//
//        System.out.println("Forward traversal:");
//        list.display();
//
//        System.out.println("\nBackward traversal:");
//        list.displayBackwards();
//    }
//}
