package StudyJavaRush;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapAndValues {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");

        PrintValues(map);
    }

    public static void PrintValues(Map<String, String> map) {
        Iterator<String> iterator = map.values().iterator();
        for (int i = 0; i < map.size(); i++) {
            System.out.println(iterator.next());

        }
    }
}
