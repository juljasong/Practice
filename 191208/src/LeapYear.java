import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int year = sc.nextInt();
		System.out.print("�� : ");
		int month = sc.nextInt();
		
		switch (month) {
		case 1 :
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 : 
		case 12 : 
			System.out.println(year + "�� " + month + "���� ������ 31���Դϴ�.");
			break;
		case 4 : 
		case 6 : 
		case 9 : 
		case 11 :
			System.out.println(year + "�� " + month + "���� ������ 30���Դϴ�.");
			break;
		case 2 :
			// ��� ������ 4�� ������ �������� �ش� �켱 �������� �ϰ�
			// �� �߿��� 100���� ������ �������� �ش� ������� �ϸ�
			// �ٸ� 400���� ������ �������� �ش� �ٽ� �����̴�.
			if ( (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ) {
				System.out.println(year + "�� " + month + "���� ������ 29��(����)�Դϴ�.");
			} else {
				System.out.println(year + "�� " + month + "���� ������ 28���Դϴ�.");
			}
			break;
		default :
			System.out.println("�߸��� �Է��Դϴ�.");
		}
	}

}
