package Main;
import DTO.CommodityDTO;
import DTO.CommoditybatchDTO;
import DTO.Database;

public class main {
    public static void main(String[] args) {
         Database databaseDAO = new Database();

        CommodityDTO commodityDTO = new CommodityDTO();
        CommoditybatchDTO commoditybatchDTO = new CommoditybatchDTO();

        commodityDTO.setCommodityID(1);
        commoditybatchDTO.setAmount(234);
        

        databaseDAO.createCommoditybatch(commoditybatchDTO, commodityDTO);
    }
}
