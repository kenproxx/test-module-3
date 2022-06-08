import java.sql.*;

public class DAO {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo2006?useSSL=false", "root", "123456");
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return connection;
    }

    public void showAll() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getInt("userId") + " " + rs.getInt("postsId") + " " + rs.getString("commentDate") + " " + rs.getInt("status") + " " + rs.getString("content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
