import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class Puzzle{
public static void main(String[] args){
    int[] myArray = {3,5,1,2,7,9,8,13,25,32};
    Sum(myArray);
    Array55To100();
   System.out.println(Str());
   System.out.println("Sorted : "+ Arrays.toString(sortArray()));
   System.out.println("Random 5  : "+randStrChar());
   System.out.println("Random 10 : " +Arrays.toString(randomStringArray()));


}
public static ArrayList <Integer> Sum(int[] myArray){
    double sum = 0;
    ArrayList <Integer> newArray = new ArrayList <Integer>(); //fixed
    for (int i=0 ; i<myArray.length ; i++){
        sum +=myArray[i];
        if (myArray[i]>10){
            newArray.add(myArray[i]);
    }
}
System.out.println("the sum : " +  sum) ;
System.out.println(newArray) ;
return newArray ;
}
public static ArrayList   Str(){
    ArrayList <String> myArray = new ArrayList <String>();
    myArray.add("Nancy");
    myArray.add("Jinichi");
    myArray.add("Fujibayashi");
    myArray.add("Momochi");
    myArray.add("Ishikawa");
    Collections.shuffle(myArray);
    for (int i=0;i<myArray.size();i++){
        if (myArray.get(i).length()<5){
            myArray.remove(i);
        }
    }
    return myArray;
}

public static void shuffleArr(){
    String[] alphabet={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"} ;
    String i = alphabet[0];
    System.out.println(i);
    System.out.println("last :"+ alphabet[25]);
    System.out.println("first :"+ i);
    if (i == "a" || i=="o" || i == "u" || i ==" e" || i=="i"){
        System.out.println("this letter is vowel") ;
    }

}
public static int[] Array55To100(){  //
    int[] newArray = new int[10];
    Random ran = new Random();
    for (int i=0; i<10;i++){
        newArray[i] = ran.nextInt(46)+55; 
    }
    System.out.println(Arrays.toString(newArray));
    return newArray;
}
public static int[] sortArray(){
    int[] newArray = Array55To100();
    Arrays.sort(newArray);
    System.out.println("Minimum  : "+ newArray[0]);
    System.out.println("Maximum : "+ newArray[newArray.length-1]);
    return newArray;
}
public static String randStrChar(){
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    int length = alphabet.length();
    String newstr = "";
    Random ran = new Random();
    for (int i = 0; i<5; i++){
        newstr += alphabet.charAt(ran.nextInt(length));
    }
    return newstr;
}

public static String[] randomStringArray(){
    String[] myArray = new String[10];
    for(int i=0;i<10; i++){
        String randStr = randStrChar();
        myArray[i] = randStr;
    }
    return myArray;
}




}






















