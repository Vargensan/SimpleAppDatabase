package data.config;

/**
 * Created By Bartłomiej Woś
 */
public class DatabaseLogin {

    private String username;
    private String password;

    public DatabaseLogin(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
