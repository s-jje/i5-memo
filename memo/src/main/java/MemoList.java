import java.util.List;

public class MemoList {

    private List<Memo> memoList;

    public MemoList(List<Memo> memoList) {
        this.memoList = memoList;
    }

    public void create() {

    }

    public void update() {

    }

    public void delete() {

    }

    public void showAll() {

    }

    public Memo getMemo(int memoNumber) {
        int size = this.memoList.size();
        for (Memo memo : this.memoList) {
            if (memoNumber == memo.getNumber()) {
                return memo;
            }
        }
        return null;
    }
}
