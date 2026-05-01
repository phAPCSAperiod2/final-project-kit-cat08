import java.util.ArrayList;

public class Manager{

    private ArrayList<Subject> classes;
    /**
     * creates Manager object
     */
    public Manager(){
        classes = new ArrayList();
    }
    /**
     * getter method for classes
     * @return an array list of all subjects
     */
    public ArrayList<Subject> getList(){
        return classes;
    }
    /**
     * adds a new subject to classes in Manager
     * @param subject new subject
     */
    public void addSubject(Subject subject){
        classes.add(subject);
    }
    /**
     * checks if the subject is in classes
     * @param name of class
     * @return index of where the class is in classes or -1 if it doesn't exist
     */
    public int subjectExist(String name){
        int index = -1;
        for (int i = 0; i<classes.size(); i++){
            if (classes.get(i).getClassName().equals(name)){
                index = i;
                return index;
            }
        }
        return index;
    }
    /**
     * adds a tasks to a specific subject
     * @param task that user wants to add
     */
    public void addTaskToSubject(Task task){
        if (subjectExist(task.getSubject())>=0){
            classes.get(subjectExist(task.getSubject())).addTask(task);
        }
        else{
            Subject sub = new Subject (task.getName(), task);
            classes.add(sub);
        }

    }
    /**
     * removes tasks from a specific subject
     * @param task that user completed
     */
    public void removeTaskFromSubject(Task task){
       if (subjectExist(task.getSubject())>=0){
            classes.get(subjectExist(task.getSubject())).removeTask(task);
        }
        else{
            System.out.println("This task doesn't belong to any subject!");
        }
    }
    /**
     * Sorts the task in each subject by date
     */
    public void sortTasksinSub(){
        for (int i = 0; i< classes.size(); i++){
            classes.get(i).sortByDate();
        }
    }
    /**
     * marks a task complete in a subject
     * @param sub of the task
     * @param task that was compeleted
     */
    public void markBySub(Subject sub, Task task){
        int indexOfClass = subjectExist(sub.getClassName());
        int indexOfTask = classes.get(indexOfClass).findTask(task);
        classes.get(indexOfClass).getTasks().get(indexOfTask).markAsCompleted();
    }

    /**
     * puts the classes and tasks of each class in a 2D array
     * @return a 2D array of the classes and tasks
     */
    public String[][] getAllSorted(){
        //find the highest number of taxk in any subject
        int highest = classes.get(0).getTotalTasks();
        for (int i = 1; i<classes.size(); i++){
            if (classes.get(i).getTotalTasks()>highest){
                highest =classes.get(i).getTotalTasks();
            }
        }

        String[][] tasksBySubject = new String[highest+1][classes.size()];
        sortTasksinSub();

        //fill first row with class name
        for (int i = 0; i < tasksBySubject[0].length; i++){
            tasksBySubject[0][i] = classes.get(i).getClassName();
        }

        //fill columns by class with task
        int sub = 0;
        int task = 0;
            for (int col = 0; col< tasksBySubject[0].length; col++){
                for (int row = 1; row<classes.get(sub).getTotalTasks()+1; row++){
                    tasksBySubject[row][col] = classes.get(sub).getTasks().get(task).getName();
                    task++;
                }
                task = 0;
                sub++;
            }
        return tasksBySubject;

    }

    /**
     * prints out a 2D array of classes and tasks
     */
    public void printAllTask(){
        String[][] tasks = getAllSorted();
        for (int col = 0; col<tasks[0].length;col++){
            for (int row = 0; row<tasks.length;row++){
                System.out.println(tasks[row][col]);
            }
            System.out.println();
        }

    }






}
