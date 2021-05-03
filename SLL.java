/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.homework4s;

/**
 *
 * @author ayoka
 */
public class SLL {

    private Node head;

    public static void main(String[] args) {

        SLL sl = new SLL();
        sl.print();
        
        Node a = new Node(1, null);
        Node b = new Node(2, null);
        Node c = new Node(3, null);
        
        sl.add(a);
        sl.add(b);
        sl.add(c);
        System.out.println("------List------");
        sl.print();/*
        System.out.println("------Remove-------");
        sl.remove();
        sl.print();
        System.out.println("------Remove-------");
        sl.remove();
        sl.print();
        System.out.println("------Remove-------");
        sl.remove();
        sl.print();
        System.out.println("------Add Elements Back-------");
        sl.add(a);
        sl.add(b);
        sl.add(c);
        sl.print();
        System.out.println("------Reverse-------");
        sl.reverse();
        sl.print();
        */
        
        sl.deleteNth(0);
        System.out.println("------Remove-------");
        sl.print();
    }

    public SLL() {

        head = null;

    }
    
    public void deleteNth(int n){
        int count= 0;
        Node curr = head;
        
        while(curr != null){
            curr = curr.getNext();
            count++;
        }
        System.out.println(count);if(count == n){
            
         setHead(null); 
         
        }else{
        count = count-n;
        int i = 1;
        Node temp = head;
        while(i != count){
           temp = temp.getNext();
           i++;
        }
        
        temp.setNext(null);
        }
    }
    
    
    public Node findMiddle(){

int n = 0;

Node current = head;

while (current != null){

current = current.getNext();

n++;

}

int mid = n/2;

int i = 0;

Node temp = head;

while(i != mid){

i++;

temp = temp.getNext();

}

return temp;

}

    public void setHead(Node head) {
        this.head = head;

    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getElement() + " ");
            current = current.getNext();
        }

    }
    

    public void add(Node n) {
        if (head == null) {
            head = n;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(n);
        }
        n.setNext(null);
    }

    public Node remove() {

        Node current = head;
        
        if (current == null) {
            head = null;
            return null;
        } else if (current.getNext() == null) {
            head = null;
            return null;
        } else {
            while (current.getNext().getNext() != null) {
           
                current = current.getNext();
            }
            current.setNext(null);
        }

        return current;

    }

    public void reverse(){
       Node prev = null;
       Node current= head;
       Node next = null;
       
       while(current != null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current= next;
            
            
            
       }
       head = prev;
       
       
    }
}
