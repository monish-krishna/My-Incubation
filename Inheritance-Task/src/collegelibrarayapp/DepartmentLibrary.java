package collegelibrarayapp;


public class DepartmentLibrary extends CollegeLibrary {
    private final String department;
    
    DepartmentLibrary(String department){
        this.department=department;
    }
    
    @Override
    public void issueBook(int refID,Student student){
        if(student.getDepartment().equalsIgnoreCase(department)){
            super.issueBook(refID, student);
        }else{
            System.out.println(student.getDepartment()+" students are not allowed to take book from "+department+" library.");
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
    }
}
