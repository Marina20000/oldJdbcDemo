import java.sql.*;

/**
 * Created by User on 04.02.2017.
 */
public class SimpleDBC {
    public void dbConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/menagerie";
            String login = "root@localhost";
            String password = "Matematika2000";
            Connection connection = DriverManager.getConnection(url,login, password);
            try {
                Statement statment = connection.createStatement();
                ResultSet resultSet = statment.executeQuery("SELECT * FROM pet");
                while (resultSet.next()) {
                    String str = resultSet.getString("name") + ":" + resultSet.getString("owner");
                    System.out.println("name: " + str);
                }
                resultSet.close();
                statment.close();
            }
            finally {
                connection.close();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("no connection");
            e.printStackTrace();
        }
    }

}
