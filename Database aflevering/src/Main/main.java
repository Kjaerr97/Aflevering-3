package Main;
import DTO.CommoditybatchDTO;
import DTO.Database;

public class main {
    public static void main(String[] args) {
         Database databaseDAO = new Database();

        CommoditybatchDTO commoditybatchDTO = new CommoditybatchDTO();
        commoditybatchDTO.setCommodityID(45);
        commoditybatchDTO.setAmount(234);

        databaseDAO.createCommoditybatch(commoditybatchDTO);
    }
}
