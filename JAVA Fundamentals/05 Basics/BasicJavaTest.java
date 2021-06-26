import java.util.Arrays;
public class BasicJavaTest{
    public static void main(String[] args){
      
        BasicJava test = new BasicJava();
        
        test.print1to255();
        test.printOdd();
        test.printSum();
        
        int[] myArray = {1,3,5,-7,8,15};
        test.iteratingArray(myArray);
        test.findMax(myArray);
        test.findAvg(myArray);
        System.out.println(test.arrayOddNumber());
        System.out.println(test.greaterThanY(myArray, 5));
        System.out.println(test.eliminateNegative(myArray));
        System.out.println(Arrays.toString(test.squareValue(myArray)));
        System.out.println(Arrays.toString(test.maxMinAvg(myArray)));
        System.out.println(Arrays.toString(test.shiftingValue(myArray)));
    }   

}