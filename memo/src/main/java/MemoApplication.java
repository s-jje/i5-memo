import java.util.Scanner;

public class MemoApplication {

    public static void main(String[] args) {
        MemoList memoList = new MemoList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Memo!");
        do {
            System.out.println("================");
            System.out.println("|     Menu     |");
            System.out.println("================");
            System.out.println("| 1. Create    |");
            System.out.println("| 2. Show all  |");
            System.out.println("| 3. Update    |");
            System.out.println("| 4. Delete    |");
            System.out.println("| 5. Exit      |");
            System.out.println("================");
            System.out.println("Please enter a number from 1 to 5.");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                memoList.create();
            } else if (input.equals("2")) {
                memoList.showAll();
            } else if (input.equals("3")) {
                memoList.update();
            } else if (input.equals("4")) {
                memoList.delete();
            } else if (input.equals("5")) {
                break;
            } else {
                System.out.println("Invalid input.");
                System.out.println("Please enter a number from 1 to 5.");
            }
        } while (true);

        scanner.close();
    }
}
