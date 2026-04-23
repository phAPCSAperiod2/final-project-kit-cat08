import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your To-Do List!");


        Task homework = new Task("AP Review", 4.6, "Chemistry");
        Task homework2 = new Task("Study", 4.5, "Chemistry");
        Subject subject1 = new Subject (homework.getSubject(), homework);
        System.out.println(subject1.getClassName());
        subject1.addTask(homework2);
        subject1.allTasks();
        homework2.markAsCompleted();
        subject1.removeTask(homework2);
        subject1.removeTask(homework);
        subject1.allTasks();




    }
}
