package StudyJavaRush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TestLearningRoom {
    public static void main(String[] args) throws IOException {
        ArrayList<String> commandCollection = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> listOfTip = new ArrayList<>();

        ArrayList<Plant> plants = new ArrayList<>();

        //список команд для консоли юзверя
        commandCollection.add("help");
        commandCollection.add("sort.natural");
        commandCollection.add("sort.reverse");
        commandCollection.add("print");
        commandCollection.add("tip");
        commandCollection.add("end");
        commandCollection.add("name");
        commandCollection.add("setName");

        plants.add(new Plant("арбуз", "ягода", 12, 23));
        plants.add(new Plant("банан", "трава", 30, 38));
        plants.add(new Plant("вишня", "ягода", 153, 48));
        plants.add(new Plant("груша", "овощь", 412, 37));
        plants.add(new Plant("дыня", "овощ", 10, 16));
        plants.add(new Plant("ежевика", "куст", 912, 10));
        plants.add(new Plant("женьшень", "корень", 212, 22));
        plants.add(new Plant("земляника", "ягода", 132, 234));
        plants.add(new Plant("ирис", "цветок", 142, 2));
        plants.add(new Plant("картофель", "клубень", 212, 3));
        plants.add(new Plant("клубника", "ягода", 127, 22));

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
            if (text.equals("tip")) {
                plants.stream().map(Plant::getTip).filter(t -> !listOfTip.contains(t)).forEach(listOfTip::add);

                System.out.println("Выберите значение");

                //создаёт список неповторающихся типов
                for (String value : listOfTip) {//выводит список значений без повторов
                    System.out.println(value);
                }
                String selectedTip = readText();//выбраное значение
                //сравнение значения в списке с введённым значением
                //сортировка именно этого значения
                //добавление элемента в список имён
                // при условии отсутствия данного имени в данном списке
                for (Plant plant : plants) {
                    if (plant.getTip().equals(selectedTip)) {
                        String name = plant.getName();
                        names.add(name);
                    }
                }
            }
            if (text.equals("end")) break;
            if (text.equals("help")) help(commandCollection);
            if (text.equals("sort")) {
                System.out.println("Выберите порядок сортировки");
                System.out.println("sort.natural -По возрастанию");
                System.out.println("sort.reverse -По возрастанию");
            }
            if (text.equals("sort.natural")) reverser(text, names);
            if (text.equals("sort.reverse")) reverser(text, names);
            if (text.equals("print")) names.forEach(System.out::println);
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

//    public void getInfo() {
//    }

    public Plant(String name, String tip, int pricePerKilogram, int kilograms) {
        this.name = name;
        this.tip = tip;
        this.pricePerKilogram = pricePerKilogram;
        this.kilograms = kilograms;
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