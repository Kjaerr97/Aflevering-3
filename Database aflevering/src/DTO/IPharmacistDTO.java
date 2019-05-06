package DTO;

import java.util.List;

public interface IPharmacistDTO {

    int getFarmaceutID();

    void setFarmaceutID(int farmaceutID);

    List<Integer> getRecipes();

    void setRecipes(List<Integer> recipes);

    void addRecipe(int recipeID);

}
