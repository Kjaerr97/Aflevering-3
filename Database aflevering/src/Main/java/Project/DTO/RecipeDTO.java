package Project.DTO;


import Project.Interfaces.IrecipeDTO;

import java.util.List;

public class RecipeDTO implements IrecipeDTO {

    private int productID;
    private String recipeDate;
    private List<String> ingredients;
    private int recipeID;
    private String ingredientName;



    @Override
    public int getProductID() {
        return productID;
    }

    @Override
    public void setProductID(int productID) {
        this.productID = productID;

    }
    @Override
    public String getRecipeDate() {
        return recipeDate;
    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;

    }

    @Override
    public void setRecipeDate(String recipeDate) {
        this.recipeDate = recipeDate;

    }

    @Override
    public int getRecipeID() {
        return recipeID;
    }

    @Override
    public String getIngredientName() {
        return ingredientName;
    }

    @Override
    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    @Override
    public void addIngredient(String ingredientName) {
        this.ingredients.add(ingredientName);

    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}

