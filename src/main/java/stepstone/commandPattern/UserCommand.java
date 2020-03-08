package stepstone.commandPattern;

import stepstone.factoryPattern.AbstractFactoryPattern;

import java.io.IOException;

/**
 * Class UserCommand : Formulate the user command
 */
public class UserCommand implements Command {
    /**
     * User command.
     */
    private AbstractFactoryPattern cmd;

    /**
     * Constructor
     * @param cmd
     */
    public UserCommand(AbstractFactoryPattern cmd){

        this.cmd =  cmd;
    }

    /**
     * execute the command
     * @throws IOException
     */
    public void execute() throws IOException {

        cmd.runTheCommand();

    }
}
