package chap07;

public class Main {

	public static void main(String[] args) {
		RecCalculatorFinal recCalculatorFinal = new RecCalculatorFinal();
		recCalculatorFinal.factorial(4);
	}

	public static void main3(String[] args) {

		ExeTimeCalculator implExeTimeCalculator = new ExeTimeCalculator(new ImplCalculator());
		ExeTimeCalculator recExeTimeCalculator = new ExeTimeCalculator(new RecCalculator());

		System.out.println(implExeTimeCalculator.factorial(20));
		System.out.println();
		System.out.println(recExeTimeCalculator.factorial(20));
	}

	public static void main2(String[] args) {
		ImplCalculator implCalculator = new ImplCalculator();
		long start1 = System.currentTimeMillis();
		long fourFactorial1 = implCalculator.factorial(4);
		long end1 = System.currentTimeMillis();
		System.out.printf(">> ImplCalculator.factorial(4) 실행시간 = %d<<%s",
			(end1 - start1), System.lineSeparator());

		RecCalculator recCalculator = new RecCalculator();
		long start2 = System.currentTimeMillis();
		long fourFactorial2 = recCalculator.factorial(4);
		long end2 = System.currentTimeMillis();
		System.out.printf(">> RecCalculator.factorial(4) 실행시간 = %d<<%s",
			(end2 - start2), System.lineSeparator());
	}
}
