package Project.DTO;

import Project.Interfaces.IUserDTO;

import java.util.List;

public class UserDTO implements IUserDTO {

    List<String> userRoles;
    int userID;
    String userName;
    String role;



    @Override
    public void setUserRole(List<String> userRoles) {
        this.userRoles = userRoles;

    }

    @Override
    public List<String> getUserRole() {
        return userRoles;
    }

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;

    }

    @Override
    public void setUserID(int userID) {
        this.userID = userID;

    }

    public void addRole(String role) {
        this.userRoles.add(role);

    }

}
