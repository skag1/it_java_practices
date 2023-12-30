import java.security.Key;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Task 1
        System.out.println("Task 1");
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        //Task 2
        System.out.println("Task 2");
        System.out.println(collect("intercontinentalisationalism", 6));

        //Task 3
        System.out.println("Task 3");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));

        //Task 4
        System.out.println("Task 4");
        Integer[] arrayTask4 = {1, 2, 3, 9, 4, 15, 3, 5};
        System.out.println(Arrays.toString(twoProduct(arrayTask4, 45)));

        //Task 5
        System.out.println("Task 5");
        System.out.println(Arrays.toString(isExact(40320)));

        //Task 6
        System.out.println("Task 6");
        System.out.println(fractions("3.(142857)"));

        //Task 7
        System.out.println("Task 7");
        System.out.println(pilish_String("CANIMAKEAGUESSNOW"));

        //Task 8
        System.out.println("Task 8");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));

        //Task 9
        System.out.println("Task 9");
        System.out.println(isValid("abcdefghhgfedecba"));

        //Task 10
        System.out.println("Task 10");
        System.out.println(findLCS("aggtab", "gxtxamb"));
    }

    //Task 1
    public static String hiddenAnagram(String str, String text){
        text = text.toLowerCase();
        str = str.toLowerCase();
        ArrayList<Character> textList = new ArrayList<>(),
                strList = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            if(c >= 97 && c <= 122) textList.add(c);
        }
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if(c >= 97 && c <= 122) strList.add(c);
        }
        Collections.sort(textList);

        for (int i = 0; i <= strList.size() - textList.size(); i++) {
            Character c = strList.get(i);
            if(textList.contains(c)) {
                ArrayList<Character> tempList = new ArrayList<>();
                String anagram = "";
                for (int j = i; j < i + textList.size(); j++) {
                    tempList.add(strList.get(j));
                    anagram += strList.get(j);
                }
                Collections.sort(tempList);
                if (textList.equals(tempList)) return anagram;
            }
        }
        return "notfound";
    }

    //Task 2
    public static ArrayList<String> collect(String word, int n) {
        ArrayList<String> result = new ArrayList<>();
        if (word.length() < n) {
            //uncomment next line for task 3
            result.add(word);
            return result;
        }

        result.add(word.substring(0, n));
        result.addAll(collect(word.substring(n), n));
        //comment next line for task 3
        //Collections.sort(result);
        return result;
    }

    //Task 3
    public static String nicoCipher(String message, String key){
        String answer = "";

        ArrayList<Character> location = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            location.add(key.charAt(i));
        }
        Collections.sort(location);
        HashMap<Integer, Character> sortedMap = new HashMap<>();
        for (int i = 1; i <= location.size(); i++) {
            sortedMap.put(i, location.get(i - 1));
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            Character c = key.charAt(i);
            for (int j = 1; j <= sortedMap.size(); j++) {
                if(sortedMap.get(j).equals(c)){
                    list.add(j);
                    break;
                }
            }
        }
        //Назначили числа отсортированным буквам из ключа

        ArrayList<String> words = collect(message, list.size());
        for (int i = 0; i < words.size(); i++){
            String word = words.get(i);
            while (word.length() < list.size()){
                word += " ";
            }
            //Заполнили пробелами недостающие буквы
            TreeMap<Integer, Character> wordMap = new TreeMap<>();
            for (int j = 0; j < list.size(); j++){
                wordMap.put(list.get(j), word.charAt(j));
            }
            //TreeMap автоматически сортирует по индексу
            for (int j = 1; j <= wordMap.size(); j++) {
                answer += wordMap.get(j);
            }
        }
        return answer;
    }

    //Task 4
    public static Integer[] twoProduct(Integer[] array, Integer value){
        for (int i = 1; i < array.length; i++){
            Integer b = array[i];
            for (int j = 0; j < i; j++) {
                Integer a = array[j];
                if(a * b == value){
                    return new Integer[]{a, b};
                }
            }
        }
        return new Integer[]{};
    }

    //Task 5
    public static Integer[] isExact(Integer n){
        int x = 1, s = 0;
        while (x < n){
            s++;
            x *= s;
        }
        if(x == n)return new Integer[]{x, s};
        else return new Integer[]{};
    }

    //Task 6
    public static String fractions(String n){
        int check = 0;
        String intPart = "", fractPart = "", periodPart = "";
        for (int i = 0; i < n.length(); i++){
            Character c = n.charAt(i);
            if(c.equals('.') || c.equals(')') || c.equals('('))check++;
            else {
                if (check == 0) intPart += c;
                if (check == 1) fractPart += c;
                if (check == 2) periodPart += c;
            }
        }

        Integer numerator, denominator, fractLen, periodLen;
        periodLen = periodPart.length();
        fractLen = fractPart.length() + periodLen;
        if(fractLen.equals(periodLen)){
            numerator = Integer.parseInt(periodPart);
            denominator = (int) Math.pow(10, periodLen) - 1;
        }
        else {
            numerator = Integer.parseInt(fractPart + periodPart) - Integer.parseInt(fractPart);
            denominator = (int) Math.pow(10, fractLen) - (int) Math.pow(10, fractLen - periodLen);
        }
        numerator += denominator * Integer.parseInt(intPart);

        int divider = 2;
        while (divider < numerator && divider < denominator){
            while (numerator % divider == 0 && denominator % divider == 0){
                numerator /= divider;
                denominator /= divider;
            }
            divider++;
        }
        return numerator.toString() + "/" + denominator.toString();
    }

    //Task 7
    public static String pilish_String(String text){
        String PI = "314159265358979", answer = "";
        int len1 = 0, len2 = 0;
        boolean check = false;
        for (int i = 0; i < PI.length(); i++) {
            len2 += Integer.parseInt(PI.charAt(i) + "");
            if(text.length() > len1 && text.length() < len2){
                while(len2 > text.length()){
                    text += text.charAt(text.length()-1);
                }
                check = true;
            }
            try {
                answer += text.substring(len1, len2) + " ";
                len1 = len2;
            }
            catch (Exception e){
                return answer;
            }
            finally {
                if (check) return answer;
            }
        }
        return answer;
    }

    //Task 8
    public static double generateNonconsecutive(String expression) {
        try {
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();

            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == ' ')
                    continue;

                if (Character.isDigit(ch) || ch == '.') {
                    StringBuilder numBuilder = new StringBuilder();
                    while (i < expression.length() &&
                            (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        numBuilder.append(expression.charAt(i));
                        i++;
                    }
                    i--;
                    numbers.push(Double.parseDouble(numBuilder.toString()));
                } else if (ch == '(') {
                    operators.push(ch);
                } else if (ch == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        evaluateOperation(numbers, operators);
                    }
                    operators.pop(); // Remove the '('
                } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                        evaluateOperation(numbers, operators);
                    }
                    operators.push(ch);
                }
            }

            while (!operators.isEmpty()) {
                evaluateOperation(numbers, operators);
            }

            if (numbers.size() == 1 && operators.isEmpty()) {
                return numbers.pop();
            } else {
                throw new IllegalArgumentException("Invalid expression");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Double.NaN; // Return NaN for error cases
        }
    }

    private static void evaluateOperation(Stack<Double> numbers, Stack<Character> operators) {
        double num2 = numbers.pop();
        double num1 = numbers.pop();
        char operator = operators.pop();

        double result = performOperation(num1, num2, operator);
        numbers.push(result);
    }

    private static boolean hasPrecedence(char op2, char op1) {
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }

    private static double performOperation(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    //Task 9
    public static String isValid(String text){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character c1 = text.charAt(i);
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                Character c2 = text.charAt(j);
                if(c2 == c1)count++;
            }
            map.put(c1, count);
        }
        for (Map.Entry entry : map.entrySet()){
            Integer n = (Integer) entry.getValue();
            list.add(n);
        }
        for (int i = 0; i < list.size(); i++) {
            int s = 0;
            for (int j = 0; j < list.size(); j++) {
                s += Math.abs(list.get(j) - list.get(i));
            }
            if(s == 0 || s == 1)return "YES";
        }
        return "NO";
    }

    //Task 10
    public static String findLCS(String first, String second){
        HashMap<Integer, String> map = new HashMap<>();
        for (int h = 0; h < first.length(); h++) {
            String answer = "";
            int k = 0, count = 0;
            for (int i = h; i < first.length(); i++) {
                Character c1 = first.charAt(i);
                for (int j = k; j < second.length(); j++) {
                    Character c2 = second.charAt(j);
                    if (c1 == c2) {
                        answer += c1;
                        k = j + 1;
                        count++;
                    }
                }
            }
            map.put(count, answer);
        }
        return map.get(map.size());
    }
}