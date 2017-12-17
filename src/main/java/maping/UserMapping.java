package maping;

import Seciourity.Validation;
import beans.LoginUser;
import hibernate.HibConfig;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created By Bartłomiej Woś
 */
public class UserMapping {

    public static void addUser(String username, String password){
        String encryptedPassword = Validation.encryptPassword(password);
        Session session = HibConfig.getOpenSession();
        Transaction tn = null;
        try {
            tn = session.beginTransaction();
            LoginUser loginUser = new LoginUser(username, encryptedPassword);
            session.save(loginUser);
            tn.commit();
        }catch (HibernateException e){
            System.out.println("Couldn't Execute Statement");
        }finally {
            session.close();
        }
    }

    public static void removeUser(String username){

    }

    public static void removeUser(int userId){

    }

    public static void updateUserPassword(String oldPassword, String newPassword){

    }
}
