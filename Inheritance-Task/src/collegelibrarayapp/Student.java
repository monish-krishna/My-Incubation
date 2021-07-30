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
   
   public int countIssuedBooks(){
       return issuedBooks.size();
   }
   
   public boolean haveIssuedBook(Book book){
       return issuedBooks.contains(book);
   }
   
   public byte getReturnCase(Book book){
       if(issuedBooks.isEmpty()) return 0;
       else if(issuedBooks.contains(book)) return 1;
       return 2;
   }
   
   public void addBook(Book book){
       issuedBooks.add(book);
       issuedHistory.add(book);
   }
   
   public void removeBook(Book book){
       issuedBooks.remove(book);
   }
   
   public boolean canIssueBook(){
       return (issuedBooks.size()>=0&&issuedBooks.size()<3);
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
