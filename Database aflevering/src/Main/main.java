package Main;
import DTO.*;
import sun.util.calendar.BaseCalendar;

import java.util.ArrayList;

public class main {
    public static void main (String[] args) {
         Database databaseDAO = new Database();

     /*CHECK COMMODITY
         UserDTO user = new UserDTO();
        user.setUserName("Nieve");
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Productleader") 
          user.setUserRole(roles);
        databaseDAO.getCommodityBatchStatus(user);
      */

       /*CHECK COMMODITY
        UserDTO user = new UserDTO();
        user.setUserName("Nieve");
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Productleader");
        user.setUserRole(roles);

        CommodityDTO ranarr = new CommodityDTO();
        CommoditybatchDTO ranarrBatch = new CommoditybatchDTO();
        ranarr.setCommodityID(1);
        ranarrBatch.setAmount(4);
        databaseDAO.createCommoditybatch(ranarrBatch,ranarr,user);
        */

       /*UPDATE COMMODITYBATCH
        UserDTO user = new UserDTO();
        user.setUserName("Nieve");
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Productleader");
        user.setUserRole(roles);

        CommoditybatchDTO ranarrBatch = new CommoditybatchDTO();
        ranarrBatch.setCommodityBatchID(1);
        ranarrBatch.setAmount(8);

        databaseDAO.updateCommodityBatch(ranarrBatch,user);
*/
       /* getCommodityBatchStatus
        UserDTO user = new UserDTO();
        user.setUserName("Nieve");
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Productleader");
        user.setUserRole(roles);

        databaseDAO.getCommodityBatchStatus(user);
*/
       /*GETCOMMODITYSTATUS
        UserDTO user = new UserDTO();
        user.setUserName("Nieve");
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Productleader");
        user.setUserRole(roles);

        databaseDAO.getCommodityStatus(user);
        */



        /* createUser
        ArrayList<String> roles = new ArrayList();
        roles.add("Labtec");
        user.setUserID(1);
        databaseDAO.deleteUser(1);
        user.setUserRole(roles);
         databaseDAO.createUser(user);
       */

        /* UpdateUser
        ArrayList<String> roles = new ArrayList();
        roles.add("Labtec");
        user.setUserID(1);
        databaseDAO.deleteUser(1);
        user.setUserRole(roles);
        databaseDAO.updateUser(user);
         */

/*      createRecipe
        UserDTO user = new UserDTO();
        ArrayList<String> roles = new ArrayList();
        roles.add("Pharmacist");
        user.setUserID(1);
        user.setUserRole(roles);

        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setProductID(1);
        recipeDTO.setRecipeDate("Januar 01, 02");
        recipeDTO.setRecipeID(1);

        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("Glukose");
        ingredients.add("natrium");
        ingredients.add("ranarr");
        recipeDTO.setIngredients(ingredients);

        databaseDAO.createRecipe(recipeDTO, user);
*/
/* updateRecipe
        UserDTO user = new UserDTO();
        ArrayList<String> roles = new ArrayList();
        roles.add("Pharmacist");
        user.setUserRole(roles);

        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setRecipeID(1);
        recipeDTO.setRecipeDate("Januar 01, 02");

        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("Irit");
        ingredients.add("Glukose");
        ingredients.add("Natrium")
        recipeDTO.setIngredients(ingredients);

        databaseDAO.updateRecipe(recipeDTO,user);
*/
/*
        UserDTO user = new UserDTO();
        ArrayList<String> roles = new ArrayList();
        roles.add("Pharmacist");
        user.setUserRole(roles);
        databaseDAO.deleteRecipe(1,user);
*/





    }

}
