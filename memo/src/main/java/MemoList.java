import java.util.List;
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
            String idx0 = sc.next();
            if (idx0 == "0000"){
                break;
            }
            int idx = Integer.parseInt(idx0);
            if (memoList.contains(idx)) {
                System.out.println("해당 글의 비밀번호를 입력해주십쇼");
                int pw = sc.nextInt();
                Memo memoAction = getMemo(idx);
                if (memoAction.getPassword() == pw) {
                    memoList.remove(idx);
                    System.out.println("삭제가 완료되었습니다.");
                }
                else {
                    System.out.println("비밀번호가 틀렸습니다. 처음부터 다시 진행해주십쇼");
                }
            }
            else{
                System.out.println("해당 글의 번호가 존재하지 않습니다.");
            }
        }
    }

    public void showAll() {

    }
}
