package collegelibrarayapp;

import java.util.ArrayList;
import java.util.HashMap;

public class CollegeLibrary {
    private final HashMap<Integer,Book> catalog=new HashMap<>(); 
    
    public void contributeBook(Book book){
        int bookID=book.getReferenceNo();
        catalog.put(bookID, book);
    }
    
    public boolean checkAvailability(int refID){
        return catalog.get(refID).getAvailability();
    }
    
    public void issueBook(int refID,Student student){
        if(catalog.containsKey(refID)){
            Book book = catalog.get(refID);
            if(book.getAvailability()){
               ArrayList<Book> issuedList = student.getIssuedBooks();
               int lastIndex = issuedList.size()-1;
               if(lastIndex<2){
                   issuedList.add(book);
                   book.setAvailability(false);
                   System.out.println("Book ("+refID+"): "+book.getName()+" is issued to "+student.getName());
                   student.getIssuedHistory().add(book);
               }else{
                   System.out.println("You reached your limit. Kindly return already issued books to get another book.");
               }
            }else{
                System.out.println("Currently this book is issued to someone else.");
            }
        }else{
            System.out.println("Book not Found");
        }
    }
    
    public void returnBook(int refID,Student student){
        Book book = catalog.get(refID);
        boolean studentChecker=false;
        if(!book.getAvailability()){
            ArrayList<Book> issuedList = student.getIssuedBooks();
            int index=-1;
            if(issuedList.size()>0){
                for(Book issuedBook:issuedList){
                    index++;
                    if(issuedBook.getReferenceNo()==refID){
                        System.out.printf("Book returned: %-4d | %-5s\n",issuedBook.getReferenceNo(),issuedBook.getName());
                        book.setAvailability(true);
                        studentChecker=true;
                        break;
                    }
                }
                if(studentChecker){
                    issuedList.remove(index);
                }else{
                    System.out.println("This book isn't issued to you. Book can't be returned.");
                }
            }else{
                System.out.println("You have no issued books.");
            }
        }else{
            System.out.println("This book is not issued. Kindly check the Book RefID entered.");
        }
    }
    
    public void printCatalog(){
        System.out.printf("%-11s | %-7s | %-30s | %-15s | %-6s\n","REF. NO.","STREAM","BOOK NAME","AUTHOR NAME","Availability");
        for(Book book: catalog.values()){
            System.out.println(book);
        }
    }
    
    public void printIssuedHistory(Student student){
        if(student.getIssuedHistory().size()>0){
            System.out.println(student.getName()+"'s Issued History:");
            System.out.printf("%-11s | %-7s | %-30s | %-15s\n","REF. NO.","STREAM","BOOK NAME","AUTHOR NAME");
            for(Book book:student.getIssuedHistory()){
                System.out.println(book);
            }
        }else{
            System.out.println("No books issued");
        }
    }
    
    public void printIssuedBooks(Student student){
        if(student.getIssuedBooks().size()>0){
            System.out.println(student.getName()+"'s Issued Books:");
            System.out.printf("%-11s | %-7s | %-30s | %-15s\n","REF. NO.","STREAM","BOOK NAME","AUTHOR NAME");
            for(Book book:student.getIssuedBooks()){
                System.out.println(book);
            }
        }else{
            System.out.println("No books issued");
        }
    }
    
    
}
