package Project.DTO;

import Project.Interfaces.IIngredientsDTO;

public class IngredientsDTO implements IIngredientsDTO {
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
