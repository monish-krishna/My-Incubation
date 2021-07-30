package collegelibrarayapp;

import java.util.HashMap;
import java.util.Scanner;

public class LibraryRunner {
    private final HashMap<Integer,Student> studentList = new HashMap<>();
    private final CommonLibrary cL = new CommonLibrary(5);
    private final DepartmentLibrary eeL = new DepartmentLibrary("EEE");
    private final DepartmentLibrary meL = new DepartmentLibrary("MECH");
    private final DepartmentLibrary cvL = new DepartmentLibrary("CIVIL");
    private final DepartmentLibrary ecL = new DepartmentLibrary("ECE");
    private final DepartmentLibrary ceL = new DepartmentLibrary("CSE");
    private final Scanner s = new Scanner(System.in);
    
    public void addStudents(String name,int regNo,String department,int year,int batch){
        Student student = new Student(name,regNo,department,year,batch);
        studentList.put(regNo, student);
    }
    
    public void generateStudentList(){
        addStudents("Monish Krishna S", 17001, "EEE", 4, 2021);
        addStudents("Saravanan C", 17002,"EEE",3,2022);
        addStudents("Srinath S",17003, "EEE",2,2023);
        addStudents("Prithiviraj R",17004,"EEE",1,2024);
        addStudents("Thanigai B",18001,"MECH",4,2021);
        addStudents("Logeshan C",18002,"MECH",3,2022);
        addStudents("Hari V",18003, "MECH",2,2023);
        addStudents("Balaji S",18004,"MECH",1,2024);
        addStudents("Vishu B",19001,"CSE",4,2021);
        addStudents("Vetri S",19002,"CSE",3,2022);
        addStudents("Vallavan",19003,"CSE",2,2023);
        addStudents("Vijay N",19004,"CSE",1, 2024);
    }
    
    public void generateBooks(){
        cL.generateBooks();
        eeL.generateBooks();
        meL.generateBooks();
        cvL.generateBooks();
        ecL.generateBooks();
        ceL.generateBooks();
    }
    
    public byte getActionLibrary(){
        System.out.print("------]| LIBRARY APPLICATION |[------\n"
                + "1 - Common Library\n"
                + "2 - Department Library\n"
                + "0 - Exit Application\n-> ");
            
        return s.nextByte();
    }
    
    public byte getActionCommonLibrary(){
        System.out.println("\n----]| COMMON LIBRARY |[----");
        System.out.print("\n"
                + "1 - Use Reading Library\n"
                + "2 - Use Digital Library\n"
                + "0 - Exit Common Library\n-> ");
        return s.nextByte();
        
    }
    
    public byte getActionLibrary(boolean LibraryType){
        if(LibraryType) 
            System.out.print("\n----]| COMMON LIBRARY |[----");
        System.out.print("\n"
            + "1 - Issue Book\n"
            + "2 - Return Book\n"
            + "3 - Print catalog\n"
            + "4 - See student's issued Books\n"
            + "5 - See student's issued history\n"
            + "6 - Check Book availability\n"
            + "7 - Search Book by Name\n"
            + "0 - Exit\n-> ");
        return s.nextByte();
        
    }
    
    public byte getActionDigitalLibrary(){
        System.out.print("\n"
                + "----]| DIGITAL LIBRARY in Common Library |[----\n\n"
                + "1 - Check In\n"
                + "2 - Check Out\n"
                + "3 - Check System Availability\n"
                + "4 - List Checked In students\n"
                + "5 - List Systems\n"
                + "0 - Exit\n-> ");
        return s.nextByte();
    }
    
    public int getRefID(){
        int refID;
        System.out.print("Enter Book reference ID: ");
        refID=s.nextInt();
        return refID;
    }
    
    public int getRegNo(){
        int regNo;
        System.out.print("Enter student register no.: ");
        regNo=s.nextInt();
        return regNo;
    }
    
    public int getSystemNo(){
        int sysNo;
        System.out.print("Enter your System no.: ");
        sysNo=s.nextInt();
        return sysNo;
    }
    
