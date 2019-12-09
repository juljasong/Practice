

import java.util.Scanner;

public class Calc {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		/*
		System.out.println("진수 변환기입니다.");
		System.out.println("변환할 수와 변환할 진수를 순서대로 입력해 주세요.");

		String a = sc.nextLine(); // 변환할 수
		int b = sc.nextInt(); // 변환할 진수

		int num2 = 0;

		num2 = Integer.parseInt(a, b);

		System.out.printf("%s의 %d진수는 %d입니다.", a, b, num2);
		*/
		
		System.out.println("[1] 10진수 -> 2/8/16진수");
		System.out.println("[2] 2/8/16진수 -> 10진수");
		int select = sc.nextInt();
		System.out.println("------------------");
		
		if(select == 1) {
			System.out.print("변환할 수 : ");
			int a = sc.nextInt();

			System.out.println("------------------");
			System.out.println("2진수 : (0b)" + Integer.toBinaryString(a)); //2
			System.out.println("16진수 : (0x)" + Integer.toHexString(a)); //16
			System.out.println("8진수 : (0)" + Integer.toOctalString(a)); //8

		} else {
			String num;
			int num2 = 0;
			
			System.out.print("2진수: 2 | 8진수: 8 | 16진수 : 16 => ");
			int vr = sc.nextInt();
			System.out.println("변환할 수 : ");
			num = sc.next();
			
			switch(vr) {
			case 2 : num2 = Integer.parseInt(num, 2);
			break;
			case 8 : num2 = Integer.parseInt(num, 8);
			break;
			case 16 : num2 = Integer.parseInt(num, 16);
			break;
			default : System.out.println("입력 오류.");
			return;
			}
			System.out.println(num + "의 " + vr + "진수 : " + num2);
		}
		
	
		
		
		
	}

}
