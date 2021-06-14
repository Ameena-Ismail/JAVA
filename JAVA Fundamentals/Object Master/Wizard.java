public class Wizard extends Human{
    public Wizard(){
        this.health=50;
        this.intelleginece=8;
    }
    public Wizard(String name){
        this.health=50;
        this.intelleginece=8;
        this.name=name;
    }
    public void heal(Human human){
        human.setHealth(human.getHealth()+intelleginece);
        System.out.println("much better!");
        System.out.println("("+human.getName()+" had their health increased by "+this.intelleginece+" from "+this.getName()+".");

    }
    public void fireBall(Human human){
        human.setHealth(human.getHealth()-intelleginece*3);
        System.out.println("ouch!");
        System.out.println("("+human.getName()+" had damage points "+this.intelleginece*3+" from "+this.getName()+".");
        }
}