import DTO.RecipeDTO;

import java.sql.*;
import java.util.ArrayList;

public class Database  {

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("database URL",
                "username", "password"); // indsæt egne værdier her

    }

    public void createRecipe(RecipeDTO recipeDTO) {

        try (Connection connection = createConnection()) {
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO recipe (getIngredienceRecipeID, produkt_ID, dato) VALUES(?,?,?);");

            preparedStatement.setInt(1,recipeDTO.getIngredientsID());
            preparedStatement.setInt(2,recipeDTO.getProductID);


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

    public List<IComodityDTO> getComodityStatus() throws DALException {
        try (Connection c = createConnection()) {
            Statement statement = c.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT item, amount FROM comodity");

            List<IComodityDTO> comodities = new ArrayList<>();
            while (resultset.next()) {
                IComodityDTO comodity = new ComodityDTO();
                // comodity.setComodityId(resultset.getInt("comodity_id"));
                comodity.setItem(resultset.getString("item"));
                comodity.setAmount(resultset.getInt("amount"));
                comodities.add(comodity);

            }
            return comodities;
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }
}
