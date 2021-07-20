package list;

import java.util.Stack;

public class StackExp {

    
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Is stack empty?: "+stack.empty());
        System.out.println("stack: "+stack.toString());
        
        //push(E)
        stack.push(2);
        System.out.println("stack: "+stack.toString());
        System.out.println("Is stack empty now?: "+stack.empty());
        stack.push(4);
        stack.push(5);
        
        //peek()
        System.out.println("stack: "+stack.toString());
        System.out.println("stack.peek(): "+stack.peek());
        
        //search(E)
        System.out.println("stack.search(5): "+stack.search(5));
        System.out.println("stack.search(2): "+stack.search(2));
        
        //pop()
        System.out.println("stack: "+stack.toString());
        System.out.println("stack.pop(): "+stack.pop());
        System.out.println("stack: "+stack.toString());
    }
}
