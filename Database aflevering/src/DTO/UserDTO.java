package DTO;

import java.util.List;

public class UserDTO implements IUserDTO {

    List<String> userRoles;
    String role;
    int userID;



    @Override
    public void setUserRole(List<String> roles) {
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
    public void setUserID() {
        this.userID = userID;

    }
    public void addRole(String Role) {
        this.userRoles.add(Role);

    }
}
