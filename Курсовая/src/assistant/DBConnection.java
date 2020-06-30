package assistant;

import java.sql.*;

public class DBConnection {
    private static final String URL = "src/sqlite/D&D.db";
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + URL);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
