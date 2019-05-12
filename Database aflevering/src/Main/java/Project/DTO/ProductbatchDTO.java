package Project.DTO;

import Project.Interfaces.IProductbatchDTO;

public class ProductbatchDTO implements IProductbatchDTO {

    private int productID;
    private int productbatchID;
    private int productbatchAmount;

    @Override
    public int getProductID() {

        return productID;
    }

    @Override
    public void setProductID(int productID) {

        this.productID = productID;
    }


    public int getProductbatchID() {

        return productbatchID;
    }

    @Override
    public void setProductbatchID() {
        this.productbatchID = productbatchID;

    }

    @Override
    public int getProductbatchAmount() {
        return productbatchAmount;
    }

    @Override
    public void setAmount(int amount) {
        this.productbatchAmount = amount;

    }
}
