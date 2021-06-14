 class ProjectTest{
    public static void main(String[] args){
        Project project1 = new Project("first");
        Project project2 = new Project("seconed");
        Project project3 = new Project("third", "Description third");
        Project project4 = new Project("fourth", "Description fourth");
        
        
        System.out.println(project1.elevator()); //display  project
        System.out.println(project2.elevator());
        System.out.println(project3.elevator());
        System.out.println(project4.elevator());

        //set project name, description
        project1.name("first Project"); 
        project1.description(" Description first");
        System.out.println("first : "+ project1.elevator());
        project2.description("seconed Project Description ");
        System.out.println(project1.getName());
        System.out.println(project1.getDescription());   
        System.out.println(project2.getName());
        System.out.println(project2.getDescription());

        // //add portfolio
        // Portfolio newPortfolio = new Portfolio();
        // newPortfolio.addProject(project1);
        // newPortfolio.addProject(project2);
        // newPortfolio.addProject(project3);
        // newPortfolio.addProject(project4);
        //get entire Portfolio cost
        // System.out.println(newPortfolio.getPortfolioCost());
        //Show all projects in portfolio and print total cost 
    //     newPortfolio.showPortfolio();
         // }
    }
}