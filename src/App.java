import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your To-Do List!");
        Manager boss = allSubjects(scan);
        addingTasks(boss,scan);
        boss.printAllTask();
        System.out.println("Have you completed any tasks in a subject? [yes/no] ");
        String answer = scan.nextLine();
        while (answer.toLowerCase().equals("yes")){
            completedTask(boss, scan);
            System.out.println("Have you completed any other tasks in a subject? [yes/no] ");
            answer = scan.nextLine();
        }
        boss.printAllTask();

    }

    public static Manager allSubjects(Scanner scan){
        Manager boss = new Manager();
        System.out.println("How many classes do you take?");
        int totalClasses = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i<totalClasses; i++){
            System.out.println("Name of Class: ");
            Subject sub = new Subject(scan.nextLine().toLowerCase());
            boss.addSubject(sub);
        }
        System.out.println("Would you like a miscellaneous category? [yes/no] ");
        if (scan.nextLine().toLowerCase().equals("yes")){
            Subject random = new Subject("miscellaneous");
            boss.addSubject(random);
        }
        return boss;
    }

    public static void addingTasks(Manager boss, Scanner scan){
        ArrayList<Subject> subs = boss.getList();
        System.out.println("What would you like to add a task to?");
        for (int i = 0; i <subs.size(); i++){
            System.out.println(subs.get(i).getClassName());
        }
        String answer = scan.nextLine();
        System.out.println("How many tasks would you like to add? ");
        int amount = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i<amount; i++){
            System.out.println("What is the name of the task?");
            String name = scan.nextLine();
            System.out.println("When is it due? [ex. 4.12]");
            double date = scan.nextDouble();
            scan.nextLine();
            Task task = new Task (name, date, answer);
            boss.addTaskToSubject(task);
        }
    }
    public static void completedTask(Manager boss, Scanner scan){
        System.out.println("Which subject does the task belong in? ");
        ArrayList<Subject> subs = boss.getList();
        for (int i = 0; i <subs.size(); i++){
            System.out.println(subs.get(i).getClassName());
        }
        String subject = scan.nextLine();
        int index = boss.subjectExist(subject.toLowerCase());
        subs.get(index).allTasks();
        System.out.println("How many task did you complete? ");
        int amount = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i<amount; i++){
        System.out.println("What task did you complete? ");
        String task = scan.nextLine();
        int indexTask = subs.get(index).findTask(task);
        subs.get(index).markTask(subs.get(index).getTasks().get(indexTask));
        boss.removeTaskFromSubject(subs.get(index).getTasks().get(indexTask));
        }


    }



}
