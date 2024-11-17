package jm.task.core.hibernate.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

import jm.task.core.hibernate.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class Util {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "Aa01012015";


    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("Соединение с БД установлено");

            }
        } catch (SQLException s) {
            System.err.println("Не удалось загрузить класс драйвера БД");
        }
        return con;
    }

    private static SessionFactory sessionFactory = null;
    static  {
        try {
            Properties settings = new Properties();
            settings.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
            settings.setProperty("hibernate.connection.username", "root");
            settings.setProperty("hibernate.connection.password", "Aa01012015");
            settings.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
            settings.setProperty("hibernate.hbm2ddl.auto", "create");

            sessionFactory = new org.hibernate.cfg.Configuration()
                    .addProperties(settings)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Session getSession() throws HibernateException{
        return sessionFactory.openSession();
    }

    public static void close() throws HibernateException{
        getSession().close();
    }

}







