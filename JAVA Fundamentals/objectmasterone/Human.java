public class Human{ //protected to allow 
    protected String name         = "";
    protected int strength        = 3; //should be 50
    protected int stealth         = 3;
    protected int health          = 100;
    protected int intelligence    = 3;   

    public Human(){ //constructer
    }

    public Human(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){ 
        return name;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getStrength(){
        return strength;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }

    public int getHealth(){
        return health;
    }
    public void setStealth(int stealth){
        this.stealth = stealth;
    }

    public int getStealth(){
        return stealth;
    }
    public void setIntell(int intelligence){
        this.intelligence = intelligence;
    }

    public int getIntell(){
        return intelligence;
    }
//methods // Add the attack(Human) method that reduces the health of the attacked human by the strength of the current human.
    public void attack(Human human){
        human.setHealth(human.getHealth()-strength); //strength
        System.out.println(this.getName() +   " attack"  + human.getName() + "  for " + this.getStrength() + "damage !");
    }

}