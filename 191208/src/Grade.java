import java.util.Scanner;

public class Grade {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("수학 점수를 입력해 주세요 : ");
		double english = sc.nextInt();
		System.out.print("영어 점수를 입력해 주세요 : ");
		double math = sc.nextInt();
		
		double avg = (english + math) / 2;
		System.out.println("평균 : " + avg);
		char g;
		
		if (avg < 60) {
			g = 'F';
		} else if (avg < 70) {
			g = 'D';
		} else if (avg < 80) {
			g = 'C';
		} else if (avg < 90) {
			g = 'B';
		} else {
			g = 'A';
		}
		System.out.println("학점 : " + g);
	}

}
