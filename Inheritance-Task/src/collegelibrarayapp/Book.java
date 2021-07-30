package collegelibrarayapp;

public class Book {
    private static int nextReference=100;
    private final int referenceNo;
    private final String name;
    private final String authorName;
    private final String stream;
    private boolean availability;
    
    public Book(String name,String authorName,String stream){
        this.name=name;
        this.authorName=authorName;
        this.stream=stream;
        this.referenceNo=++nextReference;
        this.availability=true;
    }
    
    public int getReferenceNo(){
        return referenceNo;
    }
    
    public String getStream(){
        return stream;
    }
    
    public boolean getAvailability(){
        return availability;
    }
    
    public String getName(){
     return name;
    }
    
    public void setAvailability(boolean isAvailable){
        availability=isAvailable;
    }
    
    @Override
    public String toString(){
        String s = String.format("%-11d | %-7s | %-33s | %-22s ",this.referenceNo,this.stream,this.name,this.authorName);
        return s;
    }
}
