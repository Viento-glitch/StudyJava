package StudyJavaRush.Shop.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelpCommands implements CommandInterface {

    private ArrayList<CommandInterface> commandInterfaceCollection;

    public HelpCommands(ArrayList<CommandInterface> commandInterfacesCollection) {
        this.commandInterfaceCollection = commandInterfacesCollection;
    }


    @Override
    public List<String> getNames() {
        return Arrays.asList("help","?");
    }

    @Override
    public void execute() {
        System.out.println("Список доступных команд");
        for (CommandInterface commandInterface : commandInterfaceCollection) {
            System.out.println(commandInterface.getNames());

        }
    }
}
