//in sts : from files bar Source: generate getters and setters
public class Human {
	protected String name = "";
	protected int strength = 50;
	protected int stealth = 3;
	protected int intelleginece = 3;
	protected int health = 100;			
//constructors
public Human() {
    
}
public Human(String name) {
	this.name = name;
}
// source > getters/ setters
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getStealth() {
	return stealth;
}
public void setStealth(int stealth) {
	this.stealth = stealth;
}
public int getIntelleginece() {
	return intelleginece;
}
public void setIntelleginece(int intelleginece) {
	this.intelleginece = intelleginece;
}
public int getHealth() {
	return health;
}
public int getStrength() {
	return strength;
}
public void setHealth(int health) {
	this.health = health;
}
public void setStrength(int strength) {
	this.strength = strength;
}
public void attack(Human human) {
	human.setHealth(human.getHealth()-strength);
	System.out.println(this.getName()+" attacked " + human.getName() + " for " + this.getStrength() + " damage!! " );
}
}