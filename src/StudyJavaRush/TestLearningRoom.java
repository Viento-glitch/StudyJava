package StudyJavaRush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TestLearningRoom {
    public static void main(String[] args) throws IOException {
        ArrayList<String> commandCollection = new ArrayList<>();
        ArrayList<String> listOfKeys = new ArrayList<>();
        ArrayList<String> listOfValues = new ArrayList<>();

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> tip = new ArrayList<>();
        ArrayList<Integer> pricePerKilogram = new ArrayList<>();
        ArrayList<Integer> kilograms = new ArrayList<>();
        ArrayList<Integer> price = new ArrayList<>();
        ArrayList<String> indexes = new ArrayList<>();

        //список команд для консоли юзверя
        commandCollection.add("help");
        commandCollection.add("sort.natural");
        commandCollection.add("sort.reverse");
        commandCollection.add("print");
        commandCollection.add("values");
        commandCollection.add("end");
        commandCollection.add("name");
        commandCollection.add("setName");

        Plant watermelon = new Plant("арбуз", "ягода", 12, 23, 0);
        Plant banana = new Plant("банан", "трава", 30, 38, 1);
        Plant cherry = new Plant("вишня", "ягода", 153, 48, 2);
        Plant pear = new Plant("груша", "овощь", 412, 37, 3);
        Plant melon = new Plant("дыня", "овощ", 10, 16, 4);
        Plant blackberry = new Plant("ежевика", "куст", 912, 10, 5);
        Plant ginseng = new Plant("женьшень", "корень", 212, 22, 6);
        Plant strawberry = new Plant("земляника", "ягода", 132, 234, 7);
        Plant iris = new Plant("ирис", "цветок", 142, 2, 8);
        Plant potato = new Plant("картофель", "клубень", 212, 3, 9);
        Plant strawberry2 = new Plant("клубника", "ягода", 127, 223, 10);
        indexes.add("watermelon");
        indexes.add("banana");
        indexes.add("cherry");
        indexes.add("pear");
        indexes.add("melon");
        indexes.add("blackberry");
        indexes.add("ginseng");
        indexes.add("strawberry");
        indexes.add("iris");
        indexes.add("potato");
        indexes.add("strawberry2");

        //создаёт список неповторающихся типов
        for (int i = 0; i < indexes.size(); i++) {

        }
        //выводит уже отфильтрованные значения
        String text;
        Person person = new Person();
        person.setName("");
        //todo создать на все значения классы?
        while (true) {
            while (person.getName().isEmpty()) {
                System.out.println("Введите имя");
                person.setName(readText());
            }
            text = readText();
            if (text.equals("setName")) {
                System.out.println("Введите имя");
                person.setName(readText());
            }
            if (text.equals("name")) {
                System.out.println("Текущее имя = " + person.getName());
                System.out.println("Для смены имени вы можете использовать команду setName");
            }
//            if (text.equals(("values"))){
//                indexes.get();
//            }
            /*if (text.equals("values")) {
                System.out.println("Выберите значение");
                for (int i = 0; i < map.size(); i++) {
                    String next = iteratorOfValues.next();
                    if (!listOfValues.contains(next)) listOfValues.add(next);
                    //создаёт список значений без повторов
                }
                for (String value : listOfValues) {//выводит список значений
                    System.out.println(value);
                }
                String selectedValue = readText();//выбраное значение
                for (int i = 0; i < map.size(); i++) {
                    //сравнение значения в списке с введённым значением
                    //сортировка именно этого значения
                    //добавление элемента в список ключей
                    // при условии отсутствия данного элемента в данном списке
                    if (iteratorOfValues1.next().equals(selectedValue)) listOfKeys.add(iteratorOfKeys.next());
                    else iteratorOfKeys.next();
                }
            }*/
            if (text.equals("end")) break;
            if (text.equals("help")) help(commandCollection);
            if (text.equals("sort")) {
                System.out.println("Выберите порядок сортировки");
                System.out.println("sort.natural -По возрастанию");
                System.out.println("sort.reverse -По возрастанию");
            }
            if (text.equals("sort.natural")) reverser(text, listOfKeys);
            if (text.equals("sort.reverse")) reverser(text, listOfKeys);
            if (text.equals("print")) listOfKeys.forEach(System.out::println);
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
    private int index;

//    public void getInfo() {
//    }

    public Plant(String name, String tip, int pricePerKilogram, int kilograms, int index) {
        this.name = name;
        this.tip = tip;
        this.pricePerKilogram = pricePerKilogram;
        this.kilograms = kilograms;
        this.index = index;
    }

    public void setPrice(int price) {
        this.price = price;
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