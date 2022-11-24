import java.sql.*;

public class StudentDao {
    public  Connection connection = null;
    public Student getStudent(int roll_number) throws ClassNotFoundException, SQLException {
        String query = "select nameOfStudent from student where roll_number = "+roll_number+";";
        Student s = new Student();
        s.roll_number = roll_number;
        connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            String name = rs.getString(1);
            s.nameOfStudent = name;
        }
        return s;

    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/REGISTER","root","root");
        return connection;
    }

    public int addStudent(Student student) throws SQLException, ClassNotFoundException {
        String query = "insert into student values (?, ?);";
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, student.roll_number);
        preparedStatement.setString(2, student.nameOfStudent);
        preparedStatement.executeUpdate();
        return 1;

    }

    public  int removeStudent(int roll_number) throws SQLException, ClassNotFoundException {
        String query = "delete from student where roll_number = ?;";
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, roll_number);
        preparedStatement.executeUpdate();
        return  1;
    }
}
