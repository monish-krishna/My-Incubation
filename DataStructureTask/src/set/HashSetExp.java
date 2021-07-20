package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetExp {

    public static void main(String args[]) {
        //creating a set
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();
        
        //adding elements
        setA.add("Z");
        setA.add("X");
        setA.add("A");
        setA.add("a");
        setA.add("b");
        System.out.println("setA: "+setA);
        setA.add("Ba");
        setA.add("X");
        System.out.println("setA: "+setA);
        //can add null
        setA.add(null);
        
        //Iterating through a set
        //using Iterator
        Iterator<String> iterator = setA.iterator();
        System.out.print("setA: ");
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        //using For-Each
        System.out.print("setA: ");
        for(String element:setA){
            System.out.print(element+" ");
        }System.out.println();
        
        //removing element from the set
        setA.remove(null);
        System.out.println("setA: "+setA);
        
        //removing all elements
        setA.clear();
        System.out.println("setA: "+setA);
        
        //add all elements from another collection
        setA.add("10");
        setA.add("5");
        setB.add("3");
        setB.add("2");
        setB.add("8");
        setB.add("4");
        setB.add("6");
        setA.addAll(setB);
        System.out.println("setA: "+setA);
        
        
        //remove all elements from another collection
        setB.add("9");
        setB.add("11");
        System.out.println("setB: "+setB);
        setB.removeAll(setA);
        System.out.println("setB after setB.removeAll(setA): "+setB);
        
        //retainAll()
        setB.add("2");
        setB.add("5");
        setB.add("7");
        System.out.println("setA: "+setA);
        System.out.println("setB: "+setB);
        setB.retainAll(setA);
        System.out.println("setB after setB.retainAll(setA): "+setB);
        
        //finding size of a set
        System.out.println("setA's size: "+setA.size()+" setB's size: "+setB.size());
        
        //checking for an element in a set
        System.out.println("Does setA have 4?: "+setA.contains("4"));
        System.out.println("Does setB have 4?: "+setB.contains("4"));
        
        //converting a set to a list
        List<String> list = new ArrayList<>();
        list.addAll(setB);
        System.out.println("list: "+list);
        
        //check if a set is empty
        setB.clear();
        System.out.println("setB: "+setB);
    }
}
