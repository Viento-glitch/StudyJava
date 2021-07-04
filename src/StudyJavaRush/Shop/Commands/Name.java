package StudyJavaRush.Shop.Commands;

import StudyJavaRush.Shop.Person;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static StudyJavaRush.Shop.Methods.Reader.readText;


public class Name implements CommandInterface {
    Person person;

    @Override
    public List<String> getNames() {
        return Arrays.asList("setName");
    }

    public Name(Person person) {
        this.person = person;
    }

    @Override
    public void execute() throws IOException {
        while (true) {
            System.out.println("Введите имя");
            person.setName(readText());
            if (!person.getName().equals("")) ;
        }
    }

    public String getName() {
        return person.getName();
    }
}
