package pl.jerzyGajewski.services;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/CRUD?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    public static void loadDriver() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        return conn;
    }


    public static void createTable(String... queries) {
        for (String query : queries) {
            try (Connection conn = getConnection();
                 PreparedStatement statement = conn.prepareStatement(query)) {
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Map<String, String>> getData(String query, String... params) {
        DBService.loadDriver();
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            //patrzymy jaką liczbę parametrów podaliśmy i wyciągnięte przypisujemy do numeru ? w zapytaniu
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            //wynik zapytania przypisujemy do zmiennej ResultSet
            ResultSet rs = statement.executeQuery();
            List<String> columnKey = getColumnKeyValues(rs);

            List<Map<String, String>> data = new ArrayList<>();

            while (rs.next()) {
                Map<String, String> row = new HashMap<>();
                //każdemu kluczowi z listy columnKey przypisujemy wartość jaką trzyma
                for (String key : columnKey) {
                    row.put(key, rs.getString(key));
                }
                data.add(row);
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String> getColumnKeyValues(ResultSet resultSet) throws SQLException {
        //w wyniku zapytania pobiera numery kolumn z mapy
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();

        List<String> columnValues = new ArrayList<>();
        // dla każdego numeru kolumny sprawdza jaka jest wartość, zamienia numer na wartość i wstaeia do listy
        for (int i = 0; i <= columnCount; i++) {
            String value = rsmd.getColumnName(i);
            columnValues.add(value);
        }
        return columnValues;
    }
}