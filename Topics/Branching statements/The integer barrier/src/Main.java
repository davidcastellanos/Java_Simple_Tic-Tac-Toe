import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int num;
        int limit = 1000;
        int sum = 0;

        while (scanner.hasNext()) {
            num = scanner.nextInt();
            sum += num;
            if (num == 0) {
                System.out.println(sum);
                break;
            } else if (sum >= limit) {
                System.out.println(sum - limit);
                break;
            }
        }


    }
}