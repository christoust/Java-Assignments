import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<String> football = Arrays.asList("Messi","Ronaldo","Neymar","Messi");
        Map<String,List<String>> player = football.stream().collect(Collectors.groupingBy(e->e));
        System.out.println(player);
    }
}
