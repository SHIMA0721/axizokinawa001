package db;

public class UserInfo {

    private String user_id;
    private String user_name;
    private String password;

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }
    public String getUserId() {
        return this.user_id;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }
    public String getUserName() {
        return this.user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
}
