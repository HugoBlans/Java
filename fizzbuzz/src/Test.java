public class Test {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (i%5 == 0) {
                System.out.print("Fizz");
            }
            if (i%7 == 0 || i%10 == 7) {
                System.out.print("Buzz");
            }

            if (!(i%5 == 0)&&!(i%7 == 0)) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }
}
