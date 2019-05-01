package DTO;


public class RecipeDTO implements IrecipeDTO {
    private int ingredientsID;
    private int productID;
    private String dato;

    @Override
    public int getIngredientsID() {
        return ingredientsID;
    }

    @Override
    public void setIngredientsID(int ingredientsID) {
        this.ingredientsID = ingredientsID;

    }

    @Override
    public int getProductID() {
        return productID;
    }

    @Override
    public void setProductID(int productID) {
        this.productID = productID;

    }
    @Override
    public String getDato() {
        return dato;
    }

    @Override
    public void setDato(String Dato) {
        this.dato = dato;
    }
}

