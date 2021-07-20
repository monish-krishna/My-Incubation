package collegelibrarayapp;

import java.util.HashMap;
import java.util.Scanner;

public class LibraryRunner {
    private final HashMap<Integer,Student> studentList = new HashMap<>();
    
    public void addStudents(String name,int regNo,String department,int year,int batch){
        Student s = new Student(name,regNo,department,year,batch);
        studentList.put(regNo, s);
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
    
    public byte getActionCommonLibrary(){
        Scanner s= new Scanner(System.in);
        System.out.print("\nIssue Book - 1\n"
                + "Return Book - 2\n"
                + "Print catalog - 3\n"
                + "See student's issued Books - 4\n"
                + "See student's issued history - 5\n"
                + "Check Book availability - 6\n"
                + "Use Digital Library - 7\n"
                + "Exit - 0\n->");
        return s.nextByte();
        
    }
    
    public byte getActionDepartmentLibrary(){
        Scanner s= new Scanner(System.in);
        System.out.print("\nIssue Book - 1\n"
                + "Return Book - 2\n"
                + "Print catalog - 3\n"
                + "See student's issued Books - 4\n"
                + "See student's issued history - 5\n"
                + "Check Book availability - 6\n"
                + "Exit - 0\n->");
        return s.nextByte();
        
    }
    
    public byte getActionDigitalLibrary(){
        Scanner s= new Scanner(System.in);
        System.out.print("\nCheck In - 1\n"
                + "Check Out - 2\n"
                + "Check System Availability - 3\n"
                + "List Checked In students - 4\n"
                + "List Systems - 5\n"
                + "Exit - 0\n->");
        return s.nextByte();
    }
    
    public int getRefID(){
        Scanner s = new Scanner(System.in);
        int refID;
        System.out.print("Enter Book reference ID: ");
        refID=s.nextInt();
        return refID;
    }
    
    public int getRegNo(){
        Scanner s = new Scanner(System.in);
        int regNo;
        System.out.print("Enter student register no.: ");
        regNo=s.nextInt();
        return regNo;
    }
    
    public int getSystemNo(){
        Scanner s = new Scanner(System.in);
        int sysNo;
        System.out.print("Enter your System no.: ");
        sysNo=s.nextInt();
        return sysNo;
    }
    
    
    
    
    
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        LibraryRunner lRunner = new LibraryRunner();
        lRunner.generateStudentList();
        CommonLibrary cL = new CommonLibrary(4);
        cL.generateBooks();
        DepartmentLibrary dL = new DepartmentLibrary("EEE");
        dL.generateBooks();
        boolean exitStatus=true;
        while(exitStatus){
            byte libraryNo;
            System.out.print("------]| LIBRARY APPLICATION |[------\nCommon Library - 1\nDepartment Library - 2\nExit Application-0\n->");
            libraryNo=s.nextByte();
            switch(libraryNo){
                case 1:{
                    boolean exitStatusCL=true;
                    while(exitStatusCL){
                        System.out.println("----]| COMMON LIBRARY |[----");
                        byte actionCL = lRunner.getActionCommonLibrary();
                        switch(actionCL){
                            case 1:{
                                int refID=lRunner.getRefID();
                                int regNo = lRunner.getRegNo();
                                cL.issueBook(refID,lRunner.studentList.get(regNo));
                                break;
                            }
                            case 2:{
                                int refID=lRunner.getRefID();
                                int regNo = lRunner.getRegNo();
                                cL.returnBook(refID, lRunner.studentList.get(regNo));
                                break;
                            }
                            case 3:{
                                cL.printCatalog();
                                break;
                            }
                            case 4:{
                                Student student =lRunner.studentList.get(lRunner.getRegNo());
                                cL.printIssuedBooks(student);
                                break;
                            }
                            case 5:{
                                Student student =lRunner.studentList.get(lRunner.getRegNo());
                                cL.printIssuedHistory(student);
                                break;
                            }case 6:{
                                int refID = lRunner.getRefID();
                                if(cL.checkAvailability(refID)){
                                    System.out.println("Book is available.");
                                }else{
                                    System.out.println("Book is currently not available.");
                                }
                                break;
                            }case 7:{
                                System.out.println("----]| DIGITAL LIBRARY in Common Library |[----");
                                boolean exitStatusDL=true;
                                while(exitStatusDL){
                                    byte actionDL = lRunner.getActionDigitalLibrary();
                                    switch(actionDL){
                                        case 1:{
                                            int regNo = lRunner.getRegNo();
                                            Student student = lRunner.studentList.get(regNo);
                                            cL.checkIn(student);
                                            break;
                                        }
                                        case 2:{
                                            int sysNo = lRunner.getSystemNo();
                                            int regNo = lRunner.getRegNo();
                                            Student student = lRunner.studentList.get(regNo);
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
                                            System.out.printf("Print all systems - 1\nPrint Available Systems - 2\nPrint pre-occupied systems - 3\n->");
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
                                                }
                                            }
                                            break;
                                        }
                                        case 0:{
                                            exitStatusDL=false;
                                        }
                                    }
                                }
                                break;
                            }
                            case 0:{
                                exitStatusCL=false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2:{
                    boolean exitStatusDL=true;
                    while(exitStatusDL){
                        System.out.println("----]| DEPARTMENT LIBRARY |[----");
                        byte actionCL = lRunner.getActionDepartmentLibrary();
                        switch(actionCL){
                            case 1:{
                                int refID=lRunner.getRefID();
                                int regNo = lRunner.getRegNo();
                                dL.issueBook(refID,lRunner.studentList.get(regNo));
                                break;
                            }
                            case 2:{
                                int refID=lRunner.getRefID();
                                int regNo = lRunner.getRegNo();
                                dL.returnBook(refID, lRunner.studentList.get(regNo));
                                break;
                            }
                            case 3:{
                                dL.printCatalog();
                                break;
                            }
                            case 4:{
                                Student student =lRunner.studentList.get(lRunner.getRegNo());
                                dL.printIssuedBooks(student);
                                break;
                            }
                            case 5:{
                                Student student =lRunner.studentList.get(lRunner.getRegNo());
                                dL.printIssuedHistory(student);
                                break;
                            }case 6:{
                                int refID = lRunner.getRefID();
                                if(dL.checkAvailability(refID)){
                                    System.out.println("Book is available.");
                                }else{
                                    System.out.println("Book is currently not available.");
                                }
                                break;
                            }
                            case 0:{
                                exitStatusDL=false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 0:{
                    exitStatus=false;
                }
            }
        }
    }
}
