package StudyJavaRush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TestLearningRoom {
    public static void main(String[] args) throws IOException {
        ArrayList<String> commandCollection = new ArrayList<>();
        ArrayList<String> listNames = new ArrayList<>();
        ArrayList<String> listOfTip = new ArrayList<>();
        ArrayList<Plant> plants = new ArrayList<>();
        ArrayList<Plant> basket = new ArrayList<>();
        ArrayList<Plant> bayed = new ArrayList<>();
        //список команд для консоли юзверя
        commandCollection.add("help");
        commandCollection.add("?");
        commandCollection.add("sort.natural");
        commandCollection.add("sort.reverse");
//        commandCollection.add("print");
        commandCollection.add("price");
        commandCollection.add("price.?");
        commandCollection.add("price.all");
        commandCollection.add("price.full");
        commandCollection.add("tip");
        commandCollection.add("end");
        commandCollection.add("name");
        commandCollection.add("basket.add");
        commandCollection.add("basket.price");
        commandCollection.add("basket.in");
        commandCollection.add("setName");
        commandCollection.sort(Comparator.naturalOrder());
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

        //проверка количества взятого товара
        //todo возможность убрать из карзины
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
                person.setName(readText());
            }
            text = readText();
            if (text.equals("price.full")) {
                if (listNames.isEmpty()) {
                    System.out.println("Вы не быбрали тип элемента");
                    text = "tip";
                }
            }
            if (text.equals("price.all")) {
                if (listNames.isEmpty()) {
                    System.out.println("Вы не быбрали тип элемента");
                    text = "tip";
                }
            }
            if (text.equals("price.?")) {
                System.out.println("Выберите вид цены");
                System.out.println("price.full - цена всего выбраного товара на складе");
                System.out.println("price.all - цена выбранного товара за килограм");
            }
            if (text.equals("setName")) {
                System.out.println("Введите имя");
                person.setName(readText());
            }
            if (text.equals("name")) {
                System.out.println("Текущее имя = " + person.getName());
                System.out.println("Для смены имени вы можете использовать команду setName");
            }

            if (text.equals("basket.price")) {
                int price = 0;
                for (int i = 0; i < basket.size(); i++) {
                    price = price + basket.get(i).getPrice();
                }
            }
            if (text.equals("basket.in")) {
                if (!basket.isEmpty()) {
                    for (int i = 0; i < basket.size(); i++) {
                        System.out.println(basket.get(i).getName());
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
                text = "basket.add";
            }
            if (text.equals("basket.add")) {
                if (!listNames.isEmpty()) {
                    System.out.println("Какой товар?");
                    listNames.forEach(System.out::println);
                    text = readText();//имя товара
                    for (int i = 0; i < plants.size(); i++) {
                        if (plants.get(i).getName().equals(text)) {//поиск товара по имени
                            System.out.println("Есть " + plants.get(i).getKilograms());//вывод количества присутствующего
                            int howMuch = 0;
                            while (true) {
                                System.out.println("Количество?(кг)");//проверка на количество товара
                                howMuch = Integer.parseInt(readText());
                                if (howMuch > plants.get(i).getKilograms()) System.out.println("Такого количества нет");
                                else break;
                                //проверка на остаток продукта

                            }
                            int balance;
                            balance = plants.get(i).getKilograms() - howMuch;
                            if (howMuch > 0) basketAdd(basket, plants.get(i));
                            else {
                                System.out.println("Не задерживайте очередь если ничего не покупаете!");
                                System.out.println("Вас выгнали из магазина =(");
                                health = health - 1;
                            }
                            if (balance == 0) {
                                System.out.println("Спасибо за пакупку,заходите ещё!");
                                plants.get(i).setBayed(true);

                            }
                        }
                    }

                } else {
                    System.out.println("Вы не выбрали тип");
                }

            }

            if (text.equals("help")) help(commandCollection);
            if (text.equals("?")) help(commandCollection);

            if (text.equals("sort")) {
                System.out.println("Выберите порядок сортировки");
                System.out.println("sort.natural -По возрастанию");
                System.out.println("sort.reverse -По возрастанию");
            }
            if (text.equals("sort.natural")) reverser(text, listNames);
            if (text.equals("sort.reverse")) reverser(text, listNames);
            if (text.equals("bay")) {
                for (Plant plant : basket) {
                    bayed.add(plant);
                }
                basket.clear();
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
        }
    }

    public static void basketAdd(ArrayList<Plant> basket, Plant product) {
        basket.add(product);
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

    public static String readText() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Plant {
    private String name;
    private String tip;
    private int pricePerKilogram;
    private int kilograms;
    private int price = pricePerKilogram * kilograms;
    private boolean bayed;

    public boolean isBayed() {
        return bayed;
    }

    public void setBayed(boolean bayed) {
        this.bayed = bayed;
    }

    public Plant(String name, String tip, int pricePerKilogram, int kilograms, boolean bayed) {
        this.name = name;
        this.tip = tip;
        this.pricePerKilogram = pricePerKilogram;
        this.kilograms = kilograms;
        this.bayed = bayed;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricePerKilogram() {
        return pricePerKilogram;
    }

    public void setPricePerKilogram(int pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public int getKilograms() {
        return kilograms;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    public int getPrice() {
        return price;
    }
}