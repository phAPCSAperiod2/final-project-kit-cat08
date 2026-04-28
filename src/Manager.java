import java.util.ArrayList;

public class Manager{

    private ArrayList<Subject> classes;

    public Manager(){
        classes = new ArrayList();
    }

    public void addSubject(Subject subject){
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

    public void markBySub(Subject sub, Task task){
        int indexOfClass = subjectExist(sub.getClassName());
        int indexOfTask = classes.get(indexOfClass).findTask(task);
        classes.get(indexOfClass).getTasks().get(indexOfTask).markAsCompleted();
    }


    public String[][] getAllSorted(){
        //find the highest number of taxk in any subject
        int highest = classes.get(0).getTotalTasks();
        for (int i = 1; i<classes.size(); i++){
            if (classes.get(i).getTotalTasks()>highest){
                highest =classes.get(i).getTotalTasks();
            }
        }
        System.out.println(highest);

        String[][] tasksBySubject = new String[highest+1][classes.size()];
        sortTasksinSub();

        //fill first row with class name
        for (int i = 0; i < tasksBySubject[0].length; i++){
            tasksBySubject[0][i] = classes.get(i).getClassName();
        }

        //fill columns by class with task
        for(int i = 0; i < tasksBySubject[0].length; i++){

            for (int row = 1; row<tasksBySubject.length; row++ ){

                for(int task = 0; task< classes.get(i).getTotalTasks();task++){
                    tasksBySubject[row][i] = classes.get(i).getSpecificTask(task).getName();
                }

            }
        }
        return tasksBySubject;

    }


    public void printAllTask(){
        String[][] tasks = getAllSorted();
        for (int col = 0; col<tasks[0].length;col++){
            System.out.println(tasks[0][col]);
            for (int row = 1; row<tasks.length;row++){
                System.out.println(tasks[row][col]);
            }
            System.out.println();
        }

    }






}
