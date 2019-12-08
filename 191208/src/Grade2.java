import java.util.Scanner;

public class Grade2 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("수강 인원을 입력해 주세요 : ");
		int human = sc.nextInt();
		int sum = 0;
		
		for ( int i = 0 ; i < human ; i++ ) {
			System.out.print("학번 : ");
			int sCode = sc.nextInt();
			System.out.print("점수 : ");
			double p = sc.nextInt();
			char g;
			
			if (p < 60) {
				g = 'F';
			} else if (p < 70) {
				g = 'D';
			} else if (p < 80) {
				g = 'C';
			} else if (p < 90) {
				g = 'B';
			} else {
				g = 'A';
			}
			System.out.printf("%d의 학점은 %c입니다\n", sCode, g);
			
			sum += p;
		}
		System.out.printf("과목평균 : " + sum / human);
	}

}
