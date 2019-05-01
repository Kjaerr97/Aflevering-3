import com.sun.jdi.connect.Connector;

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

    // Under modificering
    public Recipe getRecipe(int id) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Recipies WHERE recipeID=" + getRecipeID);
            if (rs.next()) {
                Recipe recipe = new Recipe();
                recipe.setRecipe_ID(rs.getRecipe_ID("Recipe_ID"));
                recipe.setIngrediens_ID(rs.getInt("Ingrediens_ID"));
                recipe.setDate(rs.getDate("Date"));
                return recipe;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    // Under modificering
    public boolean deleteRecpie(int id) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM recpie WHERE recipeIDid=" + getRecipeID);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;


    }
}
