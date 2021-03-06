package Project.Main;

import Project.DTO.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Database {

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s180911", "s180911", "QekXA8EbroGRPIN1MOpRI");

    }


    public void createRecipe(RecipeDTO recipeDTO, UserDTO userDTO) {

        if (userDTO.getUserRole().contains("Pharmacist")) {
            try (Connection connection = createConnection()) {


                PreparedStatement insertRecipe = connection.prepareStatement(
                        "INSERT INTO recipe ( product_id, recipe_date) VALUES(?,?);");
                insertRecipe.setInt(1, recipeDTO.getProductID());
                insertRecipe.setString(2, recipeDTO.getRecipeDate());
                insertRecipe.executeUpdate();

                for (int i = 0; i < recipeDTO.getIngredients().size(); i++) {
                PreparedStatement insertIngredients = connection.prepareStatement("INSERT INTO recipe_ingredients" +
                                                                                      " VALUES (?,?)");
                insertIngredients.setInt(1,recipeDTO.getRecipeID());
                insertIngredients.setString(2,recipeDTO.getIngredients().get(i));
                insertIngredients.executeUpdate();
                }

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
                recipe.setRecipeDate(resultset.getString("recipe_date"));
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

              PreparedStatement delete2 = conn.prepareStatement("DELETE FROM recipe_ingredients" +
                      " WHERE recipe_id = ?");
              delete2.setInt(1, recipeID);
              delete2.executeUpdate();

            PreparedStatement delete = conn.prepareStatement("DELETE FROM recipe " +
                                                                 " WHERE recipe_id = ?");
            delete.setInt(1, recipeID);
            delete.executeUpdate();




            conn.commit();
        } catch (SQLException e) {
            System.out.println("couldn't delete recipe" + e.getMessage());

      } else{
            System.out.println("Only pharmacists have permission to delete recepies.");
        }
    }

    public void updateRecipe(RecipeDTO recipe, UserDTO userDTO) {
        if (userDTO.getUserRole().contains("Pharmacist")) {


            try (Connection conn = createConnection()) {
                conn.setAutoCommit(false);

                PreparedStatement oldstmt = conn.prepareStatement("INSERT INTO old_recipe (recipe_id, old_date) SELECT recipe_id, recipe_date FROM" +
                        " recipe where recipe_id = ? ");
                oldstmt.setInt(1, recipe.getRecipeID());

                oldstmt.executeUpdate();

//Begynder på den reelle update medtode
                PreparedStatement updateRecipe = conn.prepareStatement("UPDATE recipe SET recipe_date = ? " +
                        " WHERE recipe_id = ?");

                updateRecipe.setString(1, recipe.getRecipeDate());
                updateRecipe.setInt(2, recipe.getRecipeID());
                updateRecipe.executeUpdate();

                PreparedStatement delete = conn.prepareStatement("DELETE FROM recipe_ingredients WHERE recipe_id = ?");
                delete.setInt(1, recipe.getRecipeID());
                delete.executeUpdate();

                conn.commit();

                for (int i = 0; i < recipe.getIngredients().size(); i++) {
                    PreparedStatement insertNewIngredients = conn.prepareStatement("INSERT INTO recipe_ingredients" +
                            " VALUES (?,?)");
                    insertNewIngredients.setInt(1, recipe.getRecipeID());
                    insertNewIngredients.setString(2, recipe.getIngredients().get(i));
                    insertNewIngredients.executeUpdate();
                }
                conn.commit();
            } catch (SQLException e) {
                System.out.println("Couldn't update recipe" + e.getMessage());
                e.printStackTrace();
            }
        } else{
            System.out.println("Only pharmacists have permission to update recipies");
        }
    }
// udskriver hvert item og antal for hvert item
    public List<CommodityDTO> getCommodityStatus(UserDTO userDTO) {
        if(userDTO.getUserRole().contains("Productleader")) {
            try (Connection c = createConnection()) {
                Statement statement = c.createStatement();
                ResultSet resultset = statement.executeQuery("SELECT commodity_name, commodity_amount FROM commodity");

                List<CommodityDTO> commodities = new ArrayList<>();
                while (resultset.next()) {
                    CommodityDTO commodity = new CommodityDTO();
                    commodity.setCommodityName(resultset.getString("commodity_name"));
                    commodity.setAmount(resultset.getInt("commodity_amount"));
                    commodities.add(commodity);

                    System.out.println("Item = " + resultset.getString(1));
                    System.out.println("Amount = " + resultset.getInt(2));
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
public List<CommoditybatchDTO> getCommodityBatchStatus(UserDTO userDTO) {
    if (userDTO.getUserRole().contains("Productleader")) {
        try (Connection c = createConnection()) {
            Statement statement = c.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT commoditybatch_id, " +
                    " batchAmount FROM commoditybatch INNER JOIN" +
                    " commodity on commodity.commodity_id = commoditybatch.commodity_id");

            List<CommoditybatchDTO> commoditybatches = new ArrayList<>();
            while (resultset.next()) {
                CommoditybatchDTO commoditybatch = new CommoditybatchDTO();
                commoditybatch.setCommodityBatchID(resultset.getInt("commoditybatch_id"));
                commoditybatch.setAmount(resultset.getInt("batchAmount"));
                commoditybatches.add(commoditybatch);

                System.out.println("|commoditybatch ID = " + resultset.getInt(1));;
                System.out.println("|commodityAmount = " + resultset.getInt(2));

            }
            return commoditybatches;
        } catch (SQLException e) {
            e.printStackTrace();
        } return null;
    } else {
        System.out.println("Only productleaders have permission to see commodity batch status");

    } return null;
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

    public void updateCommodityBatch(CommoditybatchDTO commoditybatchDTO, UserDTO userDTO){
        if(userDTO.getUserRole().contains("Productleader")) {

            try (Connection connection = createConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE commoditybatch SET " +
                        " batchAmount = ? WHERE commoditybatch_id = ?" );
                preparedStatement.setInt(1, commoditybatchDTO.getBatchAmount());
                preparedStatement.setInt(2,commoditybatchDTO.getCommodityBatchID());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Only productleaders have permission to update commodity batches.");
        }
    }



    public void createUser(UserDTO userDTO) {

        try (Connection connection = createConnection()) {
            connection.setAutoCommit(false);


            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO user (user_name) VALUES (?);",Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, userDTO.getUserName());
            preparedStatement.executeUpdate();

            ResultSet userkey = preparedStatement.getGeneratedKeys();
            int userID = 0;
            if (userkey.next()) {
                userID = userkey.getInt(1);
                userDTO.setUserID(userID);

            }
            for (int i = 0; i < userDTO.getUserRole().size(); i++) {
                PreparedStatement insertRole = connection.prepareStatement("INSERT INTO user_role" +
                        " VALUES (?,?)");
                insertRole.setInt(1, userDTO.getUserID());
                insertRole.setString(2, userDTO.getUserRole().get(i));
                insertRole.executeUpdate();
            }
            connection.commit();

            }catch(SQLException e){
                e.printStackTrace();
            }

        }

    public void updateUser(UserDTO userDTO){

        try(Connection connection = createConnection()){

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET " +
                    " user_name = ? WHERE user_id =" + userDTO.getUserID());
            preparedStatement.setString(1,userDTO.getUserName());
            preparedStatement.executeUpdate();


            for(int i = 0; i < userDTO.getUserRole().size(); i++){
                PreparedStatement insertRole = connection.prepareStatement("UPDATE user_role SET" +
                        " role_name = ? WHERE user_id="  + userDTO.getUserID());
                insertRole.setString(1, userDTO.getUserRole().get(i));
                insertRole.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteUser (int user_id) {
        try (Connection conn = createConnection()) {
            conn.setAutoCommit(false);


            PreparedStatement delete = conn.prepareStatement("DELETE FROM user_role WHERE user_id = ?");
            delete.setInt(1,user_id);
            delete.executeUpdate();

            delete = conn.prepareStatement("DELETE FROM user WHERE user.user_id = ?");
            delete.setInt(1,user_id);
            delete.executeUpdate();



            conn.commit();
        } catch (SQLException e) {
            System.out.println("couldn't delete user" + e.getMessage());
        }
    }


}

