public class EastState implements State {
    private Rover rover;
    private final Orientation orientation = Orientation.E;

    public EastState(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void moveForward() throws InvalidInstructionException {
        rover.moveEast();
    }

    @Override
    public void moveBackward() throws InvalidInstructionException {
        rover.moveWest();
    }

    @Override
    public State rotate(Rotation direction) {
        if (direction == Rotation.I) {
            return new NorthState(rover);
        } else {
            return new SouthState(rover);
        }
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

}
