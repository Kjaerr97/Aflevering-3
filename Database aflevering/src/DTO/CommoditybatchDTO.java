package DTO;

public class CommoditybatchDTO implements ICommoditybatchDTO {

    private int commodityID;

    @Override
    public int getCommodityID() {
        return commodityID;
    }

    @Override
    public void setCommodityID(int commodityID) {
        this.commodityID = commodityID;
    }
}
