package StudyJavaRush.Store.command;

import java.util.List;

public interface CommandInterface {

    List<String> getNames();

    void execute();
}
