import java.util.Objects;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveNorth(int steps) {
        this.y += steps;
    }

    public void moveSouth(int steps) {
        this.y -= steps;
    }

    public void moveEast(int steps) {
        this.x += steps;
    }

    public void moveWest(int steps) {
        this.x -= steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
