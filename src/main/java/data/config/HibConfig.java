package data.config;

import data.model.User;
import logic.ctrl.Error.ErrorMessages;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.rmi.NoSuchObjectException;

/**
 * Created By Bartłomiej Woś
 */
public final class HibConfig {


    private static final int MAXIMAL_PRIVILEGES = 1;
    private static final int MEDIUM_PRIVILEGES = 2;
    private static final int MINIMAL_PRIVILEGES = 3;

    private static String[] resourcesFactory;

    private static String connectionURL = "hibernate.connection.url";
    private static String driverClass = "hibernate.connection.driver_class";
    private static String dialect = "hibernate.dialect";
    private static String showSQL = "hibernate.show_sql";
    private static String userName = "data.config.connection.username";
    private static String userPassword = "hibernate.connection.password";


    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    public HibConfig(){
        setConfiguration("/data/hibernate.cfg.xml");
    }

    private static void setConfiguration(String url){
        configuration = new Configuration();
        configuration.configure(url);
    }

    public static void configureHibernateByUser(User user){
        DatabaseLogin databaseLogin = ValidationParser.getUserDataForAccessLevel(user.getAccessLevel());
        if(databaseLogin != null) {
            configure(databaseLogin.getUsername(),databaseLogin.getPassword());
        }
    }
    private static void configureHibernateByAccessLevel(int accessLevel){
        DatabaseLogin databaseLogin = ValidationParser.getUserDataForAccessLevel(accessLevel);
        if(databaseLogin != null){
            configure(databaseLogin.getUsername(),databaseLogin.getPassword());
        }
    }

    private static void configure(String username, String password){
        configuration.setProperty(userName, username);
        configuration.setProperty(userPassword, password);
    }


    public static void logoutUserConfiguration(){
        configureHibernateByAccessLevel(MAXIMAL_PRIVILEGES);
    }

    public static Configuration getConfiguration() {
        if(configuration == null){
            configuration = new Configuration();
        }
        return configuration;
    }


    public static SessionFactory getFactory(){
        if(sessionFactory == null){
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static boolean isTransictionUp(Session session){
        if(session != null) {
            return session.getTransaction().isActive();
        }
        return false;
    }

    public static Transaction getTransiction(Session session){
        if(session != null){
            return session.getTransaction();
        }
        session = getOpenSession();
        //ErrorMessages.setAndThrowMessage("Session is down!");
        return session.getTransaction();
    }

    public static Session getOpenSession(){
        return getFactory().openSession();
    }

}
