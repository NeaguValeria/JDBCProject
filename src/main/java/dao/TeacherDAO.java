package dao;

import entity.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    public static List<Teacher> selectTeacherByGroupID(Connection connection, Integer id) {
        String sql = "SELECT * FROM teacher INNER JOIN teachers_groups ON " +
                "teacher.id = teachers_groups.teacher_id WHERE teachers_groups.group_id = ?";
        ResultSet rs;
        List<Teacher> teachers = new ArrayList<Teacher>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setFirstName(rs.getString("first_name"));
                teacher.setLastName(rs.getString("last_name"));
                teacher.setAge(rs.getInt("age"));
                teacher.setType(rs.getString("type"));
                teachers.add(teacher);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
}
