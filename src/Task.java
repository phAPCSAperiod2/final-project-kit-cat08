public class Task{
    private String name;
    private double dueDate;
    private String subject;
    private boolean isCompleted;

    public Task(String name, double dueDate, String subject){
        this.name = name;
        this.dueDate = dueDate;
        this.subject = subject;
        isCompleted = false;
    }

    public String getName(){
        return name;
    }

    public double getDueDate(){
        return dueDate;
    }

    public void setDueDate(double date){
        dueDate = date;
    }

    public String getSubject(){
        return subject;
    }

    public boolean getIsCompleted(){
        return isCompleted;
    }

    public void markAsCompleted(){
        isCompleted = true;
    }

}
