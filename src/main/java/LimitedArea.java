public class LimitedArea implements Area {

    private final int limitX;
    private final int limitY;

    public LimitedArea(int xSize, int ySize) {
        this.limitX = xSize - 1;
        this.limitY = ySize - 1;
    }

    @Override
    public boolean isMovementAllowed(Position position, Orientation orientation) {
        if (Orientation.E == orientation) {
            return (position.getX()) != limitX;
        } else if (Orientation.S == orientation) {
            return (position.getY()) != 0;
        } else if (Orientation.O == orientation) {
            return position.getX() != 0;
        } else if (Orientation.N == orientation) {
            return position.getY() != limitY;
        }
        return true;
    }

}
