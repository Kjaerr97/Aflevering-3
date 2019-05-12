package Project.DTO;

import Project.Interfaces.IProductDTO;

public class ProductDTO implements IProductDTO {
    private int labtecID;
    private int commodityID;


    @Override
    public int getLabtecID() {
        return labtecID;
    }

    @Override
    public void setLabtecID(int labtecID) {
        this.labtecID = labtecID;
    }

    @Override
    public int getCommodityID() {
        return commodityID;
    }

    @Override
    public void setCommodityID(int commodityID) {
        this.commodityID = commodityID;
    }
}
