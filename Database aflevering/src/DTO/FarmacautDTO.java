package DTO;

import java.util.List;

public class FarmacautDTO implements IFarmaceutDTO {
    private int farmaceutID;
    private List<Integer> recipes;

    @Override
    public int getFarmaceutID() {
        return farmaceutID;
    }

    @Override
    public void setFarmaceutID(int farmaceutID) {
        this.farmaceutID = farmaceutID;
    }

    @Override
    public List<Integer> getRecipes() {
        return recipes;
    }

    @Override
    public void setRecipes(List<Integer> recipes) {
        this.recipes = recipes;
    }

    @Override
    public void addRecipe(int recipeID) {
        this.recipes.add(recipeID);
    }
}
