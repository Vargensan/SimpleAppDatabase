package logic.seciourity;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Created By Bartłomiej Woś
 */
public class Validation {


    public static void makeRequestDBpassword(){

    }

    public static boolean isPasswordCorrect(String password,String databasePassword){
        return BCrypt.checkpw(password,databasePassword);
    }

    public static void decryptPassword(){

    }

    public static String encryptPassword(String password){
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password,salt);
    }
}
