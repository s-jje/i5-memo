import java.util.List;
import java.util.LinkedList;

public class MemoList {

    private List<Memo> memoList;

    public MemoList() {
        this.memoList = new LinkedList<>();
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
        if (0 < memoNumber && memoNumber <= this.memoList.size()) {
            for (Memo memo : this.memoList) {
                if (memoNumber == memo.getNumber()) {
                    return memo;
                }
            }
        }
        return null;
    }
}
