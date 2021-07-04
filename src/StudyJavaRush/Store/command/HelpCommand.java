package StudyJavaRush.Store.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelpCommand implements CommandInterface {

    private ArrayList<CommandInterface> commandInterfaceCollection;

    public HelpCommand(ArrayList<CommandInterface> commandInterfaceCollection) {
        this.commandInterfaceCollection = commandInterfaceCollection;
    }

    @Override
    public List<String> getNames() {
        return Arrays.asList("help", "?");
    }

    @Override
    public void execute() {
        System.out.println("Список доступных команд");
        for (CommandInterface commandInterface : commandInterfaceCollection) {
            System.out.println(commandInterface.getNames());
        }
    }
}
