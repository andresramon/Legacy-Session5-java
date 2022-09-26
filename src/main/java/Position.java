import java.util.Objects;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveNorth() {
        this.y += 1;
    }

    public void moveSouth() throws InvalidInstructionException {
        if (this.y == 0) {
            throw new InvalidInstructionException();
        }
        this.y -= 1;
    }

    public void moveEast() {
        this.x += 1;
    }

    public void moveWest() throws InvalidInstructionException {
        if (x == 0) {
            throw new InvalidInstructionException();
        }
        this.x -= 1;
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
