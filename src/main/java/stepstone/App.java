package stepstone;

import stepstone.commandPattern.Action;
import stepstone.commandPattern.UserCommand;
import stepstone.factoryPattern.AbstractFactoryPattern;
import stepstone.factoryPattern.Factory;

import java.io.IOException;

/**
 * Main class for the application
 */
public class App
{
    /**
     * Main of the application
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        App app = new App();
        app.runCMD(args);

    }

    /**
     * get Author first and last name and prepare the command to execute
     * @param args
     * @throws IOException
     */
    private void runCMD(String[] args) throws IOException{

        Action action = new Action();
        Factory factory = new Factory();
        AbstractFactoryPattern abstractFactoryPattern = factory.getInstance(args);

        if(args.length==2) {
            action.executeCommand(new UserCommand(abstractFactoryPattern));
        }else{
            helper();
        }
    }

    /**
     * Helper : help the user to know better how to use the Application in case of error.
     */
    private void helper(){
        System.out.println("");
        System.out.println("This Java application enables its users to search authors by first name and last name. " );
        System.out.println("Search parameters could be provided as program arguments.");
        System.out.println("Usage: Parameters : <param1> <param2>...");
        System.out.println("");
        System.out.println(" param1 - Author's first name");
        System.out.println(" param2 - Author's last name");
        System.out.println("");
        System.exit(1);
    }
}
