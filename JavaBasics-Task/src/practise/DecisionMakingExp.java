package practise;
public class DecisionMakingExp {
    int mark;
    int grade;
    public void generateGrade(){
        if(mark>=90)
            grade='S';
        else if(mark>=80)
            grade='A';
        else if(mark>=70)
            grade='B';
        else if(mark>=60)
            grade='C';
        else
            grade='R';
    }
    
    public void setMark(int mark){
        if(mark<=0)
            System.out.println("Invalid Mark.");    //Assuming mark will not be 0.
        else
            this.mark=mark;
        
//        if(mark>=0)
//            this.mark=mark;
    }
    
    public void printDistinction(){
        switch(grade){
            case 'S':{
                System.out.println("Grade: "+(char)grade);
                System.out.println("Distinction: First class");
                //break;
            }
            case 'A':{
                System.out.println("Grade: "+(char)grade);
                System.out.println("Distinction: First class");
                //break;
            }
            case 'B':{
                System.out.println("Grade: "+(char)grade);
                System.out.println("Distinction: First class");
                //return;
                //break;
            }
            case 'C':{
                System.out.println("Grade: "+(char)grade);
                System.out.println("Distinction: Second class");
                //break;
            }
            default:
                System.out.println("Grade: - .");
        
        
        }
    }
    
   public void printDistinctionAlone(){
       switch(grade){
            case 'S':
            case 'A':
            case 'B':{
                System.out.println("Distinction: First class");
                //return;
                //break;
            }
            case 'C':{
                System.out.println("Distinction: Second class");
                //break;
            }
            default:
                System.out.println("No Distinction.");
       }
   }    
        
    public static void main(String args[]) {
        DecisionMakingExp lp =new DecisionMakingExp();
        lp.setMark(95);
        lp.generateGrade();
        System.out.println("Mark: "+lp.mark);
        lp.printDistinction();
        lp.printDistinctionAlone();
        
    }
}
