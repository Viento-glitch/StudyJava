package StudyJavaRush.Shop.Commands;

import java.io.IOException;
import java.util.List;

public interface CommandInterface {

    List<String> getNames();

    void execute() throws IOException;
}
