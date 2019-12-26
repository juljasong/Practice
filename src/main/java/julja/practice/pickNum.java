package julja.practice;

import java.util.Scanner;

public class pickNum {

	// 숫자 맞추기

	// 1과 100사이의 숫자 중에서 하나의 숫자가 선택되었습니다.
	// 10번의 기회 안에 숫자를 맞춰보세요.
	// 입력한 숫자가 큰지 작은지 알려줄 것입니다.
	// 숫자를 입력하세요: 

	public static void main(String[] args) {

		int randomNumber = (int)(Math.random() * 100);

		Scanner sc = new Scanner(System.in);

		int count = 1;
		while (true) {
			System.out.print("숫자를 입력하세요: ");
			int pick = sc.nextInt();
			if (randomNumber != pick) {
				if (randomNumber > pick) {
					System.out.println(pick + " 보다 큰 수 입니다.");
				} else {
					System.out.println(pick + " 보다 작은 수 입니다.");
				}
			} else if (randomNumber == pick) {
				System.out.println("맞추셨습니다!");
				break;
			}
			System.out.println();
			count++;
			if (count == 10) {
				System.out.println("모든 기회를 사용하였습니다.");
				break;
			}
		}
		sc.close();
	}

}
