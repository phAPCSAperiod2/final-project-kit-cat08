public class App {
    public static void main(String[] args) throws Exception {
        Task homework = new Task("AP Review", 4.6, "Chemistry");
        System.out.println(homework);
        Subject subject1 = new Subject (homework.getSubject(), homework);
    }
}
