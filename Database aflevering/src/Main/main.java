package Main;
import DTO.*;
import sun.util.calendar.BaseCalendar;

import java.util.ArrayList;

public class main {
    public static void main (String[] args) {
         Database databaseDAO = new Database();

        UserDTO user = new UserDTO();
        user.setUserName("Duradel");

        ArrayList<String> roles = new ArrayList();
        roles.add("Pharmacist");
        roles.add("hej");
        roles.add("hehe");


        user.setUserRole(roles);
        databaseDAO.createUser(user);
/*
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setProductID(1);
        recipeDTO.setRecipeDate("Januar 01, 02");
        recipeDTO.setRecipeID(1);

        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("Glukose");
        ingredients.add("natrium");
        ingredients.add("ranarr");

        recipeDTO.setIngredients(ingredients);

    /*    databaseDAO.createRecipe(recipeDTO, user);
     */





    }
}
