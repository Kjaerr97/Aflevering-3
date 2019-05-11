package DTO;

import DTO.CommodityDTO;
import DTO.CommoditybatchDTO;
import DTO.ProductbatchDTO;
import DTO.RecipeDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Database {

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s180911", "s180911", "QekXA8EbroGRPIN1MOpRI");

    }


    public void createRecipe(RecipeDTO recipeDTO, UserDTO userDTO) {

        if (userDTO.getUserRole().contains("Pharmacist") || userDTO.getUserRole().contains("")) {
            try (Connection connection = createConnection()) {
                connection.setAutoCommit(false);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO recipe (ingredients_id, product_id, recipe_date) VALUES(?,?,?);");
                preparedStatement.setString(1, recipeDTO.getIngredientName());
                preparedStatement.setInt(2, recipeDTO.getProductID());
                preparedStatement.setDate(3, recipeDTO.getRecipeDate());

                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("You dont have permission to create a recipe.");
        }
    }

    public RecipeDTO getRecipe(int recipeID, UserDTO userDTO) {
        if (userDTO.getUserRole().contains("Pharmacist")) {
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
                recipe.setRecipeDate(resultset.getDate("recipe_date"));
                while (resultset.next()) {
                    recipe.addIngredient(resultset.getString("ingredient_name"));

                }
                return recipe;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null; // få lige fikset det her
        } else {
            System.out.println("Only pharmacists have permission to see recipies");
        } return null; // få lige fikset det her
    }



    public void deleteRecipe(int recipeID, UserDTO userDTO){
        if(userDTO.getUserRole().contains("Pharmacist"))
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

      } else{
            System.out.println("Only pharmacists have permission to delete recepies.");
        }
    }

    public void updateRecipe(RecipeDTO recipe, UserDTO userDTO) {
        if(userDTO.getUserRole().contains("Pharmacist")) {


            try (Connection conn = createConnection()) {
                conn.setAutoCommit(false);

                PreparedStatement oldDatestmt = conn.prepareStatement("INSERT INTO old_recipe SELECT * FROM" +
                        " recipe where recipe_id = ? ");
                oldDatestmt.setInt(1, recipe.getRecipeID());

//Begynder på den reelle update medtode
                PreparedStatement updateRecipe = conn.prepareStatement("UPDATE recipe SET date = ? " +
                        " WHERE recipe_id = ?");

                updateRecipe.setDate(1, recipe.getRecipeDate());
                updateRecipe.setInt(2, recipe.getRecipeID());
                updateRecipe.executeUpdate();

                for (int i = 0; i < recipe.getIngredients().size(); i++) {
                    PreparedStatement updateIngredients = conn.prepareStatement("UPDATE recipe_ingredients SET " +
                            " ingredients_id = ? WHERE recipe_id = ?");
                    updateIngredients.setString(1, recipe.getIngredients().get(i));
                    updateIngredients.setInt(2, recipe.getRecipeID());
                    updateIngredients.executeUpdate();
                }
                conn.commit();
            } catch (SQLException e) {
                System.out.println("Couldn't update recipe" + e.getMessage());
            }
        } else{
            System.out.println("Only pharmacists have permission to update recipies");
        }
    }
// udskriver hvert item og antal for hvert item
    public List<CommodityDTO> getCommodityStatus(UserDTO userDTO) throws SQLException {
        if(userDTO.getUserRole().contains("Productleader")) {
            try (Connection c = createConnection()) {
                Statement statement = c.createStatement();
                ResultSet resultset = statement.executeQuery("SELECT item, amount FROM commodity");

                List<CommodityDTO> commodities = new ArrayList<>();
                while (resultset.next()) {
                    CommodityDTO commodity = new CommodityDTO();
                    commodity.setCommodityName(resultset.getString("item"));
                    commodity.setAmount(resultset.getInt("amount"));
                    commodities.add(commodity);
                }
                return commodities;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }else {
            System.out.println("Only productleaders have permission to see remaining commodities");
            return null;
        }
    }
// Skal udskrive hver commoditybatchID med hvilken (varenavn) og antal tilbage i batchen. hvordan?
    // vi kan joine på commodityID og udskrive det sådan.
    public List<CommoditybatchDTO> getCommodityBatchStatus(UserDTO userDTO) throws SQLException {
        if(userDTO.getUserRole().contains("Productleader")){
        try (Connection c = createConnection()) {
            Statement statement = c.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT commoditybatch_id, " +
                                                             " batch_amount FROM commodity_batch INNER JOIN" +
                                                 " commodity_id on commodity.commodity_id = commodity_batch.commodity_id");

            List<CommoditybatchDTO> commoditybatches = new ArrayList<>();
            while (resultset.next()) {
                CommoditybatchDTO commoditybatch = new CommoditybatchDTO();
                commoditybatch.setCommodityBatchID(resultset.getInt("commoditybatch_id"));
                commoditybatch.setAmount(resultset.getInt("batch_amount"));
                commoditybatches.add(commoditybatch);
            }
            return commoditybatches;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        } else{
                System.out.println("Only productleaders have permission to see commodity batch status");
                return null;
        }
    }

   
    public void createProductbatch(ProductbatchDTO productbatchDTO, UserDTO userDTO) throws SQLException {
        if(userDTO.getUserRole().contains("Productleader")) {

            try (Connection connection = createConnection()) {
                connection.setAutoCommit(false);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO productbatch (product_id) VALUES(?);");

                preparedStatement.setInt(1, productbatchDTO.getProductID());

                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Only productleaders have permission to create product batches");
        }
    }

    public void createCommoditybatch(CommoditybatchDTO commoditybatchDTO, CommodityDTO commodityDTO, UserDTO userDTO){
        if(userDTO.getUserRole().contains("Productleader")) {

            try (Connection connection = createConnection()) {
                connection.setAutoCommit(false);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO commoditybatch(commodity_id, batchAmount) VALUES (?,?);");

                preparedStatement.setInt(1, commodityDTO.getCommodityID());
                preparedStatement.setInt(2, commoditybatchDTO.getBatchAmount());
                preparedStatement.executeUpdate();

                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Only productleader have permission to create commodity batches.");
        }
    }

    public void updateCommodityBatch(CommoditybatchDTO commoditybatchDTO, UserDTO userDTO) throws SQLException{
        if(userDTO.getUserRole().contains("Productleader")) {

            try (Connection connection = createConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE commodity_batch SET " +
                        " batch_amount = ?");
                preparedStatement.setInt(1, commoditybatchDTO.getBatchAmount());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Only productleaders have permission to update commodity batches.");
        }
    }












    public void createUser(UserDTO userDTO, RoleDTO roleDTO){

        try (Connection connection = createConnection()){
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO user(role) VALUES (?);");

            preparedStatement.setString(1,roleDTO.getRole());
            preparedStatement.executeUpdate();
            connection.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void updateUser(UserDTO userDTO, RoleDTO roleDTO){

        try(Connection connection = createConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET " +
                    " role= ?");
            preparedStatement.setInt(1, ());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

