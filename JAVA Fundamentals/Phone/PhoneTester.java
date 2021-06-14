
public class PhoneTester {
	public static void main(String[] args) {
		
		IPhone eleven = new IPhone("123456789n", 90 , "omnia" , "OverTheHorizone");
		Galaxy twentyOne = new Galaxy("98m7654321" , 99 , "ooredo" , "wizo");
        IPhone elevenProMax = new IPhone("2134567890", 80 , "jawwal" , "TikTok");

        System.out.println(elevenProMax.unlock());
		eleven.displayInfo();
		twentyOne.displayInfo();
		System.out.println(elevenProMax.ring());
		
	}

}