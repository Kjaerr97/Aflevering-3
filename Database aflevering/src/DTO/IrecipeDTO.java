package DTO;

import java.util.List;

public interface IrecipeDTO {



    int getProductID();

    void setProductID(int productID);

    String getDate();

    void setDate(String Date);

    List<String> getIngredients();

    void setIngredients(List<String> ingredients);

    int getRecipeID();

    String getIngredientName();

    void setRecipeID(int recipeID);

    void addIngredient(String ingredientName);
    }

