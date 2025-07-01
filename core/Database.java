package core;

import util.EnvReader;
import java.sql.*;

public class Database {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://" +
                    EnvReader.get("DB_HOST") + ":" +
                    EnvReader.get("DB_PORT") + "/" +
                    EnvReader.get("DB_NAME");
                String user = EnvReader.get("DB_USER");
                String password = EnvReader.get("DB_PASSWORD");

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("✅ DB connected successfully.");
            } catch (SQLException e) {
                System.out.println("❌ DB connection failed: " + e.getMessage());
            }
        }
        return connection;
    }
}
