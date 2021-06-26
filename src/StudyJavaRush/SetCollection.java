package StudyJavaRush;


//Set из растений


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetCollection {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("женьшень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
