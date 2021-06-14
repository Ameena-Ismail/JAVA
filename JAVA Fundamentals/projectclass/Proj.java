 class Project{ // set project's fields  
    private String name;
    private String description;
    private double initialCost;
    
    
    public Project(){ // Overload constructor methods
    }
    public Project(String name){
        this.name = name;
    }

    public Project(String name, String description){ //if i need to add double cost
        this.name = name;
        this.description = description;
        // this.initialCost = cost;
    }
    public String elevator(){
       return (name + "," +description); 
    }
    
    public void name(String name){ //  name
        this.name = name;
    }
    
    public void description(String description){ //  description
        this.description = description;
    }
    
    public String getName(){ //get name
        return this.name; 
    }
   
    public String getDescription(){  //get description
        return this.description;
    }

}