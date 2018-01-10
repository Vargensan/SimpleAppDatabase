package logic;

import data.config.HibConfig;
import data.maping.Selection;
import data.maping.UserMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created By Bartłomiej Woś
 */
public class Database {

    private HibConfig hibConfig;

    public Database(){
        initalizeHibernateConfig();
    }


    public void initalizeHibernateConfig(){
        hibConfig = new HibConfig();
    }

    public void test(){
        DateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date  = dateTimeFormatter.parse("1996-04-24");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserMapping.addWorker("Bartek","Wos","manager",date,"96042404311");
        UserMapping.addUser("Vargensan","1q2w3e4r5t6y","96042404311",AcessLevel.MAXIMAL_PRIVILAGES);
        Selection.listUsers();
    }

    public void addUser(String username, String password, String personalNumber,int acessLevel){
        UserMapping.addUser(username,password,personalNumber,acessLevel);
    }


    public HibConfig getHibConfig() { return hibConfig; }

    public void setHibConfig(HibConfig hibConfig) { this.hibConfig = hibConfig; }
}