    public void printSystems(CommonLibrary cL){
        System.out.printf("1 - Print all systems\n"
                + "2 - Print Available Systems\n"
                + "3 - Print pre-occupied systems\n->");
        byte action=s.nextByte();
        switch(action){
            case 1:{
                cL.printSystemList();
                break;
            }case 2:{
                cL.printSystemList(true);
                break;
            }case 3:{
                cL.printSystemList(false);
                break;
            }default: System.out.println("Invalid Input.");
        }
    }
    
    public void runDigitalLibrary(CommonLibrary cL){
        loopWhile: while(true){
            byte actionDL = getActionDigitalLibrary();
            switch(actionDL){
                case 1:{
                    int regNo = getRegNo();
                    Student student = studentList.get(regNo);
                    cL.checkIn(student);
                    break;
                }
                case 2:{
                    int sysNo = getSystemNo();
                    int regNo = getRegNo();
                    Student student = studentList.get(regNo);
                    cL.checkOut(sysNo, student);
                    break;
                }
                case 3:{
                    cL.checkSystemAvailability();
                    break;
                }
                case 4:{
                    cL.printCheckedInList();
                    break;
                }case 5:{
                    printSystems(cL);
                    break;
                }
                case 0:{
                    break loopWhile;
                }default: System.out.println("Invalid Input.");
            }
        }
    }
    
    public void runLibrary(CollegeLibrary cL){
        loopWhile: while(true){
            if(cL instanceof DepartmentLibrary) ((DepartmentLibrary) cL).printTitle();
            byte actionCL = getActionLibrary(cL instanceof CommonLibrary);
            switch(actionCL){
                case 1:{
                    int refID=getRefID();
                    int regNo = getRegNo();
                    cL.issueBook(refID,studentList.get(regNo));
                    break;
                }
                case 2:{
                    int refID=getRefID();
                    int regNo = getRegNo();
                    cL.returnBook(refID, studentList.get(regNo));
                    break;
                }
                case 3:{
                    cL.printCatalog();
                    break;
                }
                case 4:{
                    Student student =studentList.get(getRegNo());
                    cL.printIssuedBooks(student);
                    break;
                }
                case 5:{
                    Student student =studentList.get(getRegNo());
                    cL.printIssuedHistory(student);
                    break;
                }case 6:{
                    int refID = getRefID();
                    if(cL.checkBookAvailability(refID)){
                        System.out.println("Book is available.");
                    }else{
                        System.out.println("Book is currently not available.");
                    }
                    break;
                }case 7:{
                    cL.searchBook();
                    break;
                }case 0:{
                    break loopWhile;
                }default: System.out.println("Invalid Input.");
            }
        }
    }
    
    public void runCommonLibrary(CommonLibrary cL){
        loopWhile: while(true){
            switch(getActionCommonLibrary()){
                case 1:{
                    runLibrary(cL);
                    break;
                }case 2:{
                    runDigitalLibrary(cL);
                    break;
                }case 0:{
                    break loopWhile;
                }default: System.out.println("Invalid Input.");
            }
        }
    }
    
    public DepartmentLibrary getDepartment(){
        System.out.print("\n"
                + "1 - EEE\n"
                + "2 - MECH\n"
                + "3 - CIVIL\n"
                + "4 - CSE\n"
                + "5 - ECE\n-> ");
        switch(s.nextByte()){
            case 1: {
                return eeL;}
            case 2: {
                return meL;}
            case 3: {
                return cvL;}
            case 4: {
                return ceL;}
            case 5: {
                return ecL;}
            default: System.out.println("Invalid Input.");
        }
        return eeL;
    }
    
    public void runLibrary(){
        generateStudentList();
        generateBooks();
        loopWhile: while(true){
            byte action = getActionLibrary();
            switch(action){
                case 1:{
                    runCommonLibrary(cL);
                    break;
                }
                case 2:{
                    runLibrary(getDepartment());
                    break;
                }
                case 0:{
                    break loopWhile;
                }default: System.out.println("Invalid Input.");
            }
        }
    }
    
    public static void main(String args[]) {
        LibraryRunner lRunner = new LibraryRunner();
        lRunner.runLibrary();
    }
}
