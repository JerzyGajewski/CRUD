package pl.jerzyGajewski.Dao;

import pl.jerzyGajewski.Entity.User;
import pl.jerzyGajewski.services.DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao {
    public static void createUsersTable() {
        String query = "CREATE TABLE IF NOT EXISTS users (\n" +
                "    id INT AUTO_INCREMENT,\n" +
                "    userName VARCHAR(50) NOT NULL UNIQUE,\n" +
                "    email VARCHAR(50) NOT NULL UNIQUE,\n" +
                "    password VARCHAR(50) NOT NULL,\n" +
                "    PRIMARY KEY (id)\n" +
                ")";
        DBService.createTable(query);
    }

    public static void addUserToTable(User user) {
        String query = "INSERT INTO users (userName, email, password) VALUES (?,?,?)";
        DBService.loadDriver();
        try (Connection conn = DBService.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editUserData(User user) {
        if(user.getId()==0){
            System.out.println("brak");
            return;
        }
       String query = "UPDATE users SET userName = ?, email = ?, password = ? WHERE id = ?";
        DBService.loadDriver();
        try (Connection conn = DBService.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<User> showAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "Select * from users;";
        List<Map<String, String>> data = DBService.getData(query);

        if (data != null) {
            for (Map<String, String> row : data) {
                User user = createUserFromData(row);
                users.add(user);
            }
        }
        return users;
    }

    public static User showUser(int id) {
        String query = "select userName, id, email, password from users where id =?";
        List<Map<String, String>> data = DBService.getData(query, String.valueOf(id));
        if (data != null) {
            for (Map<String, String> row : data) {
                User user = createUserFromData(row);
                    return user;
            }
        }
        return null;
    }

    private static User createUserFromData(Map<String, String> data) {
        String id = data.get("id");
        String userName = data.get("userName");
        String email = data.get("email");
        String password = data.get("password");
        User user = new User(
                Integer.parseInt(id), userName, email, password);
        return user;
    }

}

