package DTO;

import java.util.List;

public interface IUserDTO {

   void setUserRole(List<String> roles);

   List<String> getUserRole();

   int getUserID();

   void setUserID();

}
