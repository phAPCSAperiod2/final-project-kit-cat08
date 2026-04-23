import java.util.ArrayList;
public class Subject {
    private ArrayList<Task>assignments;
    private String name;
    private int total;
    //contructors
    /**
     * creates a class/subject
     * @param name - name of class
     * @param task - tasks for the class
     */
    public Subject (String name, Task task){
        this.name = name;
        assignments = new ArrayList();
        assignments.add(task);
        total++;
    }
    /**
     * creates subject/class
     * @param name of class
     */
    public Subject(String name){
        this.name = name;
        assignments = new ArrayList();
        total=0;
    }
    //Setters and Getters
    /**
     * Gets list of tasks
     * @return list of tasks
     */
    public ArrayList<Task> getTasks(){
        return assignments;
    }
    public Task getSpecificTask(int index){
        return assignments.get(index);
    }
    /**
     * gets name of the class/subject
     * @return name of class
     */
    public String getClassName(){
        return name;
    }
    /**
     * gets total amoutn of task for subject
     * @return total number of tasks
     */
    public int getTotalTasks(){
        return total;
    }
    /**
     * adds task to the list
     * @param task assignment that need to be completed
     */
    public void addTask(Task task){
        assignments.add(task);
        total++;
    }
    /**
     * removes task from list if completed and updates total
     * @param task completed assignment
     */
    public void removeTask(Task task){
        if(task.getIsCompleted()){
            assignments.remove(task);
             total--;
        }
        else{
            System.out.println("You have not finished that task yet!");
        }

    }

    /**
     * organizes that task in the list by due date
     */
    public void sortByDate(){
        for (int i = 0; i<assignments.size()-1; i++){
            if (assignments.get(i).getDueDate()>assignments.get(i+1).getDueDate()){
                Task dueLater = assignments.get(i);
                assignments.set(i,assignments.get(i+1));
                assignments.set(i+1, dueLater);
            }
        }
    }
    /**
     * sorts and prints out all the tasks for the subject
     */
    public void allTasks(){
        sortByDate();
        for (int i = 0; i<assignments.size(); i++){
            System.out.println(assignments.get(i));
    }

}

}
