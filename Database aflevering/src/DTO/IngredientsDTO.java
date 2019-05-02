package DTO;

public class IngredientsDTO implements IIngredientsDTO{
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
