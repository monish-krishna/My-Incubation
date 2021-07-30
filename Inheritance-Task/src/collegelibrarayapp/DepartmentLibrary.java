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
    
    public void printTitle(){
        System.out.printf("\n----]| %s DEPARTMENT LIBRARY |[----",department);
    }
    
    public String getDepartment(){
        return department;
    }
    
    public void generateBooks(){
        switch (department) {
            case "EEE":{
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
                break;
            }
            case "MECH":{
                Book book=new Book("Thermodynamics","Sied Abdul","ME");
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
                break;
            }
            case "CSE":{
                Book book = new Book("Head First: Java","Kathy Sierra","CE");
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
                break;
            }
            case "ECE":{
                Book book = new Book("The Art of Electronics","Winfield Hill","ECE");
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
                break;
            }
            case "CIVIL":{
                Book book = new Book("Hydrology","K Subramanya","CVL");
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
                break;
            }
            default:
                break;
        }
    }
}
