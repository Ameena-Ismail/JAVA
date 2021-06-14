public class Ninja extends Human{
    public  Ninja(){
        this.stealth=10;   
    }
    public  Ninja(String name){
        this.stealth=10;
        this.name=name;
    }
    public void steal(Human human){
    human.setHealth(human.getHealth()-stealth);
    System.out.println(human.getName()+" got their health decreased by "+stealth);
    }
    public void runAway(){
        this.setHealth(this.getHealth()-10);
        System.out.println(this.getName()+" got their health decreased by "+this.getHealth()+ "for running away");
        }
    
}