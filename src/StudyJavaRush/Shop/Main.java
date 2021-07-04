package StudyJavaRush.Shop;

import StudyJavaRush.Shop.Commands.CommandInterface;
import StudyJavaRush.Shop.Commands.HelpCommands;
import StudyJavaRush.Shop.Commands.Name;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import static StudyJavaRush.Shop.Methods.Reader.readText;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> listNames = new ArrayList<>();
        ArrayList<String> listOfTip = new ArrayList<>();

        ArrayList<Plant> plants = new ArrayList<>();
        ArrayList<Plant> cart = new ArrayList<>();
        ArrayList<Plant> bayed = new ArrayList<>();

        //Создать список команд для консоли юзверя
        buildStringsCommandList();
        //создать список продуктов
        buildPlants(plants);

        //проверка количества взятого товара
        //возможность убрать из карзины
        //сделать покупку
        //при покупке имеющийся товар уменьшается
        //история покупок

        String text;
        Person person = new Person();
        person.setName("");
        int health = 1;
        while (true) {
            if (health < 1) break;
            while (person.getName().isEmpty()) {
                System.out.println("Введите имя");
                Name(person);
            }
            text = readText();
            if (text.equals("price.full")) {
                if (listNames.isEmpty()) {
                    System.out.println("Вы не быбрали тип элемента");
                    text = "tip";
                }
            }
            if (text.equals("price.all")) {//todo исправить
                if (listNames.isEmpty()) {
                    System.out.println("Вы не быбрали тип элемента");
                    text = "tip";
                }
            }
            if (text.equals("price.?")) {//todo перенести методы прайсавнутрь
                System.out.println("Выберите вид цены");
                System.out.println("price.full - цена всего выбраного товара на складе");
                System.out.println("price.all - цена выбранного товара за килограм");
            }
            /*if (text.equals("setName")) {//рудимент
                System.out.println("Введите имя");
                person.setName(readText());*/
            }
            /*if (text.equals("name")) {//todo перенести рудимент в этот метод
                System.out.println("Текущее имя = " + person.getName());
                System.out.println("Для смены имени вы можете использовать команду setName");
            }*/

            if (text.equals("cart.price")) {
                int price = 0;
                for (int i = 0; i < cart.size(); i++) {
                    price = price + cart.get(i).getPrice();
                }
            }
            if (text.equals("cart.in")) {
                if (!cart.isEmpty()) {
                    for (int i = 0; i < cart.size(); i++) {
                        System.out.println(cart.get(i).getName() + " " + cart.get(i).getKilograms() + "кг");
                    }
                } else {
                    System.out.println("Корзина пуста");
                }
            }
            if (text.equals("tip")) {
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
            if (text.equals("cart.add")) {
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


            if (text.equals("sort")) {
                System.out.println("Выберите порядок сортировки");
                System.out.println("sort.natural -По возрастанию");
                System.out.println("sort.reverse -По возрастанию");
            }
            if (text.equals("sort.natural")) reverser(text, listNames);
            if (text.equals("sort.reverse")) reverser(text, listNames);
            if (text.equals("buy")) {
                bayed.addAll(cart);
                cart.clear();
                text = "end";
            }
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
                break;
            }
            if (text.equals("cart.back")) {
                if (!cart.isEmpty()) {
                    System.out.println("Что хотите вернуть?");
                    System.out.println("всё");
                    for (int i = 0; i < cart.size(); i++) {
                        System.out.println(cart.get(i).getName());
                    }
                    text = readText();//выбор продукта к возврату
                    if (text.equals("всё")) {
                        for (int i = 0; i < plants.size(); i++) {
                            for (int j = 0; j < cart.size(); j++) {
                                if (cart.get(j).getName().equals(plants.get(i).getName())) {
                                    plants.get(i).setKilograms(plants.get(i).getKilograms() + cart.get(j).getKilograms());
                                    plants.get(i).setBayed(false);
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
                                    for (int j = 0; j < plants.size(); j++) {//поиск по имени эквивалентного значения
                                        if (plants.get(j).getName().equals(text)) {
                                            plants.get(j).setKilograms(plants.get(j).getKilograms() + k);
                                            plants.get(j).setBayed(false);
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

    }

    private static void buildPlants(ArrayList<Plant> plants) {
        plants.add(new Plant("арбуз", "ягода", 12, 23, false));
        plants.add(new Plant("банан", "трава", 30, 38, false));
        plants.add(new Plant("вишня", "ягода", 153, 48, false));
        plants.add(new Plant("груша", "фрукт", 412, 37, false));
        plants.add(new Plant("дыня", "овощ", 10, 16, false));
        plants.add(new Plant("ежевика", "куст", 912, 10, false));
        plants.add(new Plant("женьшень", "корень", 212, 22, false));
        plants.add(new Plant("земляника", "ягода", 132, 234, false));
        plants.add(new Plant("ирис", "цветок", 142, 2, false));
        plants.add(new Plant("картофель", "клубень", 212, 3, false));
        plants.add(new Plant("клубника", "ягода", 127, 22, false));
    }

    private static ArrayList<String> buildStringsCommandList() {
        ArrayList<String> commandCollection = new ArrayList<>();

        commandCollection.add("help");
        commandCollection.add("?");
        commandCollection.add("sort.natural");
        commandCollection.add("sort.reverse");
        commandCollection.add("price");
        commandCollection.add("price.?");
        commandCollection.add("price.all");
        commandCollection.add("price.full");
        commandCollection.add("tip");
        commandCollection.add("end");
        commandCollection.add("name");
        commandCollection.add("cart.add");
        commandCollection.add("cart.price");//todo сделать метод
        commandCollection.add("cart.in");
        commandCollection.add("cart.back");
        commandCollection.add("setName");
        commandCollection.add("buy");

        commandCollection.sort(Comparator.naturalOrder());
        return commandCollection;
    }

    private static ArrayList<CommandInterface> buildCommandList() {
        ArrayList<CommandInterface> commandInterfaceCollection = new ArrayList<>();
        commandInterfaceCollection.add(new HelpCommands(commandInterfaceCollection));
        commandInterfaceCollection.add(new Name());
        return commandInterfaceCollection;
    }

    private static void updateShopAndCart(ArrayList<Plant> cart, Plant plantInShop, int howMuchNeedBuyer) {
        int balance;
        balance = plantInShop.getKilograms() - howMuchNeedBuyer;
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


    public static void help(ArrayList<String> commandsList) {
        System.out.println("Список доступных команд");
        for (String s : commandsList) {
            System.out.println(s);
        }
    }

    public static void reverser(String a, ArrayList<String> list) {
        if (a.equals("sort.natural")) list.sort(Comparator.naturalOrder());
        if (a.equals("sort.reverse")) list.sort(Comparator.reverseOrder());
    }


}



