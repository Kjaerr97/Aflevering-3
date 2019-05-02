package DTO;


import java.util.List;

public class RecipeDTO implements IrecipeDTO {

    private int productID;
    private String date;
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
    public String getDate() {
        return date;
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
    public void setDate(String Date) {
        this.date = date;

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
    public void addRole(String ingredientName) {
        this.ingredientName = ingredientName;

    }

}

