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
        try {
            Connection connection = createConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Recipies WHERE recipeID=" + getRecipe_ID);
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
        try {
            Connection connection = createConnection();
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM recpie WHERE recipeIDid=" + getRecipe_ID);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    // Unnder modificering
    public boolean updateRecipe(Recipe recipe) {
        try {
            Connection connection = createConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE recipe SET name=?, pass=?, age=? WHERE id=?");
            ps.setInt(1, recipe.getRecipe_ID());
            ps.setInt(2, recipe.getIngrediens_ID());
            ps.setInt(3, recipe.getDate());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }




    // Under modificering
    public boolean updateComodityBatch(ComodityBatch comodityBatch) {
        try {
            Connection connection = createConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE comodityBatch SET commodityBatch_ID=?," +
                    " productleader_ID=?, Commodity_ID=? WHERE commodityBatch_ID=?"+ getCommodityBatch_ID);
            ps.setInt(1, comodityBatch.getcomodityBatch_ID());
            ps.setInt(2, comodityBatch.getProductleader_ID());
            ps.setInt(3, comodityBatch.getComodity_ID());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


















}
