package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created By Bartłomiej Woś
 */
public final class HibConfig {

    static Configuration configuration;
    static SessionFactory sessionFactory;

    public HibConfig(){
        setConfiguration("/orm/hibernate.cfg.xml");
    }

    public static void setConfiguration(String url){
        configuration = new Configuration();
        configuration.configure(url);
    }

    public static void setAcessLevel(int acessLevel){
        String[] accessLogs = acessLevel(acessLevel);
        configuration.setProperty("hibernate.connection.username",accessLogs[0]);
        configuration.setProperty("hibernate.connection.username",accessLogs[1]);
    }

    public static Configuration getConf() {
        return configuration;
    }

    public static SessionFactory getFactory(){
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public static Session getOpenSession(){
        Session session = getFactory().openSession();
        return session;
    }

    public static String[] acessLevel(int accessLevel){
        String[] strings = new String[2];
        switch (accessLevel){
            case 1:
                strings[0] = "sherlock";
                strings[1] = "1q2w3e4r5t6y";
                break;
            case 2:
                break;
            case 3:
                break;
            default:

                break;
        }
        return strings;

    }


}
