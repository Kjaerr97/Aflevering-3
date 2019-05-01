import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements databaseDAO {

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("database URL",
                "username", "password"); // indsæt egne værdier her

    }

    








}
