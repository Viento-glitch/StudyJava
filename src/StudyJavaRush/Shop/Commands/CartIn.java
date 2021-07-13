package StudyJavaRush.Shop.Commands;

import StudyJavaRush.Shop.Plant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartIn implements CommandInterface {

    public List<String> getNames() {
        return Arrays.asList("cart.in");
    }

    ArrayList<Plant> cart;

    public CartIn(ArrayList<Plant> cart) {
        this.cart = cart;
    }

    public void execute() {
        if (!cart.isEmpty()) {
            for (int i = 0; i < cart.size(); i++) {
                System.out.println(cart.get(i).getName() + " " + cart.get(i).getKilograms() + "кг");
            }
        } else {
            System.out.println("Корзина пуста");
        }
    }
}
