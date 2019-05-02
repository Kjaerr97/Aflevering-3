package DTO;

public class OldRecipe implements IOldRecipe {
    int version;
    int recipeID;

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public int getRecipeID() {
        return recipeID;

    }
}
