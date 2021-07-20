package practise;
public class PrimitiveDataTypes {
    
    int a;
    static int b;
    public static void main(String args[]) {
        
        //variables hold integers
        byte aByte;   //8 bit - ranges from -128 to 127
        short aShort; //16 bit - range: -32,768 to 32767
        int aNum;     //32 bit - range: -2^31 to (2^31)-1
        long aLongNum;//64 bit - range: -2^63 to (2^63)-1
        //System.out.println(Long.MAX_VALUE);
        
        //variables of floating-point values
        float aFloat = 1.5F;
        double aDouble = 1.6D;
        
        //boolean
        boolean aBoolean;
        //only two possible values
        aBoolean=true;
        aBoolean=false;
        
        //char
        char aChar='a';
        //aChar='\u0097';
        //System.out.print((int)aChar);
        
        //default values are assigned to instance and static fields
        //System.out.print((new PrimitiveDataTypes().a));
        //local variable are never assigned with default values.
        
        //LITERALS 
        //Integer literal
        int oneNo;
        long oneLongNo = 2147483648L;
        
        oneNo = 4;   //binary representation
        oneNo = 0b0101;   //hexadecimal representation
        //System.out.println(oneNo);
         System.out.println(Integer.toString(oneNo,2));
        
        //Floating point literals  |^|
        //char, String literal
        //null literal
        
        
        //For readabability UNDERSCORE can be used in integer and floating point literal
        long mobNo = 948_68_02_137L;
        int pinCode = 639_006;
        
        double balance = 1_000_000.125;
        float f = 1.5F;
        
        //casting
        aByte=6;
        int convertedNo = aByte;
        //but can't assign a larger type to a smaller type
        //aByte = ()covertedNo;
        
        //casting required
        aByte = (byte)convertedNo;
    }
}
