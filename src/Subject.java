import java.util.ArrayList;
public class Subject {
    private ArrayList<Task>assignments;
    private String name;
    private int total;
    //contructors
    public Subject (String name, Task task){
        this.name = name;
        assignments = new ArrayList();
        assignments.add(task);
        total++;
    }
    public Subject(String name){
        this.name = name;
        assignments = new ArrayList();
        total=0;
    }
    //Setters and Getters
    public ArrayList<Task> getTasks(){
        return assignments;
    }
    public String getClassName(){
        return name;
    }
    public int getTotalTasks(){
        reutn total;
    }
    public void addTask(Task task){
        assignments.add(task);
        total++;
    }
    public void removeTask(Task task){
        if(task.getIsCompleted()){
            assignments.remove(task);
        }
    }
    public void sortByDate(){
        for (int i = 0; i<assignments.size()-1; i++){
            if (assignments.get(i).getDueDate()>assignments.get(i+1).getDueDate()){
                Task dueLater = assignments.get(i);
                assignments.set(i,assignments.get(i+1));
                assignments.set(i+1, dueLater);
            }
        }
    }

}
