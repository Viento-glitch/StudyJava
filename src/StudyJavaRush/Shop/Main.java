package StudyJavaRush.Shop;

import StudyJavaRush.Shop.Commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import static StudyJavaRush.Shop.Methods.Reader.readText;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> listNames = new ArrayList<>();

        ArrayList<Plant> plants = new ArrayList<>();
        ArrayList<Plant> cart = new ArrayList<>();
        Person person = new Person();

        buildPlants(plants);
        int health = 1;

        buildCommandList(cart, plants, listNames, person, health);

        String text;
        String profileName = null;

        while (profileName == null) {
            profileName = readText();

            if (profileName.equals("Admin")) {
                System.out.println("Введите пароль");
                String pass = readText();

                if (pass.equals("12344")) {
                    person.setName(profileName);

                } else {
                    System.out.println("Пароль не верен");
                    profileName = null;
                }
            }
        }
        //todo здесь должен быть главный цикл программы

        while (true) {
            if (health < 1) break;
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
            if (text.equals("name")) {
                System.out.println("Для смены имени вы можете использовать команду setName");
            }


            if (text.equals("sort")) {
                System.out.println("Выберите порядок сортировки");
                System.out.println("sort.natural -По возрастанию");
                System.out.println("sort.reverse -По возрастанию");
            }
            if (text.equals("sort.natural")) reverser(text, listNames);
            if (text.equals("sort.reverse")) reverser(text, listNames);

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

    /*  private static ArrayList<String> buildStringsCommandList() {
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
    */
    private static ArrayList<CommandInterface> buildCommandList(ArrayList<Plant> cart, ArrayList<Plant> plants, ArrayList<String> listNames, Person person, int health) {
        //todo реализовать все методы
        ArrayList<CommandInterface> commandInterfaceCollection = new ArrayList<>();
        commandInterfaceCollection.add(new HelpCommands(commandInterfaceCollection));
        commandInterfaceCollection.add(new Name(cart, person));
        commandInterfaceCollection.add(new CartIn(cart));
        commandInterfaceCollection.add(new CartAdd(cart, plants, listNames, health));
        commandInterfaceCollection.add(new CartBack(cart, plants));
        commandInterfaceCollection.add(new Buy(cart, person));


        return commandInterfaceCollection;
    }

    /*    public static void help(ArrayList<String> commandsList) {
            System.out.println("Список доступных команд");
            for (String s : commandsList) {
                System.out.println(s);
            }
        }
    */
    public static void reverser(String a, ArrayList<String> list) {
        if (a.equals("sort.natural")) list.sort(Comparator.naturalOrder());
        if (a.equals("sort.reverse")) list.sort(Comparator.reverseOrder());
    }

}



