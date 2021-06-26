public class StringManipulatorTest{
    public static void main(String[] args){
        StringManipulator test = new StringManipulator();
        System.out.println(test.trimAndConcat("   Coding ", "  Dojo  Seattle  "));
        System.out.println(test.trimAndConcat("   Coding ", "  Dojo  "));

        char letter = 'g'; // "g" it's a String. Char use '' not ""
        Integer a = test.getIndexOrNull("Coding", letter);
        System.out.println(a);

        String letter2 = "Dojo";
        Integer b = test.getIndexOrNull("Coding Dojo", letter2);
        System.out.println(b);

        String word = test.concatSubstring("Hello", 2, 3, "World");
        System.out.println(word);
    }
}