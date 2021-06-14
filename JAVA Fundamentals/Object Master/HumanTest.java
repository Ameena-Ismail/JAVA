public class HumanTest {
    public static void main(String[] args) {
        //Human
        Human h1 = new Human("name1");
        Human h2 = new Human("name3");
        System.out.println(h2.getHealth());
        h1.attack(h2);
        System.out.println(h2.getHealth());
        //Wizard
        Wizard wiz=new Wizard("Oz");
        System.out.println(h1.getHealth());
        wiz.heal(h1);
        System.out.println(h1.getHealth());
        //Samurai
        Samurai somo=new Samurai("Yomo");
        System.out.println(somo.getHealth());
        somo.meditate();
        System.out.println(somo.getHealth());
        somo.meditate();
        System.out.println(somo.howMany());
        //Ninja
        Ninja jack=new Ninja("jack");
        Ninja oli=new Ninja("oli");
        System.out.println(h1.getHealth());
        jack.steal(h1);
        System.out.println(oli.getHealth());
        oli.runAway();
        System.out.println(oli.getHealth());


    }
    }
    