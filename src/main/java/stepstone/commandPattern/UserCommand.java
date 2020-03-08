package stepstone.commandPattern;

import stepstone.factoryPattern.AbstractFactoryPattern;

import java.io.IOException;

public class UserCommand implements Command {
    private AbstractFactoryPattern cmd;


    public UserCommand(AbstractFactoryPattern cmd){

        this.cmd =  cmd;
    }

    public void execute() throws IOException {

        cmd.runTheCommand();

    }
}
