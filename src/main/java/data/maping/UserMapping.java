package data.maping;

import data.model.Worker;
import logic.DBApp;
import logic.ctrl.Error.ErrorMessages;
import logic.seciourity.Validation;
import data.model.User;
import data.config.HibConfig;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

/**
 * Created By Bartłomiej Woś
 */
public class UserMapping {

    public static void addUser(String username, String password, String personalID, int acessLevel){
        String encryptedPassword = Validation.encryptPassword(password);

        Worker worker = Selection.getWorkerByID(personalID);
        if(worker == null){
            ErrorMessages.setAndThrowMessage("Worker does not exists!");
            return;
        }

        User user = Selection.getUserByLogin(username);
        if(user != null){
            ErrorMessages.setAndThrowMessage("User already Exists!");
            return;
        }

        try(Session session = HibConfig.getOpenSession()) {
            Transaction tn = session.beginTransaction();
            user = new User();
            user.setUserName(username);
            user.setUserPassword(encryptedPassword);
            user.setWorker(worker);
            user.setAccessLevel(acessLevel);

            //System.out.println("\n\n");
            session.save(user);
            tn.commit();
        }catch (HibernateException e){
            System.out.println("ADD USER: Couldn't Execute Statement");
        }
    }

    public static void addWorker(String name, String surname, String position,Date birthDate,String personalID ){
        Worker worker = Selection.getWorkerByID(personalID);
        if(worker == null) {
            try (Session session = HibConfig.getOpenSession()) {
                Transaction tn = session.beginTransaction();
                worker = new Worker();

                worker.setBirthDate(birthDate);
                worker.setName(name);
                worker.setPosition(position);
                worker.setSurname(surname);
                worker.setPersonalID(personalID);

                session.save(worker);
                tn.commit();
            }catch (HibernateException p) {
                ErrorMessages.setAndThrowMessage("Worker: Couldn't Execute Statement!");
            }
        }else{
            ErrorMessages.setAndThrowMessage("Worker Already Exists!");
        }
    }

    public static void removeUser(String username){
        User user = Selection.getUserByLogin(username);
        if(user != null){
            try(Session session = HibConfig.getOpenSession()){
                Transaction tn = session.beginTransaction();
                session.delete(user);
                tn.commit();
            }catch (HibernateException p){
                ErrorMessages.setErrorMessage("Couldn't Remove User!");
            }
        }else{
            ErrorMessages.setAndThrowMessage("User does not exist in database!");
        }
    }


    public static void removeWorker(String workerPersonalID){
        Worker worker = Selection.getWorkerByID(workerPersonalID);
        if(worker != null){
            try(Session session = HibConfig.getOpenSession()){
                Transaction tn = session.beginTransaction();
                session.delete(worker);
                tn.commit();
            }catch (HibernateException e){
                ErrorMessages.setAndThrowMessage("Unable to remove user! Please ensure first, " +
                        "that there is no reference to " +
                        " user account from this worker! If that does not help, check for references in" +
                        "receipt table or use deleteAllDataWorker()!");
            }
        }else{
            ErrorMessages.setAndThrowMessage("Worker does not exist in database!");
        }

    }

    public static void deleteAllDataUser(){

    }

    public static void updateUserPassword(String oldPassword, String newPassword){

    }
}
