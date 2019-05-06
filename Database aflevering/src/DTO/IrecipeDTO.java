package DTO;

import java.sql.Date;
import java.util.List;

public interface IrecipeDTO {



    int getProductID();

    void setProductID(int productID);

    Date getRecipeDate();

    void setRecipeDate(Date recipeDate);

    List<String> getIngredients();

    void setIngredients(List<String> ingredients);

    int getRecipeID();

    String getIngredientName();

    void setRecipeID(int recipeID);

    void addIngredient(String ingredientName);
    }

