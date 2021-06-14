class CalculatorTest {

public static void main(String[] args) {
		Calculator test1 = new Calculator(10.5,"+",5.2);
		Calculator test2 = new Calculator(59.8,"-",22.9);
		Calculator test3 = new Calculator(3490.78,"+",88.90);
		test1.performOperation();
		test2.performOperation();
		test3.performOperation();
		test1.getResults();
		test2.getResults();
		test3.getResults();
	}
}