package DTO;

import java.util.List;

public interface IUserDTO {

   void setUserRole(List<String> roles);

   List<String> getUserRole();

   int getUserID();

   String getUserName();

   void setUserName(String userName);

   void setUserID(int userID);



}
