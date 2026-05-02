import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your To-Do List!");
        Manager boss = allSubjects(scan);
        Subject sub = new Subject("calc");
        boolean allCompleted = false;
        addingTasks(boss);
        while (!allCompleted){
            menu(boss);
            boss.printAllTask();
            allCompleted = noMoreTask(boss);
        }
        System.out.println("You've completed all your task!");


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
    public static void addIndividualSub(Manager boss){
        Scanner scan = new Scanner (System.in);
        System.out.println("What is the name of subject or category? ");
        String name = scan.nextLine();
        Subject sub = new Subject(name);
        boss.addSubject(sub);
    }

    public static void addingTasks(Manager boss){
        Scanner scan = new Scanner (System.in);
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
    public static void completedTask(Manager boss){
        Scanner scan = new Scanner (System.in);
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
        boss.markBySub(subs.get(index), subs.get(index).getTasks().get(indexTask));
        boss.removeTaskFromSubject(subs.get(index).getTasks().get(indexTask));
        scan.nextLine();
        }
    }
    public static void menu(Manager boss){
        Scanner scan = new Scanner (System.in);
        System.out.print("Options for To-Do list: \n1.Add new subject\n2.Add new task\n3.Finished tasks\n[pick a number] ");
        int option = scan.nextInt();
        if(option == 1){
            addIndividualSub(boss);
        }
        else if(option ==2){
            addingTasks(boss);
        }
        else if (option == 3){
            completedTask(boss);

        }

    }
    public static boolean noMoreTask(Manager boss){
        ArrayList<Subject>subs = boss.getList();
        for(int i = 0; i<subs.size();i++){
            if(subs.get(i).getTotalTasks()>0){
                return false;
            }
        }
        return true;
    }


}
