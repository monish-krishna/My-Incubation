package practise;
public class LoopingExp {

    public static void main(String args[]) {
        int[] studentsMarks = {56,46,57,78,88,82,90,94,71,67};
       
//        for(int i=0;i<studentsMarks.length;i++){
//            System.out.println("Student "+(i+1)+" : "+studentsMarks[i]+" ");
//        }
//        
        //enhanced for-loop
        int i=0;
//        for(int mark:studentsMarks){
//            System.out.println("Student "+(++i)+" : "+mark+" ");
//        }
        
        //usage of continue and break
        int breaker=5;
//        for(i=0;i<studentsMarks.length;i++){
//            if(i==breaker){
//                continue;
//                //break;
//            }
//            System.out.println("Student "+(i+1)+" : "+studentsMarks[i]+" ");
//        }
        i=0;
//        while(i<studentsMarks.length){
//            if(i==breaker){
//                //continue;
//                break;
//           }
//            System.out.println("Student "+(i+1)+" : "+studentsMarks[i]+" ");
//            i++;
//        }
//        i=0;
//        do{
//            if(i==breaker){
//                //continue;
//                break;
//           }
//            System.out.println("Student "+(i+1)+" : "+studentsMarks[i]+" ");
//            i++;
//        }while(i<studentsMarks.length);

        int[][] studentsMarkBWise = {{56,46,57},{78,88,82,88},{94,71,67}};
        
        outer:
        for(int j=0;j<studentsMarkBWise.length;j++){
            System.out.print("Bench "+j+": ");
            for(int k=0;k<studentsMarkBWise[j].length;k++){
//                System.out.print("["+k+"]"+studentsMarkBWise[j][k]+" ");
                if(k==1){
                    continue outer;
                }
                System.out.print("["+k+"]"+studentsMarkBWise[j][k]+" ");
            }
            System.out.println();
                
        }
    }
}
