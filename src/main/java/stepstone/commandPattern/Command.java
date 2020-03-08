package stepstone.commandPattern;

import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}
