package chap07;

public class RecCalculatorFinal implements Calculator {

	public long factorial(long num) {
		long start = System.currentTimeMillis();
		try {
			if (num == 0) {
				return 1;
			}
			return num * factorial(num - 1);
		} finally {
			long end = System.currentTimeMillis();
			System.out.printf("RecCalculator.factorial(%d) 실행 시간 = %d\n", num, (end - start));
		}
	}
}
