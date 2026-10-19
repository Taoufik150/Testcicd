public class StudentManagerTest {

    public static void main(String[] args) {

        testAddStudent();
        testCalculateAverage();
        testRejectInvalidGrade();

        System.out.println("Tous les tests sont réussis !");
    }

    private static void testAddStudent() {

        StudentManager manager = new StudentManager();

        manager.addStudent("Ahmed", 15);

        if (manager.getStudents().size() != 1) {
            throw new AssertionError("L'étudiant n'a pas été ajouté");
        }

        System.out.println("PASS : ajout d'un étudiant");
    }

    private static void testCalculateAverage() {

        StudentManager manager = new StudentManager();

        manager.addStudent("Ahmed", 10);
        manager.addStudent("Sara", 20);

        double average = manager.calculateAverage();

        if (average != 15.0) {
            throw new AssertionError("La moyenne calculée est incorrecte");
        }

        System.out.println("PASS : calcul de la moyenne");
    }

    private static void testRejectInvalidGrade() {

        StudentManager manager = new StudentManager();

        try {
            manager.addStudent("Ahmed", 25);

            throw new AssertionError(
                "Une note supérieure à 20 aurait dû être refusée"
            );

        } catch (IllegalArgumentException exception) {
            System.out.println("PASS : rejet d'une note invalide");
        }
    }
}
