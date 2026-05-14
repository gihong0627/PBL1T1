
/**
 * Student 성적 처리를 위한 기본적인 요소를 
 *         갖춘 학생 객체를 생성하기위한 클래스
 *
 * @author (2021320032 임기홍)
 * @version (2026 05 07)
 */
public class Student
{
    private String name;
    private String st_id;
    private int midTest;     
    private int finalTest;   
    private int assignment; 
    private int attendance; 
    private double totalScore; 
    private String grade;

    /**
     * Student 클래스의 객체 생성자
     */
    public Student(String name, String st_id,
                   int midTest, int finalTest,
                   int assignment, int attendance)
    {
        this.name = name;
        this.st_id = st_id;
        this.midTest = midTest;
        this.finalTest = finalTest;
        this.assignment = assignment;
        this.attendance = attendance;
        this.grade = "";
        calcTotalScore(); 
    }
    
    /**
     * 메소드 calcTotalScore 총점수를 계산하는 메소드
     *
     */
    public void calcTotalScore() {
        this.totalScore = this.midTest * 0.35 + finalTest * 0.35
                        + assignment + attendance;
        if(attendance <= 0){
            this.grade = "F";
        }
    }
    
    /**
     * 메소드 setGrade 학점 등급을 부여하는 메소드
     *
     * @param grade 문자열로 이루어진 학점 등급
     */
    public void setGrade(String grade) {
        this.grade = grade;
    } 
    
    /**
     * 메소드 getStId 학점을 반환하는 메소드
     *
     * @return 학점
     */
    public String getStId()  { 
        return st_id; 
    }
    
    /**
     * 메소드 getName 이름을 반환하는 메소드
     *
     * @return 이름
     */
    public String getName()  { 
        return name; 
    }
    
    /**
     * 메소드 getTotalScore 총점수를 반환하는 메소드
     *
     * @return 총점수
     */
    public double getTotalScore() { 
        return totalScore; 
    }
    
    /**
     * 메소드 getGrade 학점 등급을 반환하는 메소드
     *
     * @return 학점 등급
     */
    public String getGrade() { 
        return grade; 
    }
}
