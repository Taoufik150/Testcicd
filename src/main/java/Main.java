public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        manager.addStudent("Ahmed", 15);
        manager.addStudent("Sara", 18);
        manager.addStudent("Youssef", 12);

        System.out.println("=== Gestion des étudiants ===");

        for (StudentManager.Student student : manager.getStudents()) {
            System.out.println(
                student.getName() + " : " + student.getGrade() + "/20"
            );
        }

        System.out.println(
            "Moyenne générale : " + manager.calculateAverage()
        );
    }
}
