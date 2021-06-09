public class FizzBuzz {

	public static void main(String[] args) {
		String x=fizzBuzz(7);
		System.out.println(x);
	}

    	public static String fizzBuzz(int number) {
		if (number==3){return "Fizz";}
		if(number==5){return "Buzz";}
		if(number==15){return "FizzBuzz";}
		return String.valueOf(number);
    	}

}