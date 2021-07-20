package StudyJavaRush.Shop.Commands;

import StudyJavaRush.Shop.Plant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static StudyJavaRush.Shop.Methods.Reader.readText;

public class CartAdd implements CommandInterface {

    public List<String> getNames() {
        return Arrays.asList("cart.add");
    }

    ArrayList<Plant> cart;
    private ArrayList<String> listNames;
    private ArrayList<Plant> plants;
    private int health;
    private ArrayList<String> listOfTip = new ArrayList<>();

    String text;

    public CartAdd(ArrayList<Plant> cart, ArrayList<Plant> plants, ArrayList<String> listNames,int health) {
        this.cart = cart;
        this.listNames = listNames;
        this.plants = plants;
        this.health = health;
    }

    public void execute() throws IOException {
        {
            if (!listOfTip.isEmpty()) listOfTip.clear();
            for (Plant plant1 : plants) {
                if (!plant1.isBayed()) {
                    String t = plant1.getTip();
                    if (!listOfTip.contains(t)) {
                        listOfTip.add(t);
                    }
                }
            }
            System.out.println("Выберите тип");
            //создаёт список неповторающихся типов
            for (String value : listOfTip) System.out.println(value);
            String selectedTip = readText();//выбраное тип
            //сравнение типа в списке с введённым типом
            //сортировка именно этого типа
            //добавление элемента в список имён
            // при условии отсутствия данного имени в данном списке
            if (!listNames.isEmpty()) listNames.clear();
            for (Plant plant : plants) {
                if (plant.getTip().equals(selectedTip)) {
                    String name = plant.getName();
                    listNames.add(name);
                }
            }
            text = "cart.add";
        }
        if (!listNames.isEmpty()) {
            System.out.println("Какой товар?");
            listNames.forEach(System.out::println);
            text = readText();//имя товара
            for (Plant plantInShop : plants) {
                if (plantInShop.getName().equals(text)) {//поиск товара по имени
                    System.out.println("Есть " + plantInShop.getKilograms());//вывод количества присутствующего
                    int howMuchNeedBuyer = 0;
                    while (true) {
                        System.out.println("Количество?(кг)");//проверка на количество товара
                        howMuchNeedBuyer = Integer.parseInt(readText());
                        if (howMuchNeedBuyer > plantInShop.getKilograms())
                            System.out.println("Такого количества нет");
                        else break;

                    }

                    if (howMuchNeedBuyer > 0) {
                        updateShopAndCart(cart, plantInShop, howMuchNeedBuyer);

                    } else {
                        System.out.println("Не задерживайте очередь если ничего не покупаете!");
                        System.out.println("Вас выгнали из магазина =(");
                                health = health - 1;
                    }
                    //проверка на остаток продукта
                    if (plantInShop.getKilograms() == 0) {
                        System.out.println("Товар " + plantInShop.getName() + " закончился в магазине");
                        plantInShop.setBayed(true);

                    }
                }
            }

        } else {
            System.out.println("Вы не выбрали тип");
        }

    }

    private static void updateShopAndCart(ArrayList<Plant> cart, Plant plantInShop, int howMuchNeedBuyer) {
        int balance = plantInShop.getKilograms() - howMuchNeedBuyer;
        Plant foundPlant = null;
        int size = cart.size();
        for (int i = 0; i < size; i++) {
            Plant selectedPlantInCart = cart.get(i);
            if (plantInShop.getName().equals(selectedPlantInCart.getName())) {//если соответствие
                foundPlant = selectedPlantInCart;
                break;
            }
        }

        if (foundPlant != null) {
            foundPlant.setKilograms(foundPlant.getKilograms() + howMuchNeedBuyer);
            plantInShop.setKilograms(balance);

        } else {
            Plant newPlant = new Plant(plantInShop);
            newPlant.setKilograms(howMuchNeedBuyer);
            cart.add(newPlant);
        }
    }
}
