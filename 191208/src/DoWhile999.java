
public class DoWhile999 {

	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		
		do {
			sum += i;
			i++;
		} while ( i <= 999 );
		
		System.out.printf("1부터 999까지의 합은 %d 입니다", sum);

	}

}
