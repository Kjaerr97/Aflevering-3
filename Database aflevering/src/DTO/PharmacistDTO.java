package DTO;

import java.util.List;

public class PharmacistDTO implements IPharmacistDTO {
    private int pharmacistID;
    private List<Integer> recipes;

    @Override
    public int getPharmacistID() {
        return pharmacistID;
    }

    @Override
    public void setPharmacistID(int pharmacistID) {
        this.pharmacistID = pharmacistID;
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
