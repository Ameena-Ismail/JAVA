public class Samurai extends Human{
    static int samuraiCount=0;

    public  Samurai(){
        this.health=200;
        samuraiCount+=1;
    }
    public  Samurai(String name){
        this.health=200;
        this.name=name;
        samuraiCount+=1;
    }
    public int howMany(){
        System.out.println(samuraiCount);
        return samuraiCount;   
    }
    public void meditate(){

    this.setHealth(this.getHealth()+this.getHealth()/2);
    

    }
    
}