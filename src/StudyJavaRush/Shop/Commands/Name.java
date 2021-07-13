package StudyJavaRush.Shop.Commands;

import StudyJavaRush.Shop.Person;
import StudyJavaRush.Shop.Plant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static StudyJavaRush.Shop.Methods.Reader.readText;


public abstract class Name implements CommandInterface {
    Person name;

    @Override
    public List<String> getNames() {
        return Arrays.asList("setName");
    }

    public Name(Person person) {
        this.name = person;
    }

    public void execute(ArrayList<Plant> cart) throws IOException {
        while (true) {
            System.out.println("Введите имя");
            name.setName(readText());
            if (!name.getName().equals("")) ;
        }
    }

    public String getName() {
        return name.getName();
    }
}
