package StudyJavaRush;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapHashMapRus {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
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
        Iterator iterator = map.entrySet().iterator();
        for (int i = 0; i < map.size(); i++) {
            System.out.println(iterator.next());
        }
        System.out.println("======================================================");
        map.put("клубника", "ягода");
        //решение
        Iterator <String> iterValues= map.values().iterator();
        Iterator <String> iterKeys= map.keySet().iterator();
        for (int i = 0; i < map.size(); i++) {
            if (iterValues.next().equals("ягода")){
                System.out.println(iterKeys.next());
            }
            else {iterKeys.next();}
        }
    }
}
