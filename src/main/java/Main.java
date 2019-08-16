import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "parola");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Display Menu:");
        System.out.println("1. Display tables students");
        System.out.println("2. Display tables teachers");
        System.out.println("3. Display tables groupss");
        System.out.println("4. Add student from keyboard");
        System.out.println("5. Add groups from keyboard");
        System.out.println("6. Add  teacher from keyboard ");
        System.out.println("7. Delete student from keyboard");
        System.out.println("8. Delete  teacher from keyboard");
        System.out.println("9. Delete groups from keyboard");
        System.out.println("10. Select student from keyboard");
        System.out.println("11. Select teacher from keyboard");
        System.out.println("12. Select group  from keyboard");


        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        System.out.println(" Your choice: " + choice);

        if (choice.equals("1")) {
            MenuHandler.displayTablesStudents(connection);
        }
        if (choice.equals("2")) {
            MenuHandler.displayTablesTeachers(connection);
        }
        if (choice.equals("3")) {
            MenuHandler.displayTablesGroups(connection);
        }
        if (choice.equals("10")) {
            System.out.println("please type the first name of students: ");
            String firstName = scanner.nextLine();
            System.out.println("please type the last name of students: ");
            String lastName = scanner.nextLine();
            MenuHandler.selectStudent(connection, firstName, lastName);
        }
        if (choice.equals("11")) {
            System.out.println("please type the last name of teacher: ");
            String lastName = scanner.nextLine();
            MenuHandler.selectTeacher(connection, lastName);
        }
        if (choice.equals("12")) {
            System.out.println("please type the name of group");
            String nameg = scanner.nextLine();
            MenuHandler.selectGroup(connection, nameg);
        }
        if (choice.equals("4")) {
            System.out.println("please type the first name of students:");
            String firstName = scanner.nextLine();
            System.out.println("please type the last name of students: ");
            String lastName = scanner.nextLine();
            System.out.println("please type the age of the students");
            Integer age = scanner.nextInt();
            MenuHandler.addStudent(connection, firstName, lastName, age);
        }
         if (choice.equals("5")){
             System.out.println("please type the name of group");
             String name = scanner.nextLine();
             MenuHandler.addGroup(connection, name);
         }
         if(choice.equals("6")){
             System.out.println("please type the first name of teacher");
             String firstName = scanner.nextLine();
             System.out.println("please type the last name of teacher");
             String lastName = scanner.nextLine();
             System.out.println("type");
             String type = scanner.nextLine();
             System.out.println("please type the age of teacher");
             Integer age = scanner.nextInt();
             MenuHandler.addTeacher(connection, firstName, lastName, age, type);
         }

         if(choice.equals("7")){
             System.out.println("please type the first name");
             String firstName = scanner.nextLine();
             MenuHandler.deleteStudent(connection,firstName);
         }
         if(choice.equals("8")){
             System.out.println("please type the first name of teacher");
             String firstName = scanner.nextLine();
             System.out.println("please type the last name of teacher");
             String lastName = scanner.nextLine();
             MenuHandler.deleteTeacher(connection,firstName, lastName);
         }
         if(choice.equals("9")){
             System.out.println("please type the name of group");
             String name = scanner.nextLine();
             MenuHandler.deleteGroup(connection,name);
         }
    }


}
