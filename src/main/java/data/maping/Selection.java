package data.maping;

import data.model.Receipt;
import data.model.User;
import data.config.HibConfig;
import data.model.Worker;
import logic.DBApp;
import logic.ctrl.Error.ErrorMessages;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.Iterator;
import java.util.List;

/**
 * Created By Bartłomiej Woś
 */
public class Selection {

    public static List listUsers(){
        Session session = HibConfig.getOpenSession();
        Transaction tx;

        tx = session.beginTransaction();
        List users = session.createQuery("FROM User ").list();
        for (Iterator iterator = users.iterator(); iterator.hasNext();){
            User employee = (User) iterator.next();
            System.out.print("id: " + employee.getId());
            System.out.print("  login: " + employee.getUserName());
            System.out.println("  password: " + employee.getUserPassword());
        }
        tx.commit();
        session.close();
        return users;
    }

    public static User getUserByLogin(String login) throws NoResultException{
        User user = null;
        try (Session session = HibConfig.getOpenSession()) {
            try {
                Query query = session.createQuery("from User where userName = :username");
                query.setParameter("username",login);
                user = (User) query.uniqueResult();
            }catch (NoResultException e){
                user = null;
            }
        } catch (HibernateException e) {
            ErrorMessages.setAndThrowMessage("User Does Not Exists!");
        }
        return user;
    }

    public static Worker getWorkerByID(String workerID) throws NoResultException{
        Worker worker = null;
        try(Session session = HibConfig.getOpenSession()){
            try{
                worker = (Worker) session.get(Worker.class,workerID);
                Hibernate.initialize(worker);
            }catch (NoResultException e){
                ErrorMessages.setAndThrowMessage("Worker is null!");
                worker = null;
            }
        }catch (HibernateException e){
            ErrorMessages.setAndThrowMessage("User does not exists!");
        } catch (NullPointerException e){
            e.printStackTrace();
            ErrorMessages.setAndThrowMessage("Unable to resolve query!");
        }
        return worker;
    }

    public static Receipt getReceiptByID(int ID){
        Receipt receipt = null;
        try(Session session = HibConfig.getOpenSession()){
            try{
               receipt = session.get(Receipt.class,ID);
               Hibernate.initialize(receipt);
            }catch (HibernateException e){
                ErrorMessages.setAndThrowMessage("Receipt is null!");
                receipt = null;
            }
        }catch (HibernateException e){
            ErrorMessages.setAndThrowMessage("Receipt does not exist!");
        }catch (NullPointerException e){
            e.printStackTrace();
            ErrorMessages.setAndThrowMessage("Unable to resolve query!");
        }
        return receipt;
    }


    public static void getMagazineProductByID(){

    }

    public static void getCashRegisterByID(){

    }

}
