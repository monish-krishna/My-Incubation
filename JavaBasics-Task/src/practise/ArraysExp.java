package practise;
public class ArraysExp {


    public static void main(String args[]) {
        // Array declaration
        float[] anArray;  //an array of ints with name 'anArray' 
        //or
        int anArray1[];
        
        //intialization
        anArray = new float[10];//default values will be assigned
        
        //creating and initialization
        int[] array1=new int[]{10,20,30,40,50,60,70,80,90};
        //or
        int anArray2[]={10,20,30,40,50,60,70,80,90};
        

        //accessing elements
        int a = array1[0]+array1[1];
        anArray[0]=1;
        System.out.println(anArray[1]);
        
        //using loop for traversing
//        for(int aNum:array1){
//            System.out.print(aNum+" ");
//        }
//        System.out.println();
        //getting length of an array
        int lengthOfArray1=array1.length;
        
        
        //example
        int[] studentsMark = {45,56,67,78,90};
        int sum=0;
        float average=0;
        for(int mark:studentsMark){
            sum=sum+mark;
        }
        average=((float)sum)/studentsMark.length;
        //System.out.println("Average of students mark is "+average);
        
        //Multidimensional array
        //just an array of arrays
        int[][] aTwoDimensionArray ={
                                    {1,2,3,10},
                                    {4,5,6,11},
                                    {7,8,9,12}
                                   };
        
        //length of Multidimension arrya
        int lengthOfTwoD = aTwoDimensionArray.length;
        
        //traversed through a nested loop
        for(int[] subArray : aTwoDimensionArray){
            for(int i:subArray){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        
    }
}
