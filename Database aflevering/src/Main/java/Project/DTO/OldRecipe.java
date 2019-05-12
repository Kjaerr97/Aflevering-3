package Project.DTO;

import Project.Interfaces.IOldRecipe;

public class OldRecipe implements IOldRecipe {
    int version;
    int recipeID;
    String oldDate;

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public int getRecipeID() {
        return recipeID;

    }
    @Override
    public String getOldDate(){
        return oldDate;
    }
}
