import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava{
    public static void main(String[] args){
        int[] myArray = {3,5,1,2,7,238,8,13,25,32};
        System.out.println(printArr());
        shuffleArr();
        randomArray55To100();

        System.out.println("Sorted Array : "+ Arrays.toString(sortArray()));
        System.out.println("Random 5 characters : "+randStr5CharLong());
        System.out.println("Array of 10 random characters : " +Arrays.toString(random10StringArray()));
    
    }
    public static ArrayList printSum(int[] myArray){
        double sum = 0;
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (int i=0;i<myArray.length;i++){
            sum += myArray[i];
            if (myArray[i]>10){
                newArray.add(myArray[i]);
            }
        }
        System.out.println("sum of given array: "+sum);
        return newArray;
    }
    public static ArrayList printArr(){
        ArrayList<String> myArray = new ArrayList<String>();
        myArray.add("Nancy");
        myArray.add("Jinichi");
        myArray.add("Fujibayashi");
        myArray.add("Momochi");
        myArray.add("Ishikawa");
        Collections.shuffle(myArray);
        for (int i=0;i<myArray.size();i++){
            if (myArray.get(i).length()<6){
                myArray.remove(i);
            }
        }
        return myArray;
    }
    public static void shuffleArr(){
        // char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        // char letter = alphabet[0];
        // Note: collections - shuffle method cannot be used with primitive data type. only works with Object types

        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Collections.shuffle(Arrays.asList(alphabet));
        
        String letter = alphabet[0];
        
        System.out.println(letter);
        System.out.println("first letter of Array : "+ letter);
        System.out.println("Last letter of Array : "+ alphabet[25]);
        if (letter == "a" || letter == "e" || letter == "i" || letter == "o" || letter == "u"){
            System.out.println("The first letter is a vowel");
        }
    }

    public static int[] randomArray55To100(){
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i=0; i<10;i++){
            arr[i] = rand.nextInt(46)+55; // nextInt(46) -> random 0-45 
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static int[] sortArray(){
        int[] newArray = randomArray55To100();
        Arrays.sort(newArray);
        System.out.println("Minimum value in an array : "+ newArray[0]);
        System.out.println("Maximum value in an array : "+ newArray[newArray.length-1]);
        return newArray;
    }
    public static String randStr5CharLong(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int alphaLength = alphabet.length();
        String newstr = "";
        Random rand = new Random();
        for (int i = 0; i<5; i++){
            newstr += alphabet.charAt(rand.nextInt(alphaLength));
        }
        return newstr;
    }

    public static String[] random10StringArray(){
        String[] myArray = new String[10];
        for(int i=0;i<10; i++){
            String randStr = randStr5CharLong();
            myArray[i] = randStr;
        }
        return myArray;
    }
}