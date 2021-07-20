package StudyJavaRush.Shop.Commands;

import StudyJavaRush.Shop.Person;
import StudyJavaRush.Shop.Plant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static StudyJavaRush.Shop.Methods.Reader.readText;


public class Name implements CommandInterface {
    Person name;
    ArrayList<Plant> cart;

    @Override
    public List<String> getNames() {
        return Arrays.asList("setName");
    }

    public Name(ArrayList<Plant> cart, Person person) {
        this.name = person;
        this.cart = cart;
    }

    public void execute() throws IOException {
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
