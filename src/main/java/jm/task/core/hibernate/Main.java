package jm.task.core.hibernate;

import jm.task.core.hibernate.service.UserService;
import jm.task.core.hibernate.service.UserServiceImpl;

import java.sql.SQLException;


public class Main {

    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) throws SQLException {

        userService.createUsersTable();
        userService.saveUser("Иван", "Иванов", (byte) 50);
        userService.saveUser("Петр", "Петров", (byte) 60);
        userService.saveUser("Федор", "Федоров", (byte) 40);
        userService.removeUserById(3);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
