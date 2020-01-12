package julja.practice;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		/*
		int[] arr = { 10, 20, 30, 40, 50};
		int sum = 0;

		for(int i = 0 ; i < arr.length ; i++) {
			sum += arr[i];
		}

		System.out.println("sum = " + sum);
		 */

		/*
		int[][] arr = {
				{5, 5, 5, 5, 5},
				{10, 10, 10 , 10, 10},
				{20, 20, 20, 20, 20},
				{30, 30, 30, 30 ,30}
		};

		int total = 0;
		float aver = 0;

		for (int i = 0 ; i < arr.length; i++) {
			for(int j = 0 ; j < arr[0].length ; j++) {
				 total += arr[i][j];
			}
		}
		aver = (float)total / (arr.length * arr[0].length);

		System.out.println("total = " + total);
		System.out.println("average = " + aver);
		 */

		/*
		int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] ball3 = new int[3];

		// 배열 ballArr의 임의의 요소를 골라 위치를 바꿈
		for(int i = 0 ; i < ballArr.length ; i++) {
			int j = (int) (Math.random() * ballArr.length);
			int tmp = 0;

			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;

		}

		// 배열 ballArr의 앞에서 3개의 수를 배열  ball3으로 복사
		//for(int i = 0 ; i < ball3.length ; i++) {
		//	ball3[i] = ballArr[i];
		//}
		System.arraycopy(ballArr, 0, ball3, 0, ball3.length); 
		// ballArr[0]에서 ball3[0]으로 3개의 데이터 복사

		for (int i = 0 ; i < ball3.length ; i++) {
			System.out.print(ball3[i]);
		}
		 */
		/*
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;

		System.out.println("money = " + money);

		for(int i = 0 ; i < coinUnit.length ; i++) {
			int coin = money / coinUnit[i];
			System.out.println(coinUnit[i] + "원: " + coin);
			money %= coinUnit[i];	
		}
		 */

		/*
		//if(args.length != 1) {
		//	System.out.println("USAGE: java Exercise 5_7 3120");
		//	System.exit(0);
		//}

		// 문자열을 숫자로 변환. 입력한 값이 숫자가 아닐 경우 예외 발생
		System.out.print("money = ");
		int money = Integer.parseInt(sc.nextLine());

		int[] coinUnit = {500, 100, 50, 10};
		int[] coin = {5, 5, 5, 5};

		for(int i = 0 ; i < coinUnit.length ; i++) {

			int coinNum = money / coinUnit[i];

			if (coin[i] >= coinNum) {
				coin[i] -= coinNum;
				money -= coinUnit[i] * coinNum;
			}
			else {
				coinNum = coin[i];
				coin[i] -= coin[i];
				money -= coinUnit[i] * coinNum;
			}
			System.out.println(coinUnit[i]+ "원 : " + coinNum);

			// 1. money를 동전 단위로 나눠서 필요한 동전의 개수(coinNum)을 구함
			// 2. 배열 coin에서 coinNum 만큼의 동전을 뺌 (충분한 동전이 없다면 배열 coin에 있는 만큼만 뺌)
			// 3. 금액에서 동전의 개수(coinNum)와 동전단위를 곱한 값을 뺌

		}

		if(money > 0) {
			System.out.println("거스름돈이 부족합니다.");
			System.exit(0);
		}

		System.out.println("= 남은 동전의 개수 =");
		for(int i = 0; i < coinUnit.length ; i++) {
			System.out.println(coinUnit[i] + "원 : " + coin[i]);
		}
		 */

		/*
		int[] answer = {1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2};
		int[] counter = new int[4];

		for(int i = 0 ; i < answer.length ; i++) {
			if(answer[i] == 1)
				counter[0]++;
			else if(answer[i] == 2)
				counter[1]++;
			else if(answer[i] == 3)
				counter[2]++;
			else
				counter[3]++;
		}

		for(int i = 0 ; i < counter.length ; i++) {
			System.out.print(counter[i]);
			for(int j = 0 ; j < counter[i] ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
		 */

		/*
		// 시계 방향 90도 회전
		char[][] star = {
				{'*', '*', ' ', ' ', ' '},
				{'*', '*', ' ', ' ', ' '},
				{'*', '*', '*', '*', '*'},
				{'*', '*', '*', '*', '*'}

		};

		char[][] result = new char[star[0].length][star.length]; // [5][4]

		for(int i = 0 ; i < star.length ; i++) {
			for(int j = 0 ; j < star[i].length ; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		for(int i = 0 ; i < star.length ;i++) { // 0 ~ 3
			for(int j = 0 ; j < star[i].length ; j++) { // 0 ~ 4
				result[j][3-i] = star[i][j];
			}
		}

		for(int i = 0 ; i < result.length ; i++) {
			for(int j = 0 ; j < result[i].length ; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		 */
		/*
		char[] abcCode = // 97 ~ 122
			{ '`','~','!','@','#','$','%','^','&','*', 
					'(',')','-','_','+','=','|','[',']','{', 
					'}',';',':',',','.','/'};
		// 0   1   2   3   4   5   6   7   8   9 
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'}; // 48 ~ 57

		String src = "abc123"; 
		String result = "";
		// 문자열 의 문자를 으로 하나씩 읽어서 변환 후에 저장
		for(int i = 0; i < src.length() ; i++) { 
			char ch = src.charAt(i); // 97->0 , 98->1, 99->2
			if (ch > 96 && ch < 123) {
				result = result.concat(String.valueOf(abcCode[ch-97]));
			} else {
				result = result.concat(String.valueOf(numCode[ch-48]));
			}
		}
		System.out.println("src:"+src); 
		System.out.println("result:"+result);
		 */

		/*
		int[][] score = {
				{100, 100, 100} 
				, {20, 20, 20} 
				, {30, 30, 30} 
				, {40, 40, 40} 
				, {50, 50, 50}
				//240 240 240 720[5][3]
		}; 

		int[][] result = new int[score.length+1][score[0].length+1];

		for(int i=0; i < score.length;i++) {  // 0 ~ 4
			for(int j=0; j < score[i].length;j++) { // 0 ~ 3
				result[i][j] = score[i][j];
				result[i][score[0].length] += result[i][j];
				result[score.length][j] += result[i][j];
				result[score.length][score[0].length] += result[i][j];
			}
		}

		for(int i=0; i < result.length;i++) { 
			for(int j=0; j < result[i].length;j++) {
				System.out.printf("%4d",result[i][j]); 
			} System.out.println();
		}
		 */

		/*
		String[] words = { "television", "computer", "mouse", "phone" };

		for(int i = 0 ; i < words.length ; i++) {
			char[] question = words[i].toCharArray();

			// char 배열 question에 담긴 문자의 위치를 임의로 바꾼다
			for(int j = 0 ; j < question.length ; j++) {
				int randomNum = (int) (Math.random() * question.length);
				char tmp = question[j];
				question[j] = question[randomNum];
				question[randomNum] = tmp;
			}

			System.out.printf("Q%d. %s의 정답을 입력하세요.> ", i+1, new String(question));
			String answer = sc.nextLine();
			// trim으로 answer의 좌우 공백 제거 후 equals로 word[i]와 비교
			if(words[i].equals(answer.trim()))
				System.out.println("맞았습니다.");
			else
				System.out.println("틀렸습니다.");
		}
		 */

		String[] words = { "chair", "computer", "integer" };
		String[] answer = { "의자", "컴퓨터", "정수" };
		int count = 0;

		for(int i = 0 ; i < words.length ; i++) {
			System.out.printf("Q%d. %s의 뜻은? ", i + 1, words[i]);
			if(answer[i].equals(sc.nextLine().trim())) {
				System.out.println("정답입니다.\n");
				count++;
			} else {
				System.out.printf("틀렸습니다. 정답은 %s입니다.\n\n",answer[i]);
			}
		}
		 System.out.printf("전체 %d문제 중 %d문제 맞추셨습니다.", words.length, count);
	}
}