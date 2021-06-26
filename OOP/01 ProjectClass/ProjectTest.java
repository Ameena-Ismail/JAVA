public class ProjectTest{
    public static void main(String[] args){
        Project project1 = new Project();
        Project project2 = new Project("2nd Project");
        Project project3 = new Project("3rd Project", "Project Description III");
        Project project4 = new Project("4th", "Project Description IV", 3500);
        
        //display all projects
        System.out.println(project1.elevatorPitch());
        System.out.println(project2.elevatorPitch());
        System.out.println(project3.elevatorPitch());
        System.out.println(project4.elevatorPitch());

        //set project name, description, and initialCost
        project1.setName("1st Project");
        project1.setDescription("Project I Description");
        project1.setInitialCost(2000);
        System.out.println("Project I : "+ project1.elevatorPitch());
        project2.setInitialCost(4200);
        project2.setDescription("Project II Description !!");
        project3.setInitialCost(1200);

        //get project name, description, and initailCost
        System.out.println(project1.getInitialCost());
        System.out.println(project1.getProjectName());
        System.out.println(project1.getDescription());

        //add portfolio

        Portfolio newPortfolio = new Portfolio();
        newPortfolio.addProject(project1);
        newPortfolio.addProject(project2);
        newPortfolio.addProject(project3);
        newPortfolio.addProject(project4);

        //get entire Portfolio cost
        System.out.println(newPortfolio.getPortfolioCost());
        //Show all projects in portfolio and print total cost 
        newPortfolio.showPortfolio();
    }
}