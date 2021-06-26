public class Project{
    // set project's fields or attributes
    private String name;
    private String description;
    private double initialCost;
    
    // Overload constructor methods
    public Project(){
    }
    public Project(String name){
        this.name = name;
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Project(String name, String description, double cost){
        this.name = name;
        this.description = description;
        this.initialCost = cost;
    }
    public String elevatorPitch(){
       return (name+"("+initialCost+"),"+description); 
    }
    // setting name
    public void setName(String name){
        this.name = name;
    }
    // setting description
    public void setDescription(String description){
        this.description = description;
    }
    // setting initialCost
    public void setInitialCost(double initialCost){
        this.initialCost = initialCost;
    }
    //getting name
    public String getProjectName(){
        return this.name;
    }
    //getting description
    public String getDescription(){
        return this.description;
    }
    //getting initialCost
    public double getInitialCost(){
        return this.initialCost;
    }
}