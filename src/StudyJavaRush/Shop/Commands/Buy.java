package StudyJavaRush.Shop.Commands;

import StudyJavaRush.Shop.Person;
import StudyJavaRush.Shop.Plant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buy implements CommandInterface {

    public Buy(ArrayList<Plant> cart, Person person) {
        this.person = person;
        this.cart = cart;
    }

    private Person person;
    private ArrayList<Plant> bayed = new ArrayList<>();
    private String text;
    private ArrayList<Plant> cart;

    @Override
    public List<String> getNames() {
        return Arrays.asList("buy");
    }

    @Override
    public void execute() throws IOException {
        bayed.addAll(cart);
        cart.clear();
        text = "end";
        if (text.equals("end")) {
            System.out.println(person.getName());
            System.out.println("Вы покинули магазин");
            int sum = 0;
            for (int i = 0; i < bayed.size(); i++) {
                System.out.println(bayed.get(i).getName() + " " + bayed.get(i).getKilograms() + "кг");
                System.out.println("Цена за килограмм = " + bayed.get(i).getPricePerKilogram());
                sum = sum + (bayed.get(i).getPricePerKilogram() * bayed.get(i).getKilograms());
            }
            System.out.println("Сумма затраченных средств = " + sum);
        }
    }
}
