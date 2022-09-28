public class NorthState implements State{
    private Rover rover;

    public NorthState(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void moveForward() throws InvalidInstructionException {
        rover.moveNorth();
    }

    @Override
    public void moveBackward() throws InvalidInstructionException {
        rover.moveSouth();
    }

    @Override
    public State rotate(Rotation direction) {
        if (direction == Rotation.I) {
            return new WestState(rover);
        }
        else {
            return new EastState(rover);
        }
    }
}
