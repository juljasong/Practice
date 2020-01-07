package julja.practice;

import java.util.Scanner;

public class IfPractice {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    /*
		int x = 20;
		if (x > 10 && x < 20) {
			System.out.println("true");
		}
     */
    /*
		char ch = '탭';
		if (ch != ' ' && ch != '\t') {
			System.out.println("true");
		}
     */
    /*
		char ch = 'X';
		if (ch == 'x' || ch == 'X') {
			System.out.println("true");
		}
     */
    /*
		char ch = '7';
		if (ch > 47 && ch < 58) {
			System.out.println("true");
		}
     */
    /*
		char ch = 'z';
		if ((ch > 64 && ch < 91) || (ch > 96 && ch < 123)) {
			System.out.println("true");
		}
     */
    /*
		int year = 2100;
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			System.out.println("true");
		}
     */
    /*
		boolean powerOn = true;
		if (powerOn == false) {
			System.out.println("true");
		}
     */
    /*
		String str = "yes";
		if (str.equals("yes")) {
			System.out.println("true");
		}
     */
    /*
		int sum = 0;
		for (int i = 0 ; i <= 20 ; i++) {
			if (!(i % 2 == 0) && !(i % 3 == 0)) {
				sum += i;
			}
		}
		System.out.println(sum);
     */
    /*
		int sum = 0;
		for (int i = 0 ; i <= 10 ; i++) {
			for (int j = 0 ; j <= i ; j++) {
				sum += j;
			}
		}
		System.out.println(sum);
     */
    
    int sum = 0;
    int i = 1;
    
    while(true) {
      if (i % 2 == 0) {
        sum -= i;
      } else {
        sum += i;
      }
      if (sum >= 100)
        break;
      i++;
    }
    System.out.println(sum +", " + i);
    
    
    /*
		int i = 0, j;
		while (i <= 10) {
			j = 0;
			while (j <= i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
     */
    /*
		int x, y;
		for (x = 1 ; x <= 6 ; x++) {
			for(y = 1 ; y <= 6 ; y++) {
				if (x + y == 6) 
					System.out.println(x + " " + y);
			}
		}
     */
    /*
		int value = (int)(Math.random()*6)+1;
		System.out.println("value : " + value);
     */
    /*
		int x, y = 0;
		for (x = 0 ; x <= 10 ; x++) {
			for(y = 0 ; y <= 10 ; y++) {
				if(2 * x + 4 * y == 10){
					System.out.println("x=" + x + ", y=" + y);
				}
			}
		}
     */
    /*
		String str = "12345";
		int sum = 0;
		for (int i = 0 ; i < str.length() ; i++) {
			sum += str.charAt(i)-48; // ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ 답만 나오면 되지
		}
		System.out.println("sum = " + sum);
     */
    /*
    int num = 12345;
    int sum = 0;
    while(num != 0) {
      sum += num % 10;
      num = num / 10;
    }
    System.out.println("sum = " + sum);
    */


    /*
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		System.out.print(num1 + ", " + num2);

		for (int i = 0 ; i < 8 ; i ++) {
			num3 = num1 + num2;
			System.out.print(", " +num3);
			num1 = num2;
			num2 = num3;
		}
     */
    /* !!!!!!!!!!!!!!!!!!!!!!!!!!!???????????????!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		for (int i = 1 ; i < 4 ; i++) {
			for	(int j = 2 ; j < 5 ; j++) {
				System.out.printf("%d*%d=%d\t", j, i, j*i);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 1 ; i < 4 ; i++) {
			for	(int j = 5 ; j < 8 ; j++) {
				System.out.printf("%d*%d=%d\t", j, i, j*i);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 1 ; i < 4 ; i++) {
			for	(int j = 8 ; j < 10 ; j++) {
				System.out.printf("%d*%d=%d\t", j, i, j*i);
			}
			System.out.println();
		}
     */
    /*
		String value = "023o409";
		char ch = ' ';
		boolean isNumber = true;

		for (int i = 0 ; i < value.length() ; i++) {
			ch = value.charAt(i);
			if (!(ch > 47 && ch < 58)) {
				isNumber = false;
			}
		}

		if (isNumber) {
			System.out.println(value + "는 숫자입니다.");
		} else {
			System.out.println(value + "는 숫자가 아닙니다.");
		}
     */
    /*
		int answer = (int)(Math.random()*100)+1;
		int input = 0;
		int count = 0;
		do {
			count ++;
			System.out.print("1과 100 사이의 값을 입력하세요 : ");
			input = sc.nextInt();
			if (answer == input) {
				System.out.println(count + "번 만에 맞추셨습니다!");
				break;
			} else if (answer > input) {
				System.out.println(input + " 보다 큰 수 입니다.");
			} else {
				System.out.println(input + " 보다 작은 수 입니다.");
			}
		} while (true);
     */
    /*
    int number = 12321;
    int tmp = number;
    int result = 0; // 변수 number를 거꾸로 변환해서 담을 변수
    while (tmp != 0) {
      result = result * 10 + tmp % 10;
      tmp = tmp / 10;
    }
    if (number == result) 
      System.out.println(number + "는 회문수 입니다.");
    else
      System.out.println(number + "는 회문수가 아닙니다.");
     */

  }
}
