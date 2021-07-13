package StudyJavaRush.Shop.Commands;

import StudyJavaRush.Shop.Plant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static StudyJavaRush.Shop.Methods.Reader.readText;

public class CartBack implements CommandInterface {

    private final ArrayList<Plant> cart;
    private final ArrayList<Plant> plants;

    public CartBack(ArrayList<Plant> cart, ArrayList<Plant> plants) {
        this.cart = cart;
        this.plants = plants;
    }

    @Override
    public List<String> getNames() {
        return null;
    }

    @Override
    public void execute() throws IOException {
        if (!cart.isEmpty()) {
            System.out.println("Что хотите вернуть?");
            System.out.println("всё");
            for (Plant plant : cart) {
                System.out.println(plant.getName());
            }
            String text = readText();//выбор продукта к возврату
            if (text.equals("всё")) {
                for (Plant plant : plants) {
                    for (int j = 0; j < cart.size(); j++) {
                        if (cart.get(j).getName().equals(plant.getName())) {
                            plant.setKilograms(plant.getKilograms() + cart.get(j).getKilograms());
                            plant.setBayed(false);
                            cart.remove(j);
                        }
                    }
                }
            } else {
                for (int i = 0; i < cart.size(); i++) {//поиск продукта в корзине
                    if (text.equals(cart.get(i).getName())) {
                        System.out.println("В вашей корзине " + cart.get(i).getKilograms());
                    }//выводит количество килограм данного продукта
                    System.out.println("Сколько изьять?");
                    int k = Integer.parseInt(readText());
                    if (k > cart.get(i).getKilograms()) {
                        System.out.println("Да вы и не брали столько!");
                    } else {
                        if (k > 0) {
                            cart.get(i).setKilograms(cart.get(i).getKilograms() - k);
                            for (Plant plant : plants) {//поиск по имени эквивалентного значения
                                if (plant.getName().equals(text)) {
                                    plant.setKilograms(plant.getKilograms() + k);
                                    plant.setBayed(false);
                                    if (cart.get(i).getKilograms() == 0) {
                                        cart.remove(i);
                                    }
                                }
                                //реализация возврата в магазин
                            }
                        } else System.out.println("Магия запрещена вне хогвартса");
                    }
                }
            }
        } else {
            System.out.println("Карзина пуста");
        }
    }
}
