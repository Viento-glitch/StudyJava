package StudyJavaRush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MapAndSortCollections {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        ArrayList<String> commandCollection = new ArrayList<>();
        ArrayList<String> listOfKeys = new ArrayList<>();
        ArrayList<String> listOfValues = new ArrayList<>();

        //список команд для консоли юзверя
        commandCollection.add("help");
        commandCollection.add("sort.natural");
        commandCollection.add("sort.reverse");
        commandCollection.add("print");
        commandCollection.add("values");
        commandCollection.add("end");
        commandCollection.add("name");
        commandCollection.add("setName");

        map.put("арбуз", "ягода");
        map.put("банан", "трава");
        map.put("вишня", "ягода");
        map.put("груша", "фрукт");
        map.put("дыня", "овощ");
        map.put("ежевика", "куст");
        map.put("жень-шень", "корень");
        map.put("земляника", "ягода");
        map.put("ирис", "цветок");
        map.put("картофель", "клубень");
        map.put("клубника", "ягода");


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
            if (text.equals("values")) {
                Iterator<String> iteratorOfValues = map.values().iterator();
                Iterator<String> iteratorOfValues1 = map.values().iterator();
                Iterator<String> iteratorOfKeys = map.keySet().iterator();
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
            }
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