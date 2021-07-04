package StudyJavaRush.Store.command;

import java.util.Arrays;
import java.util.List;

public class SortCommand implements CommandInterface {

    @Override
    public List<String> getNames() {
        return Arrays.asList("sort");
    }

    @Override
    public void execute() {
        System.out.println("Выберите порядок сортировки");
        System.out.println("sort.natural -По возрастанию");
        System.out.println("sort.reverse -По возрастанию");
    }
}
