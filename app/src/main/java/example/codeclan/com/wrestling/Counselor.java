package example.codeclan.com.wrestling;

import java.util.Date;

import db.SqlRunner;

/**
 * Created by grahambruce on 26/06/2017.
 */

public class Counselor {

    private int id;
    private String first_name;
    private String nick_name;
    private String last_name;
    private String telephone;
    private String email;
    private String member_since;

    public Counselor(int id, String first_name, String nick_name, String last_name, String telephone, String email, String member_since){
        this.id = id;
        this.first_name = first_name;
        this.nick_name = nick_name;
        this.last_name = last_name;
        this.telephone = telephone;
        this.email = email;
        this.member_since = member_since;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMember_since() {
        return member_since;
    }

    public void setMember_since(String member_since) {
        this.member_since = member_since;
    }

    public void save(){
        String sql = String.format("INSERT INTO counselors (first_name, nick_nane, last_name, telephone, email, member_since) " +
                "VALUES ('%s', '%s', '%s', '%s', '%s', '%s');", this.first_name, this.nick_name, this.last_name);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void deleteAll() {
        String sql = "DELETE FROM counselors;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }
}
