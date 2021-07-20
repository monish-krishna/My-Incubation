/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Monish Krishna Selva
 */
public class TreeSetExp {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //creating a set
        Set<Integer> setA = new TreeSet<>();
        Set<Integer> setB = new TreeSet<>();
        
        //adding elements
        setA.add(3);
        setA.add(2);
        setA.add(1);
        setA.add(4);
        setA.add(5);
        System.out.println("setA: "+setA);
        setA.add(2);
        System.out.println("setA: "+setA);
        
        //Iterating through a set
        //using Iterator
        Iterator<Integer> iterator = setA.iterator();
        System.out.print("setA: ");
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        //using For-Each
        System.out.print("setA: ");
        for(Integer element:setA){
            System.out.print(element+" ");
        }System.out.println();
        
        //removing element from the set
        setA.remove(4);
        System.out.println("setA: "+setA);
        
        //removing all elements
        setA.clear();
        System.out.println("setA: "+setA);
        
        //add all elements from another collection
        setA.add(10);
        setA.add(5);
        setB.add(3);
        setB.add(2);
        setB.add(8);
        setB.add(4);
        setB.add(6);
        setA.addAll(setB);
        System.out.println("setA: "+setA);
        
        
        //remove all elements from another collection
        setB.add(9);
        setB.add(11);
        System.out.println("setB: "+setB);
        setB.removeAll(setA);
        System.out.println("setB after setB.removeAll(setA): "+setB);
        
        //retainAll()
        setB.add(2);
        setB.add(5);
        setB.add(7);
        System.out.println("setA: "+setA);
        System.out.println("setB: "+setB);
        setB.retainAll(setA);
        System.out.println("setB after setB.retainAll(setA): "+setB);
        
        //finding size of a set
        System.out.println("setA's size: "+setA.size()+" setB's size: "+setB.size());
        
        //checking for an element in a set
        System.out.println("Does setA have 4?: "+setA.contains(4));
        System.out.println("Does setB have 4?: "+setB.contains(4));
        
        //converting a set to a list
        List<Integer> list = new ArrayList<>();
        list.addAll(setB);
        System.out.println("list: "+list);
        
        //check if a set is empty
        setB.clear();
        System.out.println("setB: "+setB);
        
        
    }
}
