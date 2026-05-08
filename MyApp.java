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
}
