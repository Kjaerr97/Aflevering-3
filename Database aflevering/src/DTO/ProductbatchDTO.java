package DTO;

public class ProductbatchDTO implements IProductbatchDTO {

    private int productID;

    @Override
    public int getProductID() {
        return productID;
    }

    @Override
    public void setProductID(int productID) {
        this.productID = productID;
    }




}
