import java.sql.*;

public class MenuHandler {

    public static void displayTablesStudents(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Integer age = rs.getInt("age");
                System.out.println("Studentul cu id-ul: " + id + " " + "este " + " " + firstName + " " +
                        lastName + " " + " ai are virsta de: " + " " + age + " ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayTablesTeachers(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teacher");

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Integer age = rs.getInt("age");
                String type = rs.getString("type");
                System.out.println("Teacher with id: " + id + " " + firstName + " " + lastName + " " +
                        age + " " + "teacher of " + type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayTablesGroups(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM groupss");

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(" Group  with id: " + id + " " + "is " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectStudent(Connection connection, String firstName, String lastName) {
        String sql = "SELECT * FROM students WHERE first_name = ? and last_name = ?";
        ResultSet rs;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                firstName = rs.getString("first_name");
                lastName = rs.getString("last_name");
                Integer age = rs.getInt("age");
                System.out.println("Searched student have id : " + id + " " + firstName + " " + lastName + " " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectTeacher(Connection connection, String lastName) {
        String sql = "SELECT *FROM teacher WHERE last_name = ?";
        ResultSet rs;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, lastName);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("first_name");
                lastName = rs.getString("last_name");
                String type = rs.getString("type");
                System.out.println("Searched teacher: " + firstName + " " + lastName + " " + type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectGroup(Connection connection, String name) {
        String sql = "SELECT * FROM groupss WHERE name = ?";
        ResultSet rs;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nameGroup = rs.getString("name");
                System.out.println("Searched group have id: " + id + " " + nameGroup);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(Connection connection, String firstName, String lastName, int age) {
        String sql = "INSERT INTO students (first_name, last_name, age)VALUES (?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setInt(3, age);
            int resultSet = stmt.executeUpdate();
            if (resultSet == 1) {
                System.out.println("has been inserted");
            } else {
                System.out.println("not inserted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addGroup(Connection connection, String name) {
        String sql = "INSERT INTO groupss (name) VALUES (?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            int resultSet = stmt.executeUpdate();
            if (resultSet == 1) {
                System.out.println("has been inserted");
            } else {
                System.out.println("not inserted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addTeacher(Connection connection, String first_name, String last_name, int age, String type) {
        String sql = "INSERT INTO teacher (first_name, last_name, age, type) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setInt(3, age);
            stmt.setString(4, type);
            int resultSet = stmt.executeUpdate();
            if (resultSet == 1) {
                System.out.println("has been inserted");
            } else {
                System.out.println("not inserted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(Connection connection, String firstName) {
        String sql = " DELETE FROM students WHERE first_name = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, firstName);
            int resulSet = stmt.executeUpdate();
            if (resulSet == 1) {
                System.out.println("deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
