
import java.util.*;

public class Basic {

    public void Print1To255(){
        for(int i=0 ; i<256 ; i++){
            System.out.println(i);  
        }
    }
    public void PrintOdd(){
        for (int i=0; i<256; i++){
            if (i%2 ==1){
                System.out.println(i);
            }
        }
    }
    public void PrintSum(){
        int sum = 0;
        for (int i=0;i<256;i++){
            sum +=i;
            System.out.println(String.format("New number : %s Sum: %s", i, sum));
        }
    }
    public void IteratingArray(int[] myArray){ //
        for (int i=0;i<myArray.length;i++){
            System.out.println(myArray[i]);
        }
    }
    public void FindMax(int[] myArray){ //
        int max = myArray[0];
        for (int i=1;i<myArray.length;i++){
            if (max<myArray[i]){
                max = myArray[i];
            }
        }
        System.out.println("Max Number in Array = " +  max);
    }
    public void FindAvg(int[] myArray){ //
        double avg;
        int sum = 0;
        for (int i=0;i<myArray.length;i++){
            sum += myArray[i];
        }
        avg = sum/myArray.length;
        System.out.println("Average number in Array = "+avg);
    }
    public ArrayList ArrayOddNumber(){ //??
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for (int i=1;i<256;i++){
            if (i%2==1){
                myArray.add(i);
            }
        }
        return myArray;
    }
    public int GreaterThanY(int[] myArray, int y){ //
        int count =0;
        for (int i=0;i<myArray.length;i++){
            if (myArray[i]>y){
                count ++;
            }
        }
        return count;
    }
    public int[] SquareValue(int[] myArray){
        for(int i=0;i<myArray.length;i++){
            int square = (int)Math.pow(myArray[i],2); //without (int)Math would has error
            myArray[i] = square;
        }
        return myArray;
    }
    
    public int[] EliminateNegative(int[] myArray){
        for (int i=0; i<myArray.length;i++){
            if (myArray[i]<0){
                myArray[i] = 0;
            }
        }
        return myArray;
    }
    public int[] MaxMinAvg(int[] myArray){
        int max = myArray[0];
        int min = myArray[0];
        int sum = 0;
        for (int i=0;i<myArray.length;i++){
            if (myArray[i]>max){
                max = myArray[i];
            }else if (myArray[i]<min){
                min = myArray[i];
            }
            sum += myArray[i];
        }
        int[] result = {max, min, sum/myArray.length};
        return result;
    }

    public int[] ShiftingValue(int[] myArray){
        for (int i=1;i<myArray.length;i++){
            myArray[i-1]= myArray[i];
        }
        myArray[myArray.length-1] = 0;
        return myArray;
    }
}