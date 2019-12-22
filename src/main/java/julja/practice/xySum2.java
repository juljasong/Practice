package julja.practice;

public class xySum2 {

	static int[] x = {10, 20, 30, 40, 50};
	static int[] y = {45, 55, 33, 28, 35};
	static int[] xySum = new int[5];
	
	public static void main(String[] args) {
		
		// x와  y의 각각 원소를 더하여 xySum 배열에 결과를 저장하고 출력하라.
		// 단, xySum 배열의 연산은 addArrays 함수를 만들어 처리하라.
		
		for (int i = 0 ; i < xySum.length ; i++) {
			addArrays(i);
			System.out.printf("x[%d] + y[%d] = %d\n", i, i, xySum[i]);
		}
	}

	private static void addArrays(int i) {
		xySum[i] = x[i] + y[i]; 
	}

}
