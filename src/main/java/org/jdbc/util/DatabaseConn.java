package org.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {
    private static String url = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "caca";
    private static Connection conn;

    public static Connection getInstance() throws SQLException {
        if(conn == null) conn = DriverManager.getConnection(url, username, password);

        return conn;
    }
}
