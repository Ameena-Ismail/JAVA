  
public class StringManipulatorTest {
    public static void main(String[] args) {
     StringManipulation manipulator1 = new StringManipulation();
String str = manipulator1.trimAndConcat("    Hello     ","     World    ");
System.out.println(str); // HelloWorld ;


StringManipulation manipulator = new StringManipulation();
char letter = 'o';
Integer a = manipulator.getIndexOrNull("Coding", letter);
Integer b = manipulator.getIndexOrNull("Hello World", letter);
Integer c = manipulator.getIndexOrNull("Hi", letter);
System.out.println(a); // 1
System.out.println(b); // 4
System.out.println(c); // null


StringManipulation manipulator2 = new StringManipulation();
String word = "Hello";
String subString = "llo";
String notSubString = "world";
Integer g = manipulator2.getIndexOrNull(word, subString);
Integer x = manipulator2.getIndexOrNull(word, notSubString);
System.out.println(g); // 2
System.out.println(x); // null

StringManipulation manipulator3 = new StringManipulation();
String e = manipulator3.concatSubstring("Hello", 1, 2, "world");
System.out.println(e); // eworld

}
}
