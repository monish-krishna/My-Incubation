package practise;
public class VariableNaming {
    
    static final int MAX_LIMIT=5;
    public static void main(String args[]) {
        //case sensitive
        int varible;
        int aVariable;
        
        //must not be a keyword
        //int long;
        
        //length is unlimited
        int abcdefghijklmnopqrstuvwxyz1234567890;
        
        //can begin with letter, $ dollarSign, _ underscore
        int a123;
        int $aNum;  //not recommended   by convention
        int _aNum;  //not recommended   by convention
        //but can't start with a number
        //int 2ndNumber;
        
        //CONVENTIONS
        //use readable names
        //instead of 
        int m;
        //use readable names
        int maximumNumber;
        
        //lowercase letter for variables
        int number;
        //if more than one word use camelCase
        int aNumber;
    }
}
