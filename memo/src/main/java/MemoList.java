import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MemoList {

    private List<Memo> memoList;

    public MemoList() {
        this.memoList = new ArrayList<>();
    }

    public void create() {

    }

    public void update() {

    }

    public void delete() {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("삭제하실 글의 번호를 입력해주십쇼. 해당 기능을 종료하시려면 0000를 눌러주시길바랍니다.");
            int idx0 = sc.nextInt();
            // 되돌아가기
            if (idx0 == 0000) {
                break;
            }
            // 삭제 구현
            int idx = idx0 - 1;
            if (memoList.contains(idx)) {
                System.out.println("해당 글의 비밀번호를 입력해주십쇼");
                int pw = sc.nextInt();
                Memo memoAction = getMemo(idx);
                if (memoAction.getPassword() == pw) { // 글의 비밀번호와 pw가 맞을 경우
                    memoList.remove(idx); // 글을 지운다
                    System.out.println("삭제가 완료되었습니다.");
                    for (int i = 0; i < memoList.size(); i++) { // 글의 인덱스를 하나씩 앞으로 끌어온다
                        Memo memoMove = getMemo(i); // memoMove라는 인스턴스를 생성
                        if (memoMove.getNumber() != i) { // memoMove의 Number와 i가 동일하지 않을경우
                            memoMove.setNumber(i); // memoMove의 Number를 다시 i로 지정해준다.
                        } else {
                            continue; // memoMove의 Number와 i가 동일할 경우 그냥 진행한다.
                        }
                    }
                } else {
                    System.out.println("비밀번호가 틀렸습니다. 처음부터 다시 진행해주십쇼");
                }
            } else {
                System.out.println("해당 글의 번호가 존재하지 않습니다.");
            }
        }
    }


    private Memo getMemo(int idx) {
        this.memoList = memoList;
        for (Memo memo : this.memoList) {
            if (memoList.contains(idx)) {
                return memo;

            }
        }
        return null;
    }

    public void showAll() {

    }
}
