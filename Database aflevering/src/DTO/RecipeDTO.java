package DTO;


import java.util.List;

public class RecipeDTO implements IrecipeDTO {

    private int productID;
    private String date;
    private List<String> ingredients;
    private int recipeID;



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

    }

    @Override
    public void setDate(String Date) {

    }

    @Override
    public int getRecipeID() {
        return recipeID;
    }
}

