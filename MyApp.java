import java.util.Scanner;
/**
 * MyApp 성적 처리 소프트웨어 실행 클래스.
 *
 * @author (2021320032 임기홍 2020315044 허진영)
 * @version (2026 05 09)
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

            System.out.println("\n-----성적 처리 프로그램-----");
            System.out.println("1.학생 등록 \t 2.학점 부여");
            System.out.println("3.성적 출력 \t 4.종료");
            System.out.println("-------------------------");
            System.out.print("번호를 입력해주세요 : ");

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
                    System.out.println(assignGrades(stdb, counts));
                    break;
                case 3:
                    System.out.println(printGrades(stdb, counts));
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

        System.out.print("과목 코드(0~9)를 입력해주세요 : ");

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

            System.out.print("학생 등록시 1 종료시 0을 입력해주세요 : ");
            int next;
            try{
                next = Integer.parseInt(gradeSC.nextLine());
            }
            catch(NumberFormatException e){
                return "숫자를 입력해주세요";
            }

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
     * 메소드 printGrades
     *
     * @param stdb 과목별 학생들이 저장되어있는 2차원 배열
     * @param counts 선택한 과목 코드 내 현재 학생수 파악을 위한 카운트 배열
     * @return 문자열 반환
     */
    public static String printGrades(Student[][] stdb, int[] counts){
        
        System.out.print("과목 코드(0~9)를 입력해주세요 : ");

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
        
        int n = counts[code];
        
        if(n == 0) {
            return "등록된 학생이 없습니다";
        }
        
        System.out.println("\n"+ code + "번 과목 성적 리스트");
        System.out.println("-------------------------");
        
        for(int i = 0; i < n; i++){
            
            Student s = stdb[code][i];
            System.out.println(s.getStId() + " " + s.getName() + " | " + s.getTotalScore() + " | " + s.getGrade());
        }
        System.out.println("-------------------------");
        
        return "성적 출력 완료";
    }

    /**
     * 메소드 absoluteGrade
     *
     * @param stdb 과목별 학생들이 저장되어있는 2차원 배열
     * @param counts 선택한 과목 코드 내 현재 학생수 파악을 위한 카운트 배열
     * @param code 학점을 부여할 과목 코드
     */
    public static void absoluteGrade(Student[][] stdb, int[] counts, int code)
    {    

        int n = counts[code];

        for(int i = 0; i < n; i++){

            double totalScore = stdb[code][i].getTotalScore();

            if(totalScore >= 90){
                stdb[code][i].setGrade("A");
            }
            else if(totalScore >= 80){
                stdb[code][i].setGrade("B");
            }
            else if(totalScore >= 70){
                stdb[code][i].setGrade("C");
            }
            else{
                stdb[code][i].setGrade("F");
            }
        }
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param stdb 과목별 학생들이 저장되어있는 2차원 배열
     * @param counts 선택한 과목 코드 내 현재 학생수 파악을 위한 카운트 배열
     * @param code 학점을 부여할 과목 코드
     */
    public static void relativeGrade(Student[][] stdb, int[] counts, int code){

        int n = counts[code];

        for(int i = 0; i < n; i++){

            int count = 0;

            for(int j = 0; j < n; j++){
                if(stdb[code][j].getTotalScore() > stdb[code][i].getTotalScore()){
                    count++;
                }
            }
            int rank = count + 1;
            double per = (double)rank / n * 100;

            if(per <= 35){
                stdb[code][i].setGrade("A");
            }
            else if(per <= 70){
                stdb[code][i].setGrade("B");
            }
            else{
                stdb[code][i].setGrade("F");
            }
        }
    }

    /**
     * 메소드 assignGrades
     *
     * @param stdb 파라미터
     * @param counts 파라미터
     * @return 반환값
     */
    public static String assignGrades(Student[][] stdb, int[] counts){

        System.out.print("과목 코드(0~9)를 입력해주세요 : ");

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

        System.out.print("1.절대평가 2. 상대평가 번호를 입력해주세요 : ");

        int choiceGrade = Integer.parseInt(gradeSC.nextLine());

        if(choiceGrade == 1){
            // 절대평가 메소드실행, 
            // 매개변수(stdb, counts, code)(학생수 = counts[code])
            absoluteGrade(stdb, counts, code);
        }
        else if(choiceGrade == 2){
            // 상대평가 메소드실행, 
            // 매개변수(stdb, counts, code)(학생수 = counts[code])
            relativeGrade(stdb, counts, code);
        }
        else{
            return "1 또는 2를 입력해주세요";
        }
        return "학점 부여 완료";
    }
}
