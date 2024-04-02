import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationExceptionExample {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        for (String elem : list) {
            if (elem.equals("a")) {
                list.remove(elem);
            }
        }

    }
}
