package logic;

import data.config.HibConfig;
import data.maping.UserMapping;

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

    public void addUser(String username, String password){
        UserMapping.addUser(username,password);
    }


    public HibConfig getHibConfig() { return hibConfig; }

    public void setHibConfig(HibConfig hibConfig) { this.hibConfig = hibConfig; }
}
