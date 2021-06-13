import java.util.Arrays;
public class BasicTest{
    public static void main(String[] args){

        Basic test1 = new Basic();
        test1.Print1To255();
        test1.PrintOdd();
        test1.PrintSum();
        int[] myArray = {1,3,5,-7,8,15};
        test1.IteratingArray(myArray);
        test1.FindMax(myArray);
        test1.FindAvg(myArray);
        System.out.println(test1.ArrayOddNumber());
        System.out.println(test1.GreaterThanY(myArray, 5));
        System.out.println(test1.EliminateNegative(myArray));
        System.out.println(Arrays.toString(test1.SquareValue(myArray)));
        System.out.println(Arrays.toString(test1.MaxMinAvg(myArray)));
        System.out.println(Arrays.toString(test1.ShiftingValue(myArray)));
    }   
}