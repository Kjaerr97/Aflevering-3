package DTO;

import java.util.List;

public interface IFarmaceutDTO {

    int getFarmaceutID();

    void setFarmaceutID(int farmaceutID);

    List<Integer> getRecipes();

    void setRecipes(List<Integer> recipes);

    void addRecipe(int recipeID);

}
