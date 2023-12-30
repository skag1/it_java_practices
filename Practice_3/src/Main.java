import static java.lang.Character.toLowerCase;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

        //Task 1
        System.out.println(replaceVowels("apple"));

        //Task 2
        System.out.println(stringTransform("bookkeeper"));

        //Task 3
        System.out.println(doesBlockFit(1, 3, 5, 4, 5));

        //Task 4
        System.out.println(numCheck(52));

        //Task 5
        int[] array5 = {1, -3, 2};
        System.out.println(countRoots(array5));

        //Task 6
        String[][] array6 = {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        };
        System.out.println(salesData(array6));

        //Task 7
        System.out.println(validSplit("apple eagle egg goat"));

        //Task 8
        int[] array8 = {1, 2, -6, 10, 3, 5};
        System.out.println(waveForm(array8));

        //Task 9
        System.out.println(commonVowel("Actions speak louder than words"));

        //Task 10
        int[][] array10 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 29, 10},
                {5, 5, 5, 5, 35},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        };
        array10 = dataScience(array10);
        for (int i = 0; i < array10.length; i++) {
            for (int j = 0; j < array10.length; j++) {
                System.out.print(array10[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Task 1
    public static String replaceVowels(String word){
        return word.replaceAll("[EeYyUuIiOoAa]", "*");
    }

    //Task 2
    public static String stringTransform(String word){
        String ans = "";
        for (int i = 0; i < word.length() - 1; i++) {
            String bigChar = word.charAt(i) + "";
            if(word.charAt(i) == word.charAt(i + 1)){
                ans += "Double" + bigChar.toUpperCase();
                i++;
            }
            else {
                ans += word.charAt(i);
            }
        }
        ans += word.charAt(word.length() - 1);
        return ans;
    }

    //Task 3
    public static boolean doesBlockFit(int a, int b, int c, int w, int h){
        int maxHole = max(w, h);
        int minHole = min(w, h);

        int maxBlockLen = max(a, max(b, c));
        int minBlockLen = min(a, min(b, c));
        int middleBlockLen = a + b + c - minBlockLen - maxBlockLen;

        return (minHole >= minBlockLen && maxHole >= middleBlockLen);
    }

    //Task 4
    public static boolean numCheck(int arg){
        int s = 0, a = arg;

        while (arg > 0){
            s += (arg % 10) * (arg % 10);
            arg /= 10;
        }
        return (a % 2 == s % 2);
    }

    //Task 5
    public static int countRoots(int[] array){
        int a = array[0], b = array[1], c = array[2], ans = 0;
        double D = b * b - 4 * a * c;
        double x1 = (-b - sqrt(D)) / 2;
        double x2 = (-b + sqrt(D)) / 2;

        if(x1 % 1 == 0) ans++;
        if(x2 % 1 == 0 && x1 != x2) ans++;

        return ans;
    }

    //Task 6
    public static String salesData(String[][] array){
        String mostSellingFood = "";
        int maxShops = 0;

        for (int i = 0; i < array.length; i++) {
            String[] foodArray = array[i];

            if (foodArray.length > maxShops){
                mostSellingFood = foodArray[0];
                maxShops = foodArray.length;
            }
        }
        return mostSellingFood;
    }

    //Task 7
    public static boolean validSplit(String s){
        for (int i = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i), c1 = s.charAt(i - 1), c2 = s.charAt(i + 1);

            if(c == ' ' && c1 != c2)return false;
        }
        return true;
    }

    //Task 8
    public static boolean waveForm(int[] array){
        int check;

        if(array[0] - array[1] > 0)check = 1;
        else check = -1;

        for (int i = 1; i < array.length - 1; i++) {
            int fastCheck;
            if(array[i] - array[i + 1] > 0)fastCheck = 1;
            else fastCheck = -1;

            if(check == fastCheck)return false;
            else check = fastCheck;
        }
        return true;
    }

    //Task 9
    public static char commonVowel(String s){
        int max = 0;
        char ans = ' ';
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if("eyuioa".indexOf(c) > -1) {
                int count = 0;

                for (int j = 0; j < s.length(); j++) {
                    if (c == s.charAt(j)) count++;
                }

                if (count > max) {
                    max = count;
                    ans = c;
                }
            }
        }
        return ans;
    }

    //Task 10
    public static int[][] dataScience(int[][] array){
        for (int i = 0; i < array.length; i++) {
            double change = 0;
            for (int j = 0; j < array.length; j++) {
                if(i != j) change += array[j][i];
            }
            array[i][i] = (int) round(change / 4);
        }
        return array;
    }
}