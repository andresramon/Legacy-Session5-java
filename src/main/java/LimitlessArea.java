public class LimitlessArea implements Area {

    private Area area;

    public LimitlessArea(Area area) {
        this.area = area;
    }

    @Override
    public boolean isMovementAllowed(Position position, Orientation orientation) {
        return true;
    }
}
