public class PythagoreanTest{
    public static void main(String[] args){
        Pythagorean test = new Pythagorean();
        Double calculated = test.calculateHypotenuse(3,4);
        System.out.println("Hypotenuse result :"+calculated);
    }
}