package data.config;

import javafx.scene.Parent;
import logic.Database;
import logic.ctrl.Error.ErrorMessages;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created By Bartłomiej Woś
 */
public class ValidationParser {

    private static final String pathToConfig = "/database/profiles.txt";

    public static DatabaseLogin getUserDataForAccessLevel(int acessLevel){
        Path path = Paths.get(pathToConfig);
        boolean found = false;
        DatabaseLogin databaseLogin = new DatabaseLogin();
        File file = path.toFile();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String nextline;
            while ((nextline = bufferedReader.readLine()) != null){
                String tokens[] = nextline.split(" ");
                int level = Integer.parseInt(tokens[1]);
                String password,username;
                if(level == acessLevel){
                    username = tokens[3];
                    password = tokens[5];

                    if(username != null && password != null){
                        databaseLogin.setUsername(username);
                        databaseLogin.setPassword(password);
                        found = true;
                        break;
                    }
                }
            }
            if(!found){
                ErrorMessages.setAndThrowMessage("Access Level does not exist!");
            }
        } catch (FileNotFoundException e) {
            ErrorMessages.setAndThrowMessage("Unable to read configuration file!");
        } catch (IOException e){
            ErrorMessages.setAndThrowMessage("Error occurred in reading configuration file!");
        }
        return databaseLogin;
    }
}
