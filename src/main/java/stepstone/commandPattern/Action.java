package stepstone.commandPattern;

import java.io.IOException;


public class Action {
    public void executeCommand(Command command) throws IOException {
        command.execute();
    }
}
