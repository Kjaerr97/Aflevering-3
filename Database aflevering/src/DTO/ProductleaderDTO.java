package DTO;

public class ProductleaderDTO implements IProductleaderDTO {
    private int ProductbatchID;
    private int CommoditybatchID;
    private String Name;


    public int getProductbatchID(){
        return ProductbatchID;
    }

    public void setProductbatchID(int ProductbatchID) {
        this.ProductbatchID = ProductbatchID;
    }

    public int getCommoditybatchID() {
        return CommoditybatchID;
    }

    public void setCommoditybatchID() {
        this.CommoditybatchID = CommoditybatchID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = Name;
    }

    @Override
    public void setCommoditybatchID(int CommoditybatchID) {

    }
}