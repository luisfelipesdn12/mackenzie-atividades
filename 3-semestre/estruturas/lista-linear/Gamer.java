/**
 * Gamer
 */
public class Gamer {
    String name;
    int score;

    @Override
    public String toString() {
        return "Gamer [name=" + name + ", score=" + score + "]";
    }

    public Gamer(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
}