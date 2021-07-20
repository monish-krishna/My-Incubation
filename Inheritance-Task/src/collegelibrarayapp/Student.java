package collegelibrarayapp;

import java.util.ArrayList;


public class Student {
   private final int registerNo;
   private final String name;
   private final String department;
   private final int year;
   private final int batch;
   private final ArrayList<Book> issuedBooks=new ArrayList<>();
   private final ArrayList<Book> issuedHistory = new ArrayList<>();
   
   Student(String name,int registerNo,String department,int year,int batch){
       this.name=name;
       this.registerNo=registerNo;
       this.department=department;
       this.year=year;
       this.batch=batch;
   }
   
    public String getName(){
     return name;
    }
   
   public int getRegisterNo(){
       return registerNo;
   }
   
   public ArrayList<Book> getIssuedBooks(){
       return issuedBooks;
   }
   
   public ArrayList<Book> getIssuedHistory(){
       return issuedHistory;
   }
   
   @Override
   public String toString(){
       String s = String.format("%-6d | %-5s | %-15s ",registerNo,department,name);
       return s;
   }
   
   public String getDepartment(){
       return department;
   }
}
