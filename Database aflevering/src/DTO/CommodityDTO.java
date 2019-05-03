package DTO;

public class CommodityDTO implements ICommodityDTO {
    private int ingredientsID;
    private String commodityName;
    private int commodityBatchID;
    private int amount;
    private int commodityID;



    @Override
    public String getCommodityName() {
        return commodityName;
    }

    @Override
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;

    }

    @Override
    public int getIngredients() {
        return ingredientsID;
    }

    @Override
    public void setIngredientsID(int ingredientsID) {
        this.ingredientsID = ingredientsID;
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
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
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
