import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        StudentDao studentDao = new StudentDao();
        Student s1 = new Student();
//      getStudentExample(studentDao,s1);
//        AddStudentExample(studentDao, s1);
        studentDao.removeStudent(18);

    }

    private static void AddStudentExample(StudentDao studentDao, Student s1) throws SQLException, ClassNotFoundException {
        s1.roll_number =18;
        s1.nameOfStudent = "Yuvanesh";
        int rowsAffected = studentDao.addStudent(s1);
        System.out.println(rowsAffected+ " no of row/s affected!");
    }

    private static Student getStudentExample(StudentDao studentDao, Student s1) throws ClassNotFoundException, SQLException {
        s1 = studentDao.getStudent(18);
        System.out.println(s1.nameOfStudent);
        return s1;
    }
}
