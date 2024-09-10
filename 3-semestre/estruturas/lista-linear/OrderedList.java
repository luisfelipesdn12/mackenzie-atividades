import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrderedList extends ArrayList<Gamer> {
    public boolean add(Gamer e) {
        super.add(e);
        this.sort((a, b) -> Integer.compare(b.score, a.score));
        return true;
    }

    public String toString() {
        return "\n[\n   " + this.stream()
            .map(Gamer::toString)
            .collect(Collectors.joining(",\n   ")) + "\n]\n";
    }
}
