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
public class DLL {

    private DNode header, trailer;
    
    public static void main(String[] args) {
        DNode a = new DNode(1, null, null);
        DNode b = new DNode(2, null, null);
        DNode c = new DNode(3, null, null);
        DNode aa = new DNode(4, null, null);
        
        DLL d = new DLL();
        System.out.println("----------Empty DLList------");
        d.print();
        
        d.addFirst(a);
        d.addFirst(b);
        d.addFirst(c);
        d.addFirst(aa);
        d.print();
        d.swap(0, 2);
        System.out.println("----------swapped------");
        d.print();
        /*
        System.out.println("----------DLL with added values------------");
        
        
        System.out.println("--------------Remove b------------");
        d.remove(b);
        d.print();
        
        System.out.println("--------------Remove a------------");
        d.remove(a);
        d.print();
        
        System.out.println("--------------Remove c------------");
        d.remove(c);
        d.print();
        
        System.out.println("--------------Add abc to d ------------");
        d.addFirst(a);
        d.addFirst(b);
        d.addFirst(c);
        d.print();
        
        System.out.println("--------------Reverse d------------");
        d.reverse();
        d.print();
        
        
        
        
        DNode i = new DNode(4, null, null);
        DNode j = new DNode(5, null, null);
        DNode k = new DNode(6, null, null);
        
        DLL M = new DLL();
        
        
        M.addFirst(i);
        M.addFirst(j);
        M.addFirst(k);
        
        M.print();
        
        
        d.concat(d, M);
        d.print();
        */
        
    }
    public void swap(int i, int j){
        DNode curr = header.getNext();
        DNode curr2 = header.getNext();
        int c=0;

        //stores value at first index into temp
        while(c != i){
            curr = curr.getNext();       
            c++;      
        }
        System.out.println(curr.getElement());
        c=0;
        
        //stores value at second index into temp
        while(c != j){
            curr2 = curr2.getNext();
            
            c++;
        }

        DNode tmp1 =curr.getPrev() ;
        DNode tmp2 =curr.getNext() ;    
        
        
        DNode tmp3 =curr2.getPrev() ;
        DNode tmp4 =curr2.getNext() ;  
        
        
        curr.setNext(tmp4);
        curr.setPrev(tmp3);
        
        curr2.setNext(tmp2);
        curr2.setPrev(tmp1);
        
        tmp1.setNext(curr2);
        tmp3.setNext(curr);
        tmp2.setPrev(curr2);
        tmp4.setPrev(curr);
    }
    
    
    
    public void concat(DLL L, DLL M){
       
        
        DNode cur = L.trailer.getPrev();
        DNode cur2 = M.header.getNext();
        cur.setNext(cur2);
        M.trailer.getPrev().setNext(L.trailer);
       
        
    }
    
    public DLL() {
        header = new DNode(null, null, null);
        trailer = new DNode(null, header, null);
        header.setNext(trailer);
    }

    public DNode getHeader() {
        return this.header;
    }

    public DNode getTrailer() {
        return this.trailer;
    }

    public void setHeader(DNode header) {
        this.header = header;
    }

    public void setTrailer(DNode trailer) {
        this.trailer = trailer;
    }
    
    public void addFirst(DNode n) {
        DNode temp = header.getNext();
        header.setNext(n);
        temp.setPrev(n);
        n.setPrev(header);
        n.setNext(temp);
        
    }
    
    public void print() {
        DNode current = header.getNext();
        while (current != trailer) {
            System.out.println(current.getElement() + " ");
            current = current.getNext();
        }
        
    }
    
    public void addLast(DNode n) {
        DNode temp = trailer.getPrev();
        trailer.setPrev(n);
        temp.setNext(n);
        n.setPrev(temp);
        n.setNext(trailer);
        
    }

    public void remove(DNode n) {
        DNode a = n.getPrev();
        DNode b = n.getNext();
        
        a.setNext(b);
        b.setPrev(a);
        
    }

    public void reverse() {
        
        DNode move = trailer.getPrev();
        DNode current = header.getNext();
        DNode temp = header.getNext();
        DNode temp2 = trailer.getPrev().getPrev();
        
        header.setNext(move);
        move.setPrev(header);
        move.setNext(temp);
        temp.setPrev(move);
        temp2.setNext(trailer);
        
        trailer.setPrev(temp2);
        
        while (trailer.getPrev() != temp) {
            
            temp2 = trailer.getPrev().getPrev();
            move = trailer.getPrev();
            current = temp.getPrev();
            current.setNext(move);
            move.setPrev(current);
            move.setNext(temp);
            temp.setPrev(move);
            temp2.setNext(trailer);
            trailer.setPrev(temp2);
            
        }
        
    }
    
}
