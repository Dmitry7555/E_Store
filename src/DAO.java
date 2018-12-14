import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/e_store", "root", "root");
    }

    public static List<Products> getProducts() throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * FROM products");
             ResultSet resultSet = preparedStatement.executeQuery("SELECT  * FROM products");) {
            ArrayList<Products> products = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int cost = resultSet.getInt(3);
                products.add(new Products(id, name, cost));
            }
            return products;
        }
    }

    public static void AddProducts(String name, int cost) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (name, cost) VALUES ( ?,? )");
        ) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, cost);
            preparedStatement.executeUpdate();
        }

    }

    public static void DeleteProducts(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE  FROM products WHERE id=?");
        ) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

    }
}
