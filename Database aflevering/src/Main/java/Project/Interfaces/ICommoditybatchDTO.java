package Project.Interfaces;

public interface ICommoditybatchDTO {

    int getCommodityID();

    void setCommodityID(int commodityID);

    int getCommodityBatchID();

    void setCommodityBatchID(int commodityBatchID);

    void setAmount(int batchAmount);

    int getBatchAmount();

}
