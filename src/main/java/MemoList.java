import java.util.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MemoList {

    private final List<Memo> memoList;

    public MemoList() {
        this.memoList = new ArrayList<>();
    }

    public void create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter the content: ");
        String content = scanner.nextLine();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = dateTimeFormatter.format(ZonedDateTime.now());

        this.memoList.add(new Memo(getNewMemoNumber(), name, password, content, date));
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the memo number: ");

        int memoNumber = Integer.parseInt(scanner.nextLine());
        Memo memo = getMemo(memoNumber);

        System.out.print("Enter your password: ");
        String inputPassword = scanner.nextLine();
        if (inputPassword.equals(memo.getPassword())) {
            System.out.print("Enter the content: ");
            String inputContent = scanner.nextLine();
            memo.setContent(inputContent);

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            memo.setDate(dateTimeFormatter.format(ZonedDateTime.now()));
        } else {
            System.out.println("Incorrect password.");
        }
    }

    public void delete() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("삭제하실 글의 번호를 입력해주십쇼. 해당 기능을 종료하시려면 0000를 눌러주시길바랍니다.");
            String input = sc.nextLine();

            if (input.equals("0000")) {
                break;
            }

            int memoNumber = Integer.parseInt(input);
            Memo memo = getMemo(Integer.parseInt(input));
            System.out.println("해당 글의 비밀번호를 입력해주십쇼");
            String pw = sc.nextLine();

            if (memo.getPassword().equals(pw)) {
                memoList.remove(memoNumber - 1);
                System.out.println("삭제가 완료되었습니다.");
                int len = this.memoList.size();
                for (int i = 0; i < len; i++) {
                    if (this.memoList.get(i).getNumber() - 1 != i) {
                        this.memoList.get(i).setNumber(i + 1);
                    }
                }
                break;
            } else {
                System.out.println("비밀번호가 틀렸습니다. 처음부터 다시 진행해주십쇼");
            }
        }
    }

    public void showAll() {
        List<Memo> sortedByDate = new ArrayList<>(this.memoList);
        int size = sortedByDate.size();

        if (size == 0) {
            System.out.println("Memo is empty.%n");
        }

        Collections.sort(sortedByDate);

        for (int i = size - 1; i >= 0; i--) {
            Memo memo = sortedByDate.get(i);
            System.out.println("=============================================");
            System.out.printf("| No.%3d | by %7s | %19s |%n", memo.getNumber(), memo.getName(), memo.getDate());
            System.out.println("---------------------------------------------");

            String content = memo.getContent();
            int len = memo.getContent().length();
            int width = 41;

            for (int j = 0; j < len; j += width) {
                System.out.printf("| %-41s |%n", content.substring(j, Math.min(j + width, len)));
            }

            if (i == 0) {
                System.out.println("=============================================");
            }
        }
    }

    private Memo getMemo(int memoNumber) {
        if (0 < memoNumber && memoNumber <= this.memoList.size()) {
            for (Memo memo : this.memoList) {
                if (memoNumber == memo.getNumber()) {
                    return memo;
                }
            }
        }
        throw new RuntimeException("Not exists.");
    }

    private int getNewMemoNumber() {
        return this.memoList.size() + 1;
    }
}
