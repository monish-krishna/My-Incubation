package collegelibrarayapp;

import java.util.HashMap;
import java.util.HashSet;

public class CommonLibrary extends CollegeLibrary implements DigitalLibrary{
    private final HashMap<Integer,LibraryComputer> systemList=new HashMap<>();
    private final HashSet<Student> checkedInList = new HashSet<>();
    
    CommonLibrary(int systemCount){
        for(int i=1; i<=systemCount;i++){
            LibraryComputer system=new LibraryComputer(i);
            systemList.put(i,system);
        }
    }
    
    @Override
    public void checkIn(Student student){
        int systemNo=checkSystemAvailability();
        if(systemNo>0&&allotSystem(systemNo,student)){
            System.out.println(student.getName()+", your system is "+systemNo+".");
        }
    }
    
    @Override
    public int checkSystemAvailability(){
        for(LibraryComputer system:systemList.values()){
            if(system.getSysAvailability()){
                System.out.println("System is available.");
                return system.getSystemNo();
            }
        }
        System.out.println("No system is currently available.");
        return -1;
    }
    
    @Override
    public boolean allotSystem(int systemNo,Student student){
        boolean isAllot=checkedInList.add(student);
        if(isAllot){
            LibraryComputer system = systemList.get(systemNo);
            system.setSysAvailability(!isAllot);
            system.setStudent(student);
            return true;
        }else{
            System.out.println("But You have already been checked In.");
        }
        return false;
    }
    
    @Override
    public void checkOut(int systemNo,Student student){
        LibraryComputer system = systemList.get(systemNo);
        if(systemList.containsKey(systemNo)&&(checkedInList.contains(student))&&system.getStudent().equals(student)){
            system.setSysAvailability(true);
            system.setStudent(null);
            checkedInList.remove(student);
            System.out.println(student.getName()+", you have been checked out.");
        }else if(!checkedInList.contains(student)){
            System.out.println("You haven't Checked In.");
        }else{
            System.out.println("Wrong input credintials.");
        }
    }
    
    @Override
     public void printCheckedInList(){
         System.out.println("Checked In List:-");
         if(checkedInList.size()>0){
             System.out.printf("%-6s | %-5s | %-15s \n","REG.NO","DEPT","NAME");
             for(Student student:checkedInList) System.out.println(student);
         }else{
             System.out.println("Nobody has Checked In currently.");
         }
     }
     
     public void printSystemList(){
         System.out.printf("%-10s | %-13s | %-5s\n","SYSTEM NO.","AVAILABILITY","PERSON LOGGED IN");
         for(LibraryComputer system:systemList.values()){
             System.out.println(system);
         }
     }
     
     public void printSystemList(boolean availability){
         int checker=0;
         for(LibraryComputer system:systemList.values()){
             if(system.getSysAvailability()==availability){
                 if(checker==0) System.out.printf("%-10s | %-13s | %-5s\n","SYSTEM NO.","AVAILABILITY","PERSON LOGGED IN");
                 System.out.println(system);
                 checker++;
             }
         }
         if(checker==0) {
             System.out.println((availability)?("No available systems are there currently."):("All systems are currently available."));
         }
     }
    
     public void generateBooks(){
        Book book = new Book("Fundamentals of Electricals","Paul","EE");
        contributeBook(book);
        book=new Book("Theory of Circuits","Sundar","EE");
        contributeBook(book);
        book=new Book("Electrical Machines","Gupta","EE");
        contributeBook(book);
        book=new Book("Control Systems","Gopal M","EE");
        contributeBook(book);
        book=new Book("Analog and Digital Electronics","Amuthan G","EE");
        contributeBook(book);
        book=new Book("Thermodynamics","Sied Abdul","ME");
        contributeBook(book);
        book=new Book("Engineering Graphics","SRaja Vijay","ME");
        contributeBook(book);
        book=new Book("Head First","Kathy Sierra","CE");
        contributeBook(book);
    }
}
