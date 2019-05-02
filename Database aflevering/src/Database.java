import DTO.CommodityDTO;
import DTO.ProductbatchDTO;
import DTO.RecipeDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database  {

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("database URL",
                "username", "password"); // indsæt egne værdier her

    }

    public void createRecipe(RecipeDTO recipeDTO) {

        try (Connection connection = createConnection()) {
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO recipe (Ingredients_id, Product_id, Date) VALUES(?,?,?);");

            preparedStatement.setInt(1, recipeDTO.getIngredients());
            preparedStatement.setInt(2,recipeDTO.getProductID());
            preparedStatement.setString(3, recipeDTO.getDate());

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RecipeDTO getRecipe(int recipeID) {
        ResultSet resultset = null;

        try (Connection conn = createConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT recipe.recipe_id," +
                                                                            "product_id," +
                                                                            "date FROM recipe_ingredients INNER JOIN recipe_id " +
                                                                            "ON recipe.recipe_id = recipe_ingredients.recipe_id " +
                                                                            "WHERE recipe.recipe_id = ?");
            preparedStatement.setInt(1, recipeID);
            resultset = preparedStatement.executeQuery();


            RecipeDTO recipe = new RecipeDTO();
            resultset.next();
            recipe.setRecipeID(resultset.getInt("recipe_id"));
            recipe.setProductID(resultset.getInt("product_id"));
            recipe.setDate(resultset.getString("date"));
            while (resultset.next()) {
                recipe.addIngredient(resultset.getString("ingredient_name"));

            }
            return recipe;
        } catch (SQLException e) {
            e.printStackTrace();
        } return null; // få lige fikset det her

    }



    public void deleteRecipe(int recipeID){
        try (Connection conn = createConnection()) {
            conn.setAutoCommit(false);
            PreparedStatement delete = conn.prepareStatement("DELETE FROM recipe " +
                    " WHERE recipe_id = ?");
            delete.setInt(1, recipeID);

            delete = conn.prepareStatement("DELETE FROM recipe_ingredients WHERE recipe_id = ?");
            delete.setInt(1, recipeID);

            conn.commit();
        } catch (SQLException e) {
            System.out.println("couldn't delete user" + e.getMessage());

      }
    }
    public void updateRecipe(RecipeDTO recipe) {

        try (Connection conn = createConnection()) {
            conn.setAutoCommit(false);
            String oldDate;

            PreparedStatement oldDatestmt = conn.prepareStatement("SELECT date FROM recipe where recipe_id = ? ");
            oldDatestmt.setInt(1, );
            resultset = preparedStatement.executeQuery();



            PreparedStatement saveAsOldRecipe = conn.prepareStatement("INSERT INTO oldRecepies" +
                                                                        " (recipe_id, date) " +
                                                                         "VALUES (?,?)");
            saveAsOldRecipe.setInt(1,recipe.getRecipeID());
            saveAsOldRecipe.setString(2,recipe.getDate());
            




            PreparedStatement updateRecipe = conn.prepareStatement("UPDATE recipe SET date = ? " +
                                                                                   " WHERE recipe_id = ?");

            updateRecipe.setString(1, recipe.getDate());
            updateRecipe.setInt(2, recipe.getRecipeID());
            updateRecipe.executeUpdate();

            for(int i = 0; i < recipe.getIngredients().size(); i++) {
                PreparedStatement updateIngredients = conn.prepareStatement("UPDATE recipe_ingredients SET " +
                                                                              " ingredients_id = ? WHERE recipe_id = ?");
                updateIngredients.setString(1,recipe.getIngredients().get(i));
                updateIngredients.setInt(2,recipe.getRecipeID());
                updateIngredients.executeUpdate();
            }
            conn.commit();
        } catch (SQLException e) {
            System.out.println("Couldn't update recipe" + e.getMessage());
        }
    }

    public List<CommodityDTO> getCommodityStatus() throws SQLException {
        try (Connection c = createConnection()) {
            Statement statement = c.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT item, amount FROM comodity");

            List<CommodityDTO> commodities = new ArrayList<>();
            while (resultset.next()) {
                CommodityDTO commodity = new CommodityDTO();
                // comodity.setComodityId(resultset.getInt("comodity_id"));
                commodity.setCommodityName(resultset.getString("item"));
                commodity.setAmount(resultset.getInt("amount"));
                commodities.add(commodity);

            }
            return commodities;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Create productbatches
    public void createProductbatch(ProductbatchDTO ProductbatchDTO) throws SQLException {

        try (Connection connection = createConnection()) {
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Productbatch (Productbatch_id, Product_id) VALUES(?,?);");

            preparedStatement.setInt(1,ProductbatchDTO.getProductbatchID());
            preparedStatement.setInt(2,ProductbatchDTO.getProductID());

            connection.commit();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}