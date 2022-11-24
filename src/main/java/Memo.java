public class Memo implements Comparable<Memo> {

    private int number;
    private String name;
    private String password;
    private String content;
    private String date;

    public Memo(int number, String name, String password, String content, String date) {
        this.number = number;
        this.name = name;
        this.password = password;
        this.content = content;
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(Memo memo) {
        return this.date.compareTo(memo.date);
    }
}
