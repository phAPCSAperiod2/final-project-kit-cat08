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

    public String[][] getAllSorted(){
        //find the highest number of taxk in any subject
        int highest = classes.get(0).getTotalTasks();
        for (int i = 1; i<classes.size(); i++){
            if (classes.get(i).getTotalTasks()>highest){
                highest =classes.get(i).getTotalTasks();
            }
        }

        String[][] tasksBySubject = new String[highest][classes.size()];

        for (int i = 0; i< tasksBySubject[].length;i++){

        }



    }






}
