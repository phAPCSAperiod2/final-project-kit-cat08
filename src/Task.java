public class Task{
    private String name;
    private double dueDate;
    private String subject;
    private boolean isCompleted;

    /**
     * Creates a task object
     * @param name - task name
     * @param dueDate - task due date
     * @param subject - class that task belongs to 
     */
    public Task(String name, double dueDate, String subject){
        this.name = name;
        this.dueDate = dueDate;
        this.subject = subject;
        isCompleted = false;
    }
    // getters and setter
    /**
     * Returns the name of the task
     * @return the name of the task
     */
    public String getName(){
        return name;
    }
    /**
     * Returns the due date of the task
     * @return due date of the task
     */
    public double getDueDate(){
        return dueDate;
    }
    /**
     * changes the due date of the task
     * @param date due date of the assignment
     */
    public void setDueDate(double date){
        dueDate = date;
    }
    /**
     * Returns which subject the task belongs to
     * @return subject the task belongs to
     */
    public String getSubject(){
        return subject;
    }
    /**
     * Returns the status of completion of the task
     * @return status of completion of the task
     */
    public boolean getIsCompleted(){
        return isCompleted;
    }
    /**
     * If the user completes the assignment, changes the iscomplete to relfect that
     */
    public void markAsCompleted(){
        isCompleted = true;
    }

    public String toString(){
        return subject + ": " + name + ", " + dueDate;
    }

}
