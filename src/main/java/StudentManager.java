import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(String name, double grade) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Le nom est obligatoire");
        }

        if (grade < 0 || grade > 20) {
            throw new IllegalArgumentException("La note doit être entre 0 et 20");
        }

        students.add(new Student(name, grade));
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public double calculateAverage() {
        if (students.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Student student : students) {
            total += student.getGrade();
        }

        return total / students.size();
    }

    public static class Student {
        private final String name;
        private final double grade;

        public Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public double getGrade() {
            return grade;
        }
    }
}
