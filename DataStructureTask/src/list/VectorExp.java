
package list;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class VectorExp {

    public static void main(String args[]) {
        Vector<Integer> vectorA = new Vector<>();
        List<Integer> vectorB = new Vector<>();
        
        vectorA.add(1);
        vectorA.add(2);
        vectorA.add(4);
        vectorA.add(3);
        vectorA.add(5);
        
        vectorB.add(2);
        vectorB.add(3);
        vectorB.add(5);
        
        System.out.println("vectorA: "+vectorA.toString());
        System.out.println("vectorB: "+vectorB.toString());
        
        //containsAll()
        System.out.println("vectorA containsAll vetorB: "+vectorA.containsAll(vectorB));
        vectorA.remove((Integer)2);
        
        System.out.println("vectorA: "+vectorA.toString());
        System.out.println("vectorB: "+vectorB.toString());
        System.out.println("vectorA containsAll vetorB: "+vectorA.containsAll(vectorB));
        
        //copyInto()
        Integer[] array1 = new Integer[vectorA.size()];
        vectorA.copyInto(array1);
        System.out.println("array1: "+Arrays.toString(array1));
        
        //elementAt() similar to get()
        System.out.println("elementAt(3): "+vectorA.elementAt(3)+"\nget(3): "+vectorA.get(3));
        
        //firstElement() & lastElement()
        System.out.println("vectorA.firstElement(): "+vectorA.firstElement());
        System.out.println("vectorA.lastElement(): "+vectorA.lastElement());
        
        //insertElementAt(E,int) similar to add(int, E)
        vectorA.insertElementAt(7, 2);
        System.out.println("vectorA: "+vectorA.toString());
        
        //removeElement(E) |||r to remove(E)
        vectorA.remove((Integer)7);
        System.out.println("vectorA: "+vectorA.toString());
        
        //removeElement(int) |||r to remove(int)
        vectorA.remove(1);
        System.out.println("vectorA: "+vectorA.toString());
        
        
    }
}
