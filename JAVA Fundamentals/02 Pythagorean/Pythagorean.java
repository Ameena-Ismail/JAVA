import java.lang.*; 

public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB){
        double result = Math.sqrt(legA*legA + legB*legB);
        return result;
    }
}