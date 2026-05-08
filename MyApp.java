import java.util.Scanner;
/**
 * MyApp 성적 처리 소프트웨어 실행 클래스.
 *
 * @author (2021320032 임기홍)
 * @version (2026 05 08)
 */
public class MyApp
{
    static Scanner gradeSC = new Scanner(System.in);


    /**
     * 메소드 main
     *
     * @param  args 파라미터
     * 
     */
    public static void main(String[] args){
        
        Student[][] stdb = new Student[10][200];
        int[] counts = new int[10];
        
        while(true){
            
            System.out.println("-----성적 처리 프로그램-----");
            System.out.println("1.학생 등록 \t 2.학점 부여");
            System.out.println("3.성적 출력 \t 4.종료");
            System.out.println("-------------------------");
            System.out.println("번호를 입력해주세요 : ");
            
            int choice;
            try{
                choice = Integer.parseInt(gradeSC.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("숫자를 입력해주세요");
                continue;
            }
            
            switch(choice){
                case 1:
                    System.out.println(registerStudents(stdb, counts));
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    {
                        System.out.println("프로그램을 종료합니다");
                        System.exit(1);
                    }
                default:
                    System.out.println("1~4 숫자만 선택해주세요");
            }
        }
    }
    
    /**
     * 메소드 registerStudents
     *
     * @param stdb 과목별 학생들이 저장되어있는 2차원 배열
     * @param counts 선택한 과목 코드 내 현재 학생수 파악을 위한 카운트 배열
     * @return 문자열 반환
     */
    public static String registerStudents(Student[][] stdb, int[] counts){
        
        System.out.println("과목 코드(0~9)를 입력해주세요");
        
        int code;
        try{
            code = Integer.parseInt(gradeSC.nextLine());
        }
        catch(NumberFormatException e){
            return "숫자를 입력해주세요";
        }
        
        if(code <0 || code >9){
            return "0~9 범위로 입력해주세요";
        }
        else if(counts[code] > 200){
            return "해당 과목은 정윈(200명) 초과입니다";
        }
        
        while(counts[code] <= 200){
            
            System.out.println("학생 등록시 1 종료시 0을 입력해주세요");
            int next = Integer.parseInt(gradeSC.nextLine());
            
            if(next == 0){
                break;
            }
                
            System.out.println("이름 학번 중간 기말 과제 출석 순서로 입력해주세요");
            System.out.println("예)임기홍 2021320032 100 100 20 10");
            
            String name = gradeSC.next();
            String st_id = gradeSC.next();
            int mid = gradeSC.nextInt();
            int fin = gradeSC.nextInt();
            int assign = gradeSC.nextInt();
            int atten = gradeSC.nextInt();
            gradeSC.nextLine();
            
            stdb[code][counts[code]] = new Student(name, st_id, mid, 
                                                   fin, assign, atten);
                                                   
            counts[code]++;
            
            System.out.println("등록 완료. 현재"+ counts[code] + "명");        
        }
        return "학생 등록 종료"; 
    }
    
    /**
     * 메소드 assignGrades
     *
     * @param stdb 파라미터
     * @param counts 파라미터
     * @return 반환값
     */
    public static String assignGrades(Student[] stdb, int[] counts){
        
        System.out.println("과목 코드(0~9)를 입력해주세요");
        
        int code;
        try{
            code = Integer.parseInt(gradeSC.nextLine());
        }
        catch(NumberFormatException e){
            return "숫자를 입력해주세요";
        }
        
        if(code <0 || code >9){
            return "0~9 범위로 입력해주세요";
        }
        else if(counts[code] == 0){
            return "등록된 학생이 없습니다";
        }
        
        System.out.println("1.절대평가 2. 상대평가 번호를 입력해주세요");
        
        int choiceGrade = Integer.parseInt(gradeSC.nextLine());
        
        if(choiceGrade == 1){
            // 절대평가 메소드실행, 
            // 매개변수(stdb, counts, code)(학생수 = counts[code])
        }
        else if(choiceGrade == 2){
            // 상대평가 메소드실행, 
            // 매개변수(stdb, counts, code)(학생수 = counts[code])
        }
        else{
            return "1 또는 2를 입력해주세요";
        }
        return "학점 부여 완료";
    }
}
