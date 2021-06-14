
public class HumanTest {
    public static void main(String[] args){
        Human i = new Human ("i");
        Human j = new Human ("j");
        System.out.println(j.getHealth());
        i.attack(j); //method from Human.java
        System.out.println(j.getHealth());
    }
}