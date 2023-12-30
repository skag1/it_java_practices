class Main {

    public static void main(String[] args) {
        System.out.println("Task 1:");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println();

        System.out.println("Task 2:");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println();

        System.out.println("Task 3:");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        System.out.println();

        System.out.println("Task 4:");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        System.out.println();

        System.out.println("Task 5:");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println();

        System.out.println("Task 6:");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));
        System.out.println();

        System.out.println("Task 7:");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println();

        System.out.println("Task 8:");
        System.out.println(gcd(48,18));
        System.out.println(gcd(52,8));
        System.out.println(gcd(259,28));
        System.out.println();

        System.out.println("Task 9:");
        System.out.println(ticketSaler(70,1500));
        System.out.println(ticketSaler(24,950));
        System.out.println(ticketSaler(53,1250));
        System.out.println();

        System.out.println("Task 10:");
        System.out.println(tables(5,2));
        System.out.println(tables(31,20));
        System.out.println(tables(123,58));
        System.out.println();

    }
    public static float convert(int amount){
        return amount * 3.785f;
    }

    public static int fitCalc(int fitnesTime, int intensity){
        return fitnesTime * intensity;
    }

    public static int containers(int boxes, int bags, int barrels){
        return boxes * 20 + bags * 50 + barrels * 100;
    }

    public static String triangleType(int x, int y, int z){
        String answer;
        if(x == y && y == z) answer = "isosceles";
        else if(x == y || x == z || y == z) answer = "equilateral";
        else if(x + y < z || x + z < y || y + z < x) answer = "not a triangle";
        else answer = "different-sided";
        return answer;
    }

    public static int ternaryEvaluation(int a, int b){
        return a > b ? a : b;
    }

    public static int howManyItems(int n, double w, double h){
        return (int)(n / 2 / (w * h));
    }

    public static int factorial(int x){
        int s = 1;
        for (int i = 2; i <= x; i++){
            s *= i;
        }
        return s;
    }

    public static int gcd(int a, int b) {
        int ans = 1;
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) ans = i;
        }
        return ans;
    }

    public static int ticketSaler(int a, int b) {
        return (int)(a * b * 0.72f);
    }

    public static int tables(int a, int b) {
        if(a - b * 2 > 0) {
            return (a - b * 2) / 2 + (a - b * 2) % 2;
        }
        else  return 0;
    }
}