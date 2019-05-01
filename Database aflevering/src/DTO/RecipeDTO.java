package DTO;


public class RecipeDTO {
    private int ingredientsID;
    private int productID;
    private String dato;

    public int getIngredientsID() {
        return ingredientsID;
    }

    public void setIngredientsID(int ingredientsID) {
        this.ingredientsID = ingredientsID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}
