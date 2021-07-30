package collegelibrarayapp;

import java.util.HashMap;
import java.util.Scanner;

public class CollegeLibrary {
    private final HashMap<Integer,Book> catalog=new HashMap<>(); 
    
    public void contributeBook(Book book){
        int bookID=book.getReferenceNo();
        catalog.put(bookID, book);
    }
    
    public boolean checkBookAvailability(int refID){
        return catalog.get(refID).getAvailability();
    }
    
    public boolean containsBook(int refID){
        return catalog.containsKey(refID);
    }
    
    public Book getBook(int refID){
        return catalog.get(refID);
    }
    
    public void issueBook(int refID,Student student){
        if(containsBook(refID)){
            Book book = getBook(refID);
            if(book.getAvailability()){
               if(student.canIssueBook()){
                   student.addBook(book);
                   book.setAvailability(false);
                   System.out.println("Book ("+refID+"): "+book.getName()+" is issued to "+student.getName());
               }else System.out.println("You reached your limit. Kindly return an issued book to get another book.");
            }else System.out.println("Currently this book is issued to someone else.");
        }else System.out.println("Book not Found");
    }
    
    public void performReturnAction(Student student,Book book){
        switch(student.getReturnCase(book)){
            case 0: {
                System.out.println("You have no issued books.");
                break;
            }case 1: {
                book.setAvailability(true);
                student.removeBook(book);
                System.out.printf("Book returned: %-4d | %-5s\n",book.getReferenceNo(),book.getName());
                break;
            }case 2: 
                System.out.println("This book isn't issued to you. Book can't be returned.");
         }
    }
    
    public void returnBook(int refID,Student student){
        Book book = catalog.get(refID);
        if(!checkBookAvailability(refID)){
            performReturnAction(student,book);
        }else{
            System.out.println("This book is not issued. Kindly check the Book RefID entered.");
        }
    }
    
    public void printCatalog(){
        System.out.printf("%-11s | %-7s | %-33s | %-22s | %-6s\n","REF. NO.","STREAM","BOOK NAME","AUTHOR NAME","AVAILABILITY");
        for(Book book: catalog.values()){
            System.out.print(book);
            System.out.println((book.getAvailability())?("| Available"):("| Not AVailable"));
        }
    }
    
    public void printIssuedHistory(Student student){
        if(student.getIssuedHistory().size()>0){
            System.out.println(student.getName()+"'s Issued History:");
            System.out.printf("%-11s | %-7s | %-33s | %-22s\n","REF. NO.","STREAM","BOOK NAME","AUTHOR NAME");
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
            System.out.printf("%-11s | %-7s | %-33s | %-22s\n","REF. NO.","STREAM","BOOK NAME","AUTHOR NAME");
            for(Book book:student.getIssuedBooks()){
                System.out.println(book);
            }
        }else{
            System.out.println("No books issued");
        }
    }
    
    public void searchBook(){
        Scanner s = new Scanner(System.in);
        System.out.print("\nSearch by name, no need to type full name of the Book\n"
                + "Type here :");
        String searchText=s.nextLine();
        boolean checker = true;
        for(Book book:catalog.values()){
            if(book.getName().toLowerCase().contains(searchText.toLowerCase())) {
                if(checker){
                System.out.printf("%-11s | %-7s | %-33s | %-22s | %-6s\n","REF. NO.","STREAM","BOOK NAME","AUTHOR NAME","AVAILABILITY");
                }
                System.out.println(book+((book.getAvailability())?("| Available"):("| Not AVailable")));
                checker = false;
            }
        }
        if(checker) {
            System.out.println("Book not Found.");
        }
    }
}
