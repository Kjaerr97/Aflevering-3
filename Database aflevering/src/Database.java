import java.sql.*;

public class Database implements databaseDAO {

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("database URL",
                "username", "password"); // indsæt egne værdier her

    }

    public void createRecipe() {

        try (Connection connection = createConnection()) {
            connection.setAutoCommit(false);

            PreparedStatement createRecipe = connection.prepareStatement(
                    "INSERT INTO recipe (getIngredienceRecipeID, produkt_ID, dato) VALUES(?,?,?);");

            createRecipe.setInt(getIngredienceRecipeID);


            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
