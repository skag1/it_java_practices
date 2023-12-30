import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println();

        System.out.println("Task 2");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println();

        System.out.println("Task 3");
        int[] arr1 = new int[]{44, 32, 86, 19};
        int[] arr2 = new int[]{22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(arr1));
        System.out.println(differenceEvenOdd(arr2));
        System.out.println();

        System.out.println("Task 4");
        float[] eArr1 = new float[]{1, 2, 3, 4, 5};
        float[] eArr2 = new float[]{1, 2, 3, 4, 6};
        System.out.println(equalToAvg(eArr1));
        System.out.println(equalToAvg(eArr2));
        System.out.println();

        System.out.println("Task 5");
        int[] iArr1 = new int[]{1, 2, 3};
        int[] iArr2 = new int[]{3, 3, -2, 408, 3, 31};
        int[] iArr11 = indexMult(iArr1);
        int[] iArr12 = indexMult(iArr2);
        for (int i = 0; i < iArr11.length; i++) {
            System.out.print(iArr11[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < iArr12.length; i++) {
            System.out.print(iArr12[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Task 6");
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println();

        System.out.println("Task 7");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println();

        System.out.println("Task 8");
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println();

        System.out.println("Task 9");
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println();

        System.out.println("Task 10");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }

    //Task 1
    public static boolean duplicateChars(String word){
        boolean repeats = false;
        word = word.toLowerCase();
        for (int i = 0; i < word.length() - 1; i++) {
            char letter = word.charAt(i);
            for (int j = i + 1; j < word.length(); j++) {
                if(letter == word.charAt(j))repeats = true;
            }
        }
        return repeats;
    }

    //Task 2
    public static String getInitials(String name){
        String UpName = "";
        for (int i = 0; i < name.length(); i++) {
            Character letter = name.charAt(i);
            if(letter.hashCode() > 64 && letter.hashCode() < 91)UpName += letter;
        }
        return UpName;
    }

    //Task 3
    public static int differenceEvenOdd(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0)sum += array[i];
            else  sum -= array[i];
        }
        return Math.abs(sum);
    }

    //Task 4
    public static boolean equalToAvg(float[] array){
        float avg = 0;

        for (int i = 0; i < array.length; i++) {
             avg += array[i];
        }
        avg /= array.length;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == avg)return true;
        }
        return false;
    }

    //Task 5
    public static int[] indexMult(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] *= i;
        }
        return array;
    }

    //Task 6
    public static String reverse(String s){
        String newS = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            newS += s.charAt(i);
        }
        return newS;
    }

    //Task 7
    public static int Tribonacci(int index){
        int a1 = 0, a2 = 0, a3 = 1, i = 3, x = 0;
        if(index < 2)return 0;
        else if(index == 2)return 1;
        else {
            while (i != index) {
                x = a1 + a2 + a3;
                a1 = a2;
                a2 = a3;
                a3 = x;
                i++;
            }
            return x;
        }
    }

    //Task 8
    public static StringBuilder pseudoHash(int len){
        StringBuilder hash = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int rand = (int)(Math.random()*16);
            switch (rand) {
                case 0 -> hash.append("0");
                case 1 -> hash.append("1");
                case 2 -> hash.append("2");
                case 3 -> hash.append("3");
                case 4 -> hash.append("4");
                case 5 -> hash.append("5");
                case 6 -> hash.append("6");
                case 7 -> hash.append("7");
                case 8 -> hash.append("8");
                case 9 -> hash.append("9");
                case 10 -> hash.append("a");
                case 11-> hash.append("b");
                case 12 -> hash.append("c");
                case 13 -> hash.append("d");
                case 14 -> hash.append("e");
                case 15 -> hash.append("f");
            }
        }
        return hash;
    }

    //Task 9
    public static String botHelper(String text){
        text = text.toLowerCase();
        for (int i = 0; i < text.length() - 3; i++) {
            char h = text.charAt(i), e = text.charAt(i + 1),
                    l = text.charAt(i + 2), p = text.charAt(i + 3);
            if(h == 'h' && e == 'e' && l == 'l' && p == 'p')
                return "Calling for a staff member";
        }
        return "Keep waiting";
    }

    //Task 10
    public static boolean isAnagram(String s1, String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i] != chars2[i])return false;
        }
        return true;
    }
}