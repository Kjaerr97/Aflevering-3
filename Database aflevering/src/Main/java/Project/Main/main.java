package Project.Main;

public class main {
    public static void main (String[] args) {
         Database databaseDAO = new Database();


/*createCommoditybatch
        UserDTO user = new UserDTO();
        user.setUserName("Lars");
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Productleader");
        user.setUserRole(roles);

        CommodityDTO ranarr = new CommodityDTO();
        CommoditybatchDTO ranarrBatch = new CommoditybatchDTO();
        ranarr.setCommodityID(1);
        ranarrBatch.setAmount(4);
        databaseDAO.createCommoditybatch(ranarrBatch,ranarr,user);
*/


/* getCommodityBatchStatus

     UserDTO user = new UserDTO();
     user.setUserName("Lars");
     ArrayList<String> roles = new ArrayList<>();
     roles.add("Productleader");
     user.setUserRole(roles);

     databaseDAO.getCommodityBatchStatus(user);
*/



/* updateCommodityBatch
        UserDTO user = new UserDTO();
        user.setUserName("Lars");
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Productleader");
        user.setUserRole(roles);

        CommoditybatchDTO ranarrBatch = new CommoditybatchDTO();
        ranarrBatch.setCommodityBatchID(1);
        ranarrBatch.setAmount(8);

        databaseDAO.updateCommodityBatch(ranarrBatch,user);
*/


/*getCommodityStatus
        UserDTO user = new UserDTO();
        user.setUserName("Lars");
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Productleader");
        user.setUserRole(roles);

        databaseDAO.getCommodityStatus(user);
*/


/*
        UserDTO user = new UserDTO();
        user.setUserName("Lars");
        ArrayList<String> roles = new ArrayList();
        roles.add("Labtec");
        user.setUserID(1);
        databaseDAO.deleteUser(1);
        user.setUserRole(roles);
        databaseDAO.createUser(user);
*/

/*updateUser
        UserDTO user = new UserDTO();
        user.setUserName("Carl");
        ArrayList<String> roles = new ArrayList();
        roles.add("Labtec");
        user.setUserID(2);
        user.setUserRole(roles);
        databaseDAO.updateUser(user);

*/

/* createRecipe
        UserDTO user = new UserDTO();
        ArrayList<String> roles = new ArrayList();
        roles.add("Pharmacist");
        user.setUserID(1);
        user.setUserRole(roles);

        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setProductID(1);
        recipeDTO.setRecipeDate("Januar 01, 2019");
        recipeDTO.setRecipeID(1);

        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("Glukose");
        ingredients.add("natrium");
        ingredients.add("ranarr");
        recipeDTO.setIngredients(ingredients);

        databaseDAO.createRecipe(recipeDTO, user);
*/

/*updateRecipe
        UserDTO user = new UserDTO();
        ArrayList<String> roles = new ArrayList();
        roles.add("Pharmacist");
        user.setUserRole(roles);

        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setRecipeID(1);
        recipeDTO.setRecipeDate("Januar 01, 2019");

        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("Irit");
        ingredients.add("Glukose");
        ingredients.add("Natrium");
        recipeDTO.setIngredients(ingredients);

        databaseDAO.updateRecipe(recipeDTO,user);

*/

/* deleteRecipe
        UserDTO user = new UserDTO();
        ArrayList<String> roles = new ArrayList();
        roles.add("Pharmacist");
        user.setUserRole(roles);

        databaseDAO.deleteRecipe(1,user);

*/
    }

}
