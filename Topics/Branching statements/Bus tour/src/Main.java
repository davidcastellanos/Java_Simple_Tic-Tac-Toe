import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int busHeight = scanner.nextInt();
        int numberOfBridges = scanner.nextInt();

        int bridgesHeights;
        String output = "Will not crash";

        for (int i = 1; i <= numberOfBridges; i++) {

            bridgesHeights = scanner.nextInt();

            if (bridgesHeights <= busHeight) {
                output = "Will crash on bridge " + i;
                break;
            }
        }
        System.out.println(output);

    }
}




