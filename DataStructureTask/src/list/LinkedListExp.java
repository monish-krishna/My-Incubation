package list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExp {

    public static void main(String args[]) {
        LinkedList<Integer> llA = new LinkedList<>();
        llA.add(1);
        llA.add(3);
        llA.add(5);
        llA.addFirst(0);
        llA.addLast(7);
        System.out.println("llA: "+llA.toString());
        
        //element() returns head of the LL
        System.out.println("llA.element(): "+llA.element());
        
        //get()
        System.out.println("llA.get(1): "+llA.get(1));
        System.out.println("llA.getFirst(): "+llA.getFirst());
        System.out.println("llA.getLast(): "+llA.getLast());
        
        //offer() similar to add()
        llA.offer(9);
        llA.offerFirst(-1);
        llA.offerLast(11);
        System.out.println("llA after offer() methods: "+llA.toString());
        
        //peek() similar to get()
        System.out.println("llA.peek(): "+llA.peek());
        System.out.println("llA.peekFirst(): "+llA.peekFirst());
        System.out.println("llA.peekLast(): "+llA.peekLast());
        
        //poll() methods
        System.out.println("llA.poll(): "+llA.poll());
        System.out.println("llA.pollFirst(): "+llA.pollFirst());
        System.out.println("llA.pollLast(): "+llA.pollLast());
        System.out.println("llA: "+llA.toString());
        
        //pop() & push()
        System.out.println("llA.pop(): "+llA.pop());
        System.out.println("llA after llA.pop(): "+llA.toString());
        llA.push(0);
        System.out.println("llA after llA.push(0): "+llA.toString());
        
        //removeFirst() & removeLast()
        System.out.println("llA.removeFirst(): "+llA.removeFirst());
        System.out.println("llA.removeLast(): "+llA.removeLast());
        System.out.println("llA after removeFirst() & removeLast(): "+llA.toString());
        
        //removeFirstOccurence() & removeLastOccurence()
        llA.offerLast(3);
        llA.offer(7);
        System.out.println("llA before removing first occurence of 7: "+llA.toString());
        llA.removeFirstOccurrence(7);
        System.out.println("llA after removing first occurence of 7: "+llA.toString());
        System.out.println("llA before removing last occurence of 3: "+llA.toString());
        llA.removeLastOccurrence(3);
        System.out.println("llA after removing last occurence of 3: "+llA.toString());
        
        Iterator<Integer> iterator = llA.descendingIterator();
        System.out.print("llA:");
        while(iterator.hasNext()) System.out.print("Element: "+iterator.next()+" ");
    }
}
