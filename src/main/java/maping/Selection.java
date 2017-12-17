package maping;

import beans.LoginUser;
import ctrl.LoginController.LoginController;
import hibernate.HibConfig;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sun.rmi.runtime.Log;

import javax.persistence.NoResultException;
import java.util.Iterator;
import java.util.List;

/**
 * Created By Bartłomiej Woś
 */
public class Selection {

    public static List listUsers(){
        String query = "FROM LoginUsers";
        Session session = HibConfig.getOpenSession();
        Transaction tx;

        tx = session.beginTransaction();
        List users = session.createQuery("FROM LoginUser").list();
        for (Iterator iterator = users.iterator(); iterator.hasNext();){
            LoginUser employee = (LoginUser) iterator.next();
            System.out.print("First Name: " + employee.getId());
            System.out.print("  Last Name: " + employee.getUserName());
            System.out.println("  Salary: " + employee.getUserPassword());
        }
        tx.commit();
        session.close();
        return users;
    }

    public static LoginUser getUserByLogin(String login) throws NoResultException{
        LoginUser loginUser = null;
        String queryString = "from LoginUser where userName = :userCall";
        try (Session session = HibConfig.getOpenSession()) {
            try {
                Query query = session.createQuery(queryString).setParameter("userCall", login);
                loginUser = (LoginUser) query.getSingleResult();
            }catch (NoResultException e){
                loginUser = null;
            }
        } catch (HibernateException e) {
            System.out.println("User does not exist!");
        }
        return loginUser;
    }
}
