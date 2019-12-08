import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("연도 : ");
		int year = sc.nextInt();
		System.out.print("월 : ");
		int month = sc.nextInt();
		
		switch (month) {
		case 1 :
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 : 
		case 12 : 
			System.out.println(year + "년 " + month + "월의 말일은 31일입니다.");
			break;
		case 4 : 
		case 6 : 
		case 9 : 
		case 11 :
			System.out.println(year + "년 " + month + "월의 말일은 30일입니다.");
			break;
		case 2 :
			// 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고
			// 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며
			// 다만 400으로 나누어 떨어지는 해는 다시 윤년이다.
			if ( (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ) {
				System.out.println(year + "년 " + month + "월의 말일은 29일(윤년)입니다.");
			} else {
				System.out.println(year + "년 " + month + "월의 말일은 28일입니다.");
			}
			break;
		default :
			System.out.println("잘못된 입력입니다.");
		}
	}

}
