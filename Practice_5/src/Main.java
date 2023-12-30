import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        //Task 1
        System.out.println("Task 1");
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));

        //Task 2
        System.out.println("Task 2");
        System.out.println(spiderVsFly("B4", "H1"));

        //Task 3
        System.out.println("Task 3");
        System.out.println(digitsCount(5432134));

        //Task 4
        System.out.println("Task 4");
        String[] words = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println(totalPoints(words, "tossed"));

        //Task 5
        System.out.println("Task 5");
        Integer[] nums = {1, 6, 5, 4, 8, 2, 3, 7};
        System.out.println(Arrays.deepToString(sumsUp(nums)));

        //Task 6
        System.out.println("Task 6");
        String[] points = {"95%" , "83%", "90%", "87%", "88%", "93%"};
        System.out.println(takeDownAverage(points));

        //Task 7
        //ошибка в условии
        System.out.println("Task 7");
        System.out.println(ceasarCipher("encode", "abcxyz", 1));

        //Task 8
        //ошибка в условии
        System.out.println("Task 8");
        System.out.println(setSetup(5, 3));

        //Task 9
        System.out.println("Task 9");
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));

        //Task 10
        System.out.println("Task 10");
        System.out.println(isNew(301));
    }

    //Task 1
    public static boolean sameLetterPattern(String s1, String s2){
        ArrayList<Integer> pattern = new ArrayList<>();
        for (int i = 0; i < s1.length() - 1; i++) {
            pattern.add(s1.charAt(i) - s1.charAt(i + 1));
        }
        for (int i = 0; i < s2.length() - 1; i++) {
            if(pattern.get(i) != s2.charAt(i) - s2.charAt(i + 1)) return false;
        }
        return true;
    }

    //Task 2
    public static String spiderVsFly(String coord1, String coord2){
        String ans = "";
        Character radial1 = coord1.charAt(0),
                radial2 = coord2.charAt(0);
        String ch1 = coord1.charAt(1) + "",
                ch2 = coord2.charAt(1) + "";
        Integer int1 = Integer.parseInt(ch1),
                int2 = Integer.parseInt(ch2);
        //На одном радиале
        if(radial1.equals(radial2)){
            while (int1 != int2){
                ans += radial1 + int1.toString() + "-";
                if(int2 < int1) int1--;
                else int1++;
            }
            ans += radial2 + int2.toString();
        }
        //Если один из них в начале
        else if(int1 == 0 || int2 == 0){
            if(int1 == 0){
                ans += "A0-";
                int1++;
                while (int1 < int2){
                    ans += radial2 + int1.toString() + "-";
                    int1++;
                }
                ans += radial2 + int2.toString();
            }
            else{
                ans += "A0-";
                int2++;
                while (int1 > int2){
                    ans += radial1 + int1.toString() + "-";
                    int1--;
                }
                ans += radial2 + int2.toString();
            }
        }
        //Если разница радиалов больше 2 (угол больше 90)
        else if (Math.abs(radial1 - radial2) > 2 && Math.abs(radial1 - radial2) < 6) {
            while (int1 > 0){
                ans += radial1 + int1.toString() + "-";
                int1--;
            }
            ans += "A0-";
            Integer temp = 1;
            while (temp < int2){
                ans += radial2 + temp.toString() + "-";
                temp++;
            }
            ans += radial2 + temp.toString();
        }
        //Если разница радиалов меньше равно 2 (угол меньше равно 90)
        else {
            while (int1 != int2){
                ans += radial1 + int1.toString() + "-";
                if(int2 < int1) int1--;
                else int1++;
            }
            ans += radial1 + int1.toString() + "-";
            //Проверка на соседа)
            if(Math.abs(radial1 - radial2) == 1 || Math.abs(radial1 - radial2) == 7){
                ans += radial2 + int2.toString();
            }
            else {
                if(Math.abs(radial2 - radial1) / 2 == 1) {
                    ans += (char) (radial1 + (radial2 - radial1) / 2) + int2.toString() + "-";
                    ans += radial2 + int2.toString();
                }
                else{
                    if(radial1.equals('A') || radial1.equals('G'))ans += 'H' + int2.toString() + "-";
                    else ans += 'A' + int2.toString() + "-";
                    ans += radial2 + int2.toString();
                }
            }
        }
        return ans;
    }

    //Task 3
    public static Integer digitsCount(Integer n){
        int ans = 0;
        if(n == 0)return ans;
        else {
            ans = 1 + digitsCount(n/10);
            return ans;
        }
    }

    //Task 4
    public static Integer totalPoints(String[] words, String answer){
        ArrayList<Character> list = new ArrayList<>();
        Integer ans = 0;
        for (int i = 0; i < answer.length(); i++) {
            list.add(answer.charAt(i));
        }
        for(String word : words){
            ArrayList<Character> charactersList = new ArrayList<>(list);
            Integer count = 0;
            boolean check = true;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if(charactersList.contains(c)){
                    charactersList.remove(c);
                    count++;
                }
                else {
                    check = false;
                    break;
                }
            }
            if(check){
                switch (count){
                    case 3:
                        ans += 1;
                        break;
                    case 4:
                        ans += 2;
                        break;
                    case 5:
                        ans += 3;
                        break;
                    case 6:
                        ans += 54;
                        break;
                }
            }
        }
        return ans;
    }

    //Task 5
    public static Integer[][] sumsUp(Integer[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer[]> ans = new ArrayList<>();
        for (Integer i : arr){
            list.add(i);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            Integer num1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Integer num2 = list.get(j);
                if(num1 + num2 == 8){
                    ans.add(new Integer[]{num1, num2});
                    list.remove(num1);
                    list.remove(num2);
                    i = -1;
                }
            }
        }
        Integer[][] ansArr = new Integer[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }

    //Task 6
    public static String takeDownAverage(String[] students){
        Double sum = 0.0, max = 0.0;
        for (int i = 0; i < students.length; i++) {
            String student = students[i];
            Integer tempE = 1, tempSum = 0;
            for (int j = student.length() - 2; j >= 0 ; j--) {
                String num = student.charAt(j) + "";
                tempSum += Integer.parseInt(num) * tempE;
                tempE *= 10;
            }
            sum += tempSum;
            max += 100;
        }
        int ans = 0;
        while (sum/max - (sum + ans)/(max + 100) > 0.051){
            ans++;
        }
        return Integer.toString(ans) + "%";
    }

    //Task 7
    public static String ceasarCipher(String option, String word, Integer shift){
        HashMap<Character, Integer> numberMap = new HashMap<>();
        numberMap.put('a', 0);
        numberMap.put('b', 1);
        numberMap.put('c', 2);
        numberMap.put('d', 3);
        numberMap.put('e', 4);
        numberMap.put('f', 5);
        numberMap.put('g', 6);
        numberMap.put('h', 7);
        numberMap.put('i', 8);
        numberMap.put('j', 9);
        numberMap.put('k', 10);
        numberMap.put('l', 11);
        numberMap.put('m', 12);
        numberMap.put('n', 13);
        numberMap.put('o', 14);
        numberMap.put('p', 15);
        numberMap.put('q', 16);
        numberMap.put('r', 17);
        numberMap.put('s', 18);
        numberMap.put('t', 19);
        numberMap.put('u', 20);
        numberMap.put('v', 21);
        numberMap.put('w', 22);
        numberMap.put('x', 23);
        numberMap.put('y', 24);
        numberMap.put('z', 25);
        String ans = "";
        Integer opt = -1;
        if(option.equals("encode")) opt = 1;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(c >= 97 && c <= 122) {
                Integer index = (26 + numberMap.get(c) + opt * shift) % 26;
                for (Map.Entry entry : numberMap.entrySet()) {
                    if (entry.getValue().equals(index)) {
                        String s = entry.getKey() + "";
                        ans += s.toUpperCase();
                        break;
                    }
                }
            }
            else ans += c;
        }
        return ans;
    }

    //Task 8
    public static Integer setSetup(Integer n, Integer k){
        int ans = 1;
        if(n < k)return ans;
        else {
            ans *= n * setSetup(n - 1, k);
            return ans;
        }
    }

    //Task 9
    public static String timeDifference(String city1, String timeString, String city2){
        HashMap<String, Integer> cityDiff = new HashMap<>();
        cityDiff.put("Los Angeles", -480);
        cityDiff.put("New York", -300);
        cityDiff.put("Caracas", -270);
        cityDiff.put("Buenos Aires", -180);
        cityDiff.put("London", 0);
        cityDiff.put("Rome", 60);
        cityDiff.put("Moscow", 180);
        cityDiff.put("Tehran", 210);
        cityDiff.put("New Delhi", 330);
        cityDiff.put("Beijing", 480);
        cityDiff.put("Canberra", 600);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.ENGLISH);
        Date date = new Date();
        try {
            date = dateFormat.parse(timeString);
        } catch (ParseException e) {
            System.out.println("Incorrect time format, type again");
        }
        Timestamp timestamp = new Timestamp(date.getTime());

        int minutesDiff = cityDiff.get(city2) - cityDiff.get(city1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.add(Calendar.MINUTE, minutesDiff);        Timestamp ansTimestamp = new Timestamp(calendar.getTimeInMillis());

        String ansFormat = ansTimestamp.toString(), ans = "";
        for (int i = 0; i < ansFormat.length() - 5; i++) {
            ans += ansFormat.charAt(i);
        }
        return ans;
    }

    //Task 10
    public static boolean isNew(Integer n) {
        if(n == 0) return true;
        String num = String.valueOf(n);
        char[] digits = num.toCharArray();
        Arrays.sort(digits);
        int i = 0;
        while (true){
            if(digits[i] != '0'){
                digits[0] = digits[i];
                if(i != 0) digits[i] = '0';
                break;
            }
            i++;
        }
        Integer sortedNum = Integer.parseInt(new String(digits));
        return (sortedNum.equals(n));
    }
}