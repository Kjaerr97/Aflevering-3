package Project.DTO;

import Project.Interfaces.IRolesDTO;

public class RoleDTO implements IRolesDTO {
    public String role;

    @Override
    public void setRole() {
        this.role = role;
    }

    @Override
    public String getRole() {
        return role;
    }
}
