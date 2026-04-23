import java.util.ArrayList;

public class Manager{

    private ArrayList<Subject> classes;

    public Manager(){
        classes = new ArrayList();
    }
    public void addSubject(String name){
        Subject subject = new Subject(name);
        classes.add(subject);
    }
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
    public void addTaskToSubject(Task task){
        if (subjectExist(task.getSubject())>=0){
            classes.get(subjectExist(task.getSubject())).addTask(task);
        }
        else{
            Subject sub = new Subject (task.getName(), task);
            classes.add(sub);
        }

    }
    public void removeTaskFromSubject(Task task){
       if (subjectExist(task.getSubject())>=0){
            classes.get(subjectExist(task.getSubject())).removeTask(task);
        }
        else{
            System.out.println("This task doesn't belong to any subject!");
        }
    }
    public void sortTasksinSub(){
        for (int i = 0; i< classes.size(); i++){
            classes.get(i).sortByDate();
        }
    }
   

    public String[][] getAllSorted(){
        //find the highest number of taxk in any subject
        int highest = classes.get(0).getTotalTasks();
        for (int i = 1; i<classes.size(); i++){
            if (classes.get(i).getTotalTasks()>highest){
                highest =classes.get(i).getTotalTasks();
            }
        }

        String[][] tasksBySubject = new String[highest][classes.size()];
        sortTasksinSub();

        //fill first row with class name
        for (int i = 0; i < tasksBySubject[0].length; i++){
            tasksBySubject[0][i] = classes.get(i).getClassName();
        }

        //fill columns by class with task
        for(int i = 0; i < tasksBySubject[0].length; i++){

            for (int row = 1; row<classes.get(i).getTotalTasks(); row++ ){
                tasksBySubject[row][i] = classes.get(i).getSpecificTask(i).getName();
            }
        }
        return tasksBySubject;



    }
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
