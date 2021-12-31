import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String input = scanner.next().toLowerCase();
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            output += input.charAt(i) == 'a' ? 'b' : input.charAt(i);
        }

        System.out.print(output);
    }
}