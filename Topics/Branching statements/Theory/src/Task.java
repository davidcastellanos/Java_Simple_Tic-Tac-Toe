// You can experiment here, it won’t be checked

import java.util.Scanner;

public class Task {
  public static void main(String[] args) {
    // put your code here
    Scanner scanner = new Scanner(System.in);

    int num = scanner.nextInt();
    int count = 0;

    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= i; j++) {
        if (count == num) {
          break;
        }
        count++;
        System.out.print(i + " ");
      }
    }
  }
}
