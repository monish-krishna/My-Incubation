package collegelibrarayapp;


public class LibraryComputer {
    private final int systemNo;
    private Student student;
    private boolean availability;
    
    LibraryComputer(int systemNo){
        this.systemNo=systemNo;
        this.student=null;
        this.availability=true;
    }
    
    public int getSystemNo(){
        return systemNo;
    }
    
    public boolean getSysAvailability(){
        return availability;
    }
    
    public Student getStudent(){
        return student;
    }
    
    public void setSysAvailability(boolean availability){
        this.availability=availability;
    }
    
    public void setStudent(Student student){
        this.student=student;
    }
    
    @Override
    public String toString(){
        String s = String.format("%-10s | %-13s | %-5s", systemNo,(availability)?("Available"):("Not Available"),(availability)?("  -  "):(student.getName()));
        return s;
    }
}
