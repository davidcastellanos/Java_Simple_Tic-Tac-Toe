import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int previous = 0;
        int mid = 0;
        int current;

        boolean result = true;

        while (true) {
            current = scanner.nextInt();

            if (current == 0 && mid != 0) {
                break;
            }


            if (previous != 0 && mid != 0) {
                if (previous <= mid && mid <= current || previous >= mid && mid >= current) {
                    result = true;

                } else {
                    result = false;
                    break;
                }
            }

            previous = mid;
            mid = current;

        }
        System.out.println(result);
    }
}