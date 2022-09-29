public class WestState implements State{
    private Rover rover;
    private final Orientation orientation = Orientation.O;

    public WestState(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void moveForward() throws InvalidInstructionException {
        rover.moveWest();
    }

    @Override
    public void moveBackward() throws InvalidInstructionException {
        rover.moveEast();
    }

    @Override
    public State rotate(Rotation direction) {
        if (direction == Rotation.I) {
            return new SouthState(rover);
        }
        else {
            return new NorthState(rover);
        }
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }
}
