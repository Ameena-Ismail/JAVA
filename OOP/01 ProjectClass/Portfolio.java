import java.util.ArrayList;
public class Portfolio{
    
    ArrayList<Project> projects = new ArrayList<Project>();
    public Portfolio(){
    }
    
    public void addProject(Project myProject){
        this.projects.add(myProject);
    }

    //method to return the cost of entire portfolio
    public double getPortfolioCost(){
        double totalCost = 0;
        for (Project project: this.projects){
            totalCost += project.getInitialCost();
        }
        return totalCost;
    }
    // method that will print all projects elevator pitches, followed by total cost.
    public void showPortfolio(){
        System.out.println(" ----- Portfolio Projects -----");
        for (Project project: this.projects){
            System.out.println(project.elevatorPitch());
        }
        System.out.println("Portfolio total cost: $"+this.getPortfolioCost());
    }
}