import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceClass extends DBConnection {

    public boolean insertDB(String name, String email) {
        this.getConnection();
        String sql = "INSERT INTO MYSTUDENT(NAME, EMAIL) VALUES(?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return false;
    }

    public List<Student> viewDB() {
        List<Student> result = new ArrayList<>();
        this.getConnection();
        String sql = "SELECT ID, NAME, EMAIL FROM MYSTUDENT";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("NAME"));
                s.setEmail(rs.getString("EMAIL"));
                result.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return result;
    }

    public boolean updateDB(int id, String name, String email) {
        this.getConnection();
        String sql = "UPDATE MYSTUDENT SET NAME = ?, EMAIL = ? WHERE ID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return false;
    }

    public boolean deleteDB(int id) {
        this.getConnection();
        String sql = "DELETE FROM MYSTUDENT WHERE ID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return false;
    }
}
