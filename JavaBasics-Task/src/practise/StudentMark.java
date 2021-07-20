package practise;
public class StudentMark {
    String studentName;
    int rollNo;
    int mathsMark;
    int tamilMark;
    int englishMark;
    int scienceMark;
    int socialScienceMark;
    int total;
    boolean passStatus;
    static final int MAX_MARK = 100;
    static final int MIN_MARK = 25;
    
    StudentMark(String name,int rollNo){
        studentName=name;
        this.rollNo=rollNo;
    }
    
    void setMarks(int maths,int tamil,int english,int science,int socialScience){
        this.mathsMark=maths;
        this.tamilMark=tamil;
        this.englishMark=english;
        this.scienceMark=science;
        this.socialScienceMark=socialScience;
    }
    
    int getTotal(){
        total=mathsMark + tamilMark +englishMark + scienceMark + socialScienceMark;
        return total;
    }
    
    int getAverage(){
        int average;
        average=total/5;
        return average;
    }
}
