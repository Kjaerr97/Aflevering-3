package DTO;

import java.sql.Date;

public class OldRecipe implements IOldRecipe {
    int version;
    int recipeID;
    Date oldDate;

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public int getRecipeID() {
        return recipeID;

    }
    @Override
    public Date getOldDate(){
        return oldDate;
    }
}
