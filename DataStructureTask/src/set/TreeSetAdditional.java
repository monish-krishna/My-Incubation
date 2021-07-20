package set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetAdditional {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        TreeSet<Integer> tsetA = new TreeSet<>();
        
        tsetA.add(1);
        tsetA.add(10);
        tsetA.add(9);
        tsetA.add(7);
        tsetA.add(5);
        System.out.println("tsetA: "+tsetA+"\n");
        
        //ceiling():-
        System.out.println("ceiling()");
        System.out.println("tsetA.ceiling(4): "+tsetA.ceiling(4));
        System.out.println("tsetA.ceiling(1): "+tsetA.ceiling(1));
        System.out.println("tsetA.ceiling(1): "+tsetA.ceiling(11)+"\n");
        
        //higher()
        System.out.println("higher():-");
        System.out.println("tsetA.higher(5): "+tsetA.higher(5));
        System.out.println("tsetA.higher(10): "+tsetA.higher(10)+"\n");
        
        //floor()
        System.out.println("floor():-");
        System.out.println("tsetA.floor(6): "+tsetA.floor(6));
        System.out.println("tsetA.floor(7): "+tsetA.floor(7));
        System.out.println("tsetA.floor(0): "+tsetA.floor(0)+"\n");
        
        //lower()
        System.out.println("lower():-");
        System.out.println("tsetA.lower(5): "+tsetA.lower(5));
        System.out.println("tsetA.lower(1): "+tsetA.lower(1)+"\n");
        
        //descending iterator
        Iterator<Integer> iterator = tsetA.descendingIterator();
        System.out.print("tsetA: ");
        while(iterator.hasNext()) System.out.print(iterator.next()+" ");
        System.out.println();
        
        //descending set
        Set<Integer> set = tsetA.descendingSet();
        System.out.println("set: "+set+"\n");
                
        //first() & last()
        System.out.println("tsetA: "+tsetA);
        System.out.println("tsetA.first(): "+tsetA.first());
        System.out.println("tsetA.last(): "+tsetA.last()+"\n");
        
        //headSet() 
        System.out.println("headSet():-" );
        System.out.println("tsetA: "+tsetA);
        System.out.println("tsetA.headSet(7): "+tsetA.headSet(7));
        System.out.println("tsetA.headSet(7,true): "+tsetA.headSet(7,true));
        System.out.println("tsetA.headSet(7,false): "+tsetA.headSet(7,false)+"\n");
        
        //tailSet() 
        System.out.println("tailSet():-" );
        System.out.println("tsetA: "+tsetA);
        System.out.println("tsetA.tailSet(7): "+tsetA.tailSet(7));
        System.out.println("tsetA.tailSet(7,true): "+tsetA.tailSet(7,true));
        System.out.println("tsetA.tailSet(7,false): "+tsetA.tailSet(7,false)+"\n");
        
        //subSet()
        System.out.println("subSet():-");
        System.out.println("tsetA.subSet(1,9): "+tsetA.subSet(1, 9));
        System.out.println("tsetA.subSet(1,false,10,false): "+tsetA.subSet(1,false, 10,false)+"\n");
        
        //pollFirst() & pollLast
        System.out.println("pollFirst() & pollLast:-");
        System.out.println("tsetA: "+tsetA);
        System.out.println("tsetA.pollFirst(): "+tsetA.pollFirst());
        System.out.println("tsetA after pollFirst(): "+tsetA);
        System.out.println("tsetA.pollLast(): "+tsetA.pollLast());
        System.out.println("tsetA: "+tsetA);
    }
}
