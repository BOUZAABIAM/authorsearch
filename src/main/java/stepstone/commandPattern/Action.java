package stepstone.commandPattern;

import java.io.IOException;

/**
 * Action class
 */
public class Action {
    /**
     * Execute the user command
     * @param command
     * @throws IOException
     */
    public void executeCommand(Command command) throws IOException {
        command.execute();
    }
}
