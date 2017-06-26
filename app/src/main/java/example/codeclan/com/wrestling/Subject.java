package example.codeclan.com.wrestling;

import java.sql.ResultSet;

import db.SqlRunner;

import static android.webkit.WebSettings.PluginState.ON;

/**
 * Created by grahambruce on 26/06/2017.
 */

public class Subject {

    private int id;
    private String name;
    private String description;
    private int counselor_id;

    public Subject(int id, String name, String description, int counselor_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.counselor_id = counselor_id;
    }

    public Subject(String name, String description, int counselor_id) {
        this.name = name;
        this.description = description;
        this.counselor_id = counselor_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCounselor_id() {
        return counselor_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCounselor_id(int counselor_id) {
        this.counselor_id = counselor_id;
    }

    public void save() {
        String sql = String.format("INSERT INTO subjects (name, description, counselor_id) " +
                "VALUES ('%s', '%s', %d);", this.name, this.description, this.counselor_id);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void deleteAll() {
        String sql = "DELETE FROM subjects;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void displaySubjectName() {
        String sql = "SELECT id, name FROM subjects;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.print(id);
                System.out.print(" ");
                System.out.println(name);
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public static void getAllDetails(int chosen_id) {
        String sql = String.format("SELECT subjects.description, counselors.first_name, counselors.nick_name, counselors.last_name, counselors.telephone, counselors.email, counselors.member_since FROM subjects JOIN counselors ON counselors.id = subjects.counselor_id WHERE subjects.id = %d;", chosen_id);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String description = rs.getString("description");
                String first_name = rs.getString("first_name");
                String nick_name = rs.getString("nick_name");
                String last_name = rs.getString("last_name");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                String member_since = rs.getString("member_since");
                System.out.println("Description: " + description);
                System.out.println(first_name + nick_name + last_name);
                System.out.println("Phone Number: " + telephone);
                System.out.println("Email: " + email);
                System.out.println("Member Since " + member_since);
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }
}
