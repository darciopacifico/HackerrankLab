package mountainpathway;

import java.util.Objects;

public class Pair {
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;

    public int getR() {
        return x;
    }

    public int getC() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return x == pair.x &&
                y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "[l:" + x + " c:" + y+"]";
    }
}
