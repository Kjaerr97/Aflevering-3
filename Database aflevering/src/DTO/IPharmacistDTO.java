package DTO;

import java.util.List;

public interface IPharmacistDTO {

    int getPharmacistID();

    void setPharmacistID(int pharmacistID);

    List<Integer> getRecipes();

    void setRecipes(List<Integer> recipes);

    void addRecipe(int recipeID);

}
