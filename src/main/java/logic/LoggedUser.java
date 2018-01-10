package logic;

public class LoggedUser {
    private String userName;
    private String userID;

    public LoggedUser(String userName,String userID){
        this.userName = userName;
        this.userID = userID;
    }

    public LoggedUser(){

    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }
}
