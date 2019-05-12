package Project.DTO;

import Project.Interfaces.ICommoditybatchDTO;

public class CommoditybatchDTO implements ICommoditybatchDTO {

    private int commodityID;
    private int commodityBatchID;
    private int batchAmount;

    @Override
    public int getCommodityID() {
        return commodityID;
    }

    @Override
    public void setCommodityID(int commodityID) {
        this.commodityID = commodityID;
    }

    @Override
    public int getCommodityBatchID() {
        return commodityBatchID;
    }

    @Override
    public void setCommodityBatchID(int commodityBatchID) {
        this.commodityBatchID = commodityBatchID;
    }

    @Override
    public void setAmount(int amount) {
        this.batchAmount = amount;
    }

    @Override
    public int getBatchAmount() {
        return batchAmount;
    }
}
