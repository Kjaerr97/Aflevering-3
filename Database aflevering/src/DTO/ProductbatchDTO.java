package DTO;

public class ProductbatchDTO implements IProductbatchDTO {

    private int productID;
    private int productbatchID;

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
}
