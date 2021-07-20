package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
public class ListExplanation {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        //Declaration
        List<Integer> listA = new ArrayList<>();
        
        //adding elements 
        listA.add(2);
        listA.add(4);
        listA.add(6);
        listA.add(null);    //adding null
        listA.add(null);
        System.out.println("List A: "+listA);
        listA.add(3,8); //adding with index mentioned
        System.out.println("List A: "+ listA);
        
        //Inserting elements from one list to another
        List<Integer> listB = new ArrayList<>();
        System.out.println("listB: "+listB);
        listB.addAll(listA);
        System.out.println(listB);
        
        //Inserting elements from one list to another from starting from the specified position
        listB.addAll(2, listA);
        System.out.println(listB); 
        
        //getting elements
        System.out.println("Index 0 of listA: "+listA.get(0));
        
        //updating elements
        System.out.println("listA before updating index '4': "+listA.toString());
        listA.set(4, 10);
        System.out.println("listA after updating index '4': "+listA.toString());
        //Find elements
        //gives first occurence
        System.out.println("Index of '4'in listB: "+listB.indexOf(4));
        //gives last occurance
        System.out.println("Index(Last) of '4' in listB: "+listB.lastIndexOf(4));
        
        //checking for an element in a list
        //Returns 'true' if yes
        System.out.println("listA contains '8': "+listA.contains((Integer)8));
        //else 'false'
        System.out.println("listA contains '11': "+listA.contains((Integer)11));
        
        //removing elements
        //by objects
        listA.add(null);
        System.out.println("listA beforing remove(null) : "+listA.toString());
        listA.remove(null);
        System.out.println("listA after remove(null): "+listA.toString());
        listA.remove((Integer)4);
        listA.remove(null);
        System.out.println("listA again removing null & 4: "+listA.toString());
        //by index
        listA.remove(3);
        System.out.println("After removing index 3, listA: "+listA.toString());
        //removing all elements which are present in another list
        System.out.println("listB: "+listB.toString());
        listB.removeAll(listA);
        System.out.println("listB after removing elements which are in listA also : "+listB.toString());
        //Removing all elements
        listB.clear();
        System.out.println("listB after removing all elements: "+listB.toString());
        
        //checking if a list is empty
        System.out.println("is listB empty?: "+listB.isEmpty());
        //retain all elements
        listA.add(4);
        listA.add(8);
        listB.add(1);
        listB.add(2);
        listB.add(3);
        listB.add(6);
        System.out.println("listA: "+listA.toString());
        System.out.println("listB: "+listB.toString());
        //retaining elements in listA from listB
        listA.retainAll(listB);
        System.out.println("listA: "+listA.toString());
        
        //size of a list
        System.out.println("Size of listA: "+listA.size()+"\nSize of listB: "+listB.size());
        
        //sublisting a list
        listA=listB.subList(1, 4);
        System.out.println("listA: "+listA.toString());
        
        //list to set
        listA.add(2);
        Set<Integer> setA = new HashSet<>();
        System.out.println("listA after adding another '2': "+listA);
        setA.addAll(listA);
        System.out.println("listA to a set, setA: "+setA);
        
        //list to an array
        Integer[] arrayA = new Integer[listA.size()] ;
        arrayA=listA.toArray(arrayA);
        System.out.println("listA to arrayA: "+Arrays.toString(arrayA));
        
        //array to list
        List<Integer> listC = Arrays.asList(arrayA);
        System.out.println("arrayA to listC: "+listC);
        
        //sorting a list
        Collections.sort(listA);
        System.out.println("Sorted listA: "+listA);
        
        //ITERATING A LIST
        // using iterator
        System.out.println("List Iteration:\n(i)Using ListIterator\nForward traversal");
        ListIterator<Integer> iterator = listA.listIterator();  //forward iteration
        while(iterator.hasNext()){
            System.out.println("Index: "+iterator.nextIndex()+" Element: "+iterator.next());
        }
        //reverse iteration
        System.out.println("Reverse traversal: ");
        iterator = listA.listIterator(listA.size());
        while(iterator.hasPrevious()){
            System.out.println("Index: "+iterator.previousIndex()+" Element: "+iterator.previous());
        }
        
        //using for-each
        System.out.println("Traversal using For-each:");
        for(Integer element:listA){
            System.out.print("Element: "+element+" ");
        }
        
        //using for loop
        System.out.println("\nTraversal using for-loop:");
        for(int i=0; i<listA.size(); i++) {
            System.out.print("Element: "+listA.get(i)+" ");
        }
        System.out.println();
        
    }
}
