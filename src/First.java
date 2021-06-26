import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Минимаксы в массивах
*/

public class First {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            nums.add(i, Integer.parseInt(reader.readLine()));
        }

        int biggest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < 20; i++) {
            if (nums.get(i) < smallest) smallest = nums.get(i);
            if (nums.get(i) > biggest) biggest = nums.get(i);
        }
        int maximum = biggest;
        int minimum = smallest;

//        public static int[] getints (Integer.parseInt(reader.readLine())) {
//            return;
//        }//todo должен проверять на целые числа принятые с reader

        System.out.print(maximum + " " + minimum);
    }

    //напишите тут ваш код
}
