import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Task 1
        System.out.println("Task 1");
        System.out.println(nonRepeatable("abracadabra"));

        //Task 2
        System.out.println("Task 2");
        System.out.println(generateBrackets(3));

        //Task 3
        System.out.println("Task 3");
        System.out.println(binarySystem(3));

        //Task 4
        System.out.println("Task 4");
        System.out.println(alphabetRow("abcdqwer"));

        //Task 5
        System.out.println("Task 5");
        System.out.println(consecutiveCharacters("aaabbcddaaaabbbb"));

        //Task 6
        System.out.println("Task 6");
        System.out.println(convertToNum("one thousand nine hundred eleven"));

        //Task 7
        System.out.println("Task 7");
        System.out.println(uniqueSubstring("123412341"));

        //Task 8
        Integer[][] array = {
                {2, 7, 4},
                {1, 4, 8},
                {4, 5, 9}};
        System.out.println("Task 8");
        System.out.println(shortestWay(array));

        //Task 9
        System.out.println("Task 9");
        System.out.println(numericOrder(("t3o the5m 1One all6 r4ule ri2ng")));

        //Task 10
        System.out.println("Task 10");
        System.out.println(switchNums(6274, 71259));
    }

    //Task 1
    public static String nonRepeatable(String str){
        StringBuilder ans = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                ans.append(c);
            }
        }
        return ans.toString();
    }

    //Task 2
    public static HashSet<String> generateBrackets(Integer n) {
        //Главная идея в том, чтобы сначала получить всевозможные комбинации скобок, чтобы потом отобрать подходящие
        //А получаем их через двоичные числа, 1 = (, 0 = )
        HashSet<String> brackets = new HashSet<>();
        Integer maxBI = 1, bracketLen = n * 2;

        while (bracketLen > 0){
            maxBI *= 2;
            bracketLen--;
        }
        bracketLen = n * 2;
        maxBI--;
        //maxBI - это максимальное двочиное число длиной bracketLen = n * 2, так как n - число пар скобок
        //От maxBI до 0 получаем все числа
        while (maxBI > 0){
            Integer data = maxBI;
            String bracket = "";
            bracket = Integer.toBinaryString(data);
            //Добавляем нолики в начале, если число небольшое
            while (bracket.length() < bracketLen){
                String bracket2 = "0";
                bracket2 += bracket;
                bracket = bracket2;
            }
            int s = 0;
            boolean check = true;
            //Проверяем на корректность
            for (int i = 0; i < bracket.length(); i++) {
                Character c = bracket.charAt(i);
                if(c.equals('1'))s++;
                else s--;
                if(s < 0)check = false;
            }
            //Если совпадает, меняем 10 на () и добавляем
            if(s == 0 && check == true){
                String ans = "";
                for (int i = 0; i < bracket.length(); i++) {
                    Character c = bracket.charAt(i);
                    if(c.equals('1'))ans += '(';
                    else ans += ')';
                }
                brackets.add(ans);
            }
            maxBI--;
        }
        return brackets;
    }

    //Task 3
    public static HashSet<String> binarySystem(int n){
        HashSet<String> ans = new HashSet<>();
        Integer maxBI = 1, ansLen = n;
        while (ansLen > 0){
            maxBI *= 2;
            ansLen--;
        }
        ansLen = n;
        maxBI--;

        while (maxBI > 0){
            Integer data = maxBI;
            String num = "";
            num = Integer.toBinaryString(data);
            
            while (num.length() < ansLen) {
                String temp = "0";
                temp += num;
                num = temp;
            }

            boolean check = true;

            for (int i = 1; i < num.length(); i++) {
                Character c1 = num.charAt(i - 1),
                        c2 = num.charAt(i);
                if(c1 == '0' && c2 == '0'){
                    check = false;
                    break;
                }
            }

            if(check == true){
                ans.add(num);
            }
            maxBI--;
        }
        return ans;
    }

    //Task 4
    public static String alphabetRow(String str){
        int maxLen = 0, plusLen = 0, minusLen = 0;
        String plusAns = "", minusAns = "", ans = "";

        for (int i = 0; i < str.length() - 1; i++) {
            Character c0 = str.charAt(i);
            Character c1 = str.charAt(i + 1);
            if(c0 + 1 == c1){
                plusLen++;
                plusAns += c1;
                minusLen = 0;
                minusAns = "";
            }
            if(c0 - 1 == c1){
                minusLen++;
                minusAns += c1;
                plusLen = 0;
                plusAns = "";
            }
            if(plusLen > maxLen){
                ans = (char)(plusAns.charAt(0) - 1) + plusAns;
            }
            if(minusLen > maxLen){
                ans = (char)(minusAns.charAt(0) + 1) + minusAns;
            }
        }
        return ans;
    }

    //Task 5
    public static String consecutiveCharacters(String str){
        ArrayList<CharIntPair> list = new ArrayList<>();
        Integer len = 1;
        str += " ";
        for (int i = 0; i < str.length() - 1; i++) {
            Character c0 = str.charAt(i);
            Character c1 = str.charAt(i + 1);

            if(c0 == c1){
                len++;
            }
            else {
                list.add(new CharIntPair(len, c0));
                len = 1;
            }
        }
        Collections.sort(list);
        StringBuilder ans = new StringBuilder();
        for (CharIntPair i : list){
            ans.append(i.value);
            ans.append(i.key);
        }
        return ans.toString();
    }

    //Task 6
    public static Integer convertToNum(String num) {
        HashMap<String, Integer> numberMap = new HashMap<>();
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);
        numberMap.put("ten", 10);
        numberMap.put("eleven", 11);
        numberMap.put("twelve", 12);
        numberMap.put("thirteen", 13);
        numberMap.put("fourteen", 14);
        numberMap.put("fifteen", 15);
        numberMap.put("sixteen", 16);
        numberMap.put("seventeen", 17);
        numberMap.put("eighteen", 18);
        numberMap.put("nineteen", 19);
        numberMap.put("twenty", 20);
        numberMap.put("thirty", 30);
        numberMap.put("forty", 40);
        numberMap.put("fifty", 50);
        numberMap.put("sixty", 60);
        numberMap.put("seventy", 70);
        numberMap.put("eighty", 80);
        numberMap.put("ninety", 90);
        String[] words = num.split(" ");
        int result = 0;
        int tempResult = 0;
        for (String word : words) {
            if (word.equals("hundred")) {
                result += tempResult * 100;
                tempResult = 0;
            } else if (word.equals("thousand")) {
                result += tempResult * 1000;
                tempResult = 0;
            } else {
                tempResult += (int)numberMap.get(word);
            }
        }
        result += tempResult;
        return result;
    }

    //Task 7
    public static String uniqueSubstring(String num){
        String ans = "";
        int maxLen = 0;
        for (int i = 0; i < num.length() - 1; i++) {
            String tempString = "" + num.charAt(i);
            int tempMaxLen = 0;
            for (int j = i + 1; j < num.length(); j++) {
                String s = "" + num.charAt(j);
                if(!tempString.contains(s)){
                    tempString += s;
                    tempMaxLen++;
                }
                else break;
            }
            if(tempMaxLen > maxLen){
                ans = tempString;
                maxLen = tempMaxLen;
            }
        }
        return ans;
    }

    //Task 8
    public static Integer shortestWay(Integer[][] array){
        Integer n = array.length,
                binAddLen = (n - 1) * 2,
                binMax = (int) Math.pow(2, binAddLen) - 1;
        ArrayList<String> binAddList = new ArrayList<>();
        ArrayList<Integer> sumList = new ArrayList<>();
        while (binMax > 0){
            String s = Integer.toBinaryString(binMax);
            int check = 0;
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if(c.equals('1')) check++;
                if(check > binAddLen / 2) break;
            }
            if(check == binAddLen / 2) {
                while (s.length() < binAddLen){
                    String s2 = "0";
                    s2 += s;
                    s = s2;
                }
                binAddList.add(s);
            }
            binMax--;
        }
        for (int i = 0; i < binAddList.size(); i++) {
            int sum = array[0][0], ai = 0, aj = 0;
            String str = binAddList.get(i);
            for (int j = 0; j < str.length(); j++) {
                Character c = str.charAt(j);
                if(c.equals('1'))ai++;
                else aj++;
                sum += array[ai][aj];
            }
            sumList.add(sum);
        }
        Collections.sort(sumList);
        return sumList.get(0);
    }

    //Task 9
    public static String numericOrder(String text){
        String ans = "";
        Map<Integer, String> map = new HashMap<>();
        String[] words = text.split(" ");
        Integer maxIndex = 0;

        for (String word : words) {
            int index = 0;
            String tempWord = "";
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if("123456789".indexOf(c) == -1)tempWord += c;
                else index = (int)c - 48;
            }
            if(index > maxIndex)maxIndex = index;
            map.put(index, tempWord);
        }
        Map<Integer, String> sortedMap = new TreeMap<>(map);
        for (int i = 1; i <= maxIndex; i++) {
            ans += sortedMap.get(i) + " ";
        }
        return ans;
    }


    //Task 10
    public static Integer switchNums(Integer n1, Integer n2){
        String num1 = n1.toString(),
                num2 = n2.toString(),
                ans = "";
        ArrayList<Integer> sortedNum1 = new ArrayList<>();
        for (int i = 0; i < num1.length(); i++) {
            Character c = num1.charAt(i);
            sortedNum1.add(c - 48);
        }
        Collections.sort(sortedNum1);
        Collections.reverse(sortedNum1);
        Integer index = 0;
        for (int i = 0; i < num2.length(); i++) {
            if(sortedNum1.get(index) > num2.charAt(i) -48){
                ans += sortedNum1.get(index);
                index++;
            }
            else ans += num2.charAt(i) - 48;
        }
        return Integer.parseInt(ans);
    }
}