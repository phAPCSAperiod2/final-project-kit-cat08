import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your To-Do List!");
        Manager boss = allSubjects(scan);


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
            System.out.println(subs.get(i));
        }
        String answer = scan.nextLine();
        if (boss.subjectExist(answer.toLowerCase())>=0){
            int index = boss.subjectExist(answer.toLowerCase());
            System.out.println("What is the name of the task?");
            String name = scan.nextLine();
            System.out.println("When is it due? [ex. 4.12]");


        }
    }


}
