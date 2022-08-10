package ru.warpreaktor;

import java.sql.*;

public class CrudService {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //TODO сделать универсальный метод в который можно передавать мапу с именованиями и типами полей таблицы.
    private static void createTable(String tableName) throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "+ tableName + " (\n" +
                "        id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "        name  TEXT" +
                "    );");
    }

    private static void createName(String name) throws SQLException {
        stmt.executeUpdate("INSERT INTO names (name) VALUES (" + name + ");");
    }

    private static void read() throws SQLException {
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM students;")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getInt(3));
            }
        }
    }

    private static void update() throws SQLException {
        stmt.executeUpdate("UPDATE students SET score = 60 WHERE name = 'Самуил';");
    }

    private static void delete() throws SQLException {
        stmt.executeUpdate("DELETE FROM students WHERE score < 70 ;");
    }

}
