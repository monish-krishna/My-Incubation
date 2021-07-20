package collegelibrarayapp;

public interface DigitalLibrary {
    public void checkIn(Student student);
    public int checkSystemAvailability();
    public boolean allotSystem(int system,Student student);
    public void checkOut(int system,Student student);
    public void printCheckedInList();
    default void print(){
        System.out.println();
    }
}
