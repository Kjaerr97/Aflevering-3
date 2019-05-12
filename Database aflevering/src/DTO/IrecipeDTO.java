package DTO;

import java.sql.Date;
import java.util.List;

public interface IrecipeDTO {



    int getProductID();

    void setProductID(int productID);

    String getRecipeDate();

    void setRecipeDate(String recipeDate);

    List<String> getIngredients();

    void setIngredients(List<String> ingredients);

    int getRecipeID();

    String getIngredientName();

    void setRecipeID(int recipeID);

    void addIngredient(String ingredientName);
    }

