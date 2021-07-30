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
        Book book = new Book("Fundamentals of Electricals","Charles A. Gross","EE");
        contributeBook(book);
        book=new Book("Theory of Circuits","Sudhakar & Shyam Mohan","EE");
        contributeBook(book);
        book=new Book("Electrical Machines","J P Gupta","EE");
        contributeBook(book);
        book=new Book("Control Systems","Gopal M","EE");
        contributeBook(book);
        book=new Book("Analog and Digital Electronics","Amuthan G","EE");
        contributeBook(book);
        book=new Book("Thermodynamics","R K Rajput","ME");
        contributeBook(book);
        book=new Book("Engineering Graphics","S Raja Vijay","ME");
        contributeBook(book);
        book = new Book("Fluid Mechanics","R K Bansal","ME");
        contributeBook(book);
        book = new Book("Fundamendals of Thermodynamics","J K Gupta","ME");
        contributeBook(book);
        book = new Book("Internal Combustion Engines","V Ganesan","ME");
        contributeBook(book);
        book = new Book("Power Plant Engineering","P K Nag","ME");
        contributeBook(book);
        book = new Book("Head First: Java","Kathy Sierra","CE");
        contributeBook(book);
        book = new Book("Let Us C","Yashavant Kaneetkar","CE");
        contributeBook(book);
        book = new Book("Data Structures and Algorithms","Ronald Rivest","CE");
        contributeBook(book);
        book = new Book("Introduction to algorithms","Thomas H. Cormen","CE");
        contributeBook(book);
        book = new Book("The C Programming Language","Brian W. Kernighan","CE");
        contributeBook(book);
        book = new Book("Design Patterns","Richard Helm","CE");
        contributeBook(book);
        book = new Book("The Art of Electronics","Winfield Hill","ECE");
        contributeBook(book);
        book = new Book("Low Power Electronics Design","Christien Piguet","ECE");
        contributeBook(book);
        book = new Book("Integrated Circuits","Shail B Jain","ECE");
        contributeBook(book);
        book = new Book("Modern Digital Electronics","R P Jain","ECE");
        contributeBook(book);
        book = new Book("Microprocessor Architeture 8085","Ramesh S Gaonkar","ECE");
        contributeBook(book);
        book = new Book("Analog and Digital Communications","Simon Y Haykin","ECE");
        contributeBook(book);
        book = new Book("Hydrology","K Subramanya","CVL");
        contributeBook(book);
        book = new Book("Soil Mechanics and Foundations","B C Punmia","CVL");
        contributeBook(book);
        book = new Book("Reinforced Concrete Design","S Pillai","CVL");
        contributeBook(book);
        book = new Book("Surveying Vol I","B C Punmia","CVL");
        contributeBook(book);
        book = new Book("Surveying Vol II","B C Punmia","CVL");
        contributeBook(book);
        book = new Book("Concrete Technology","M S Shetty","CVL");
        contributeBook(book);
        book = new Book("Engineering Drawing","Bhasant Agrawal","CVL");
        contributeBook(book);
    }
}
