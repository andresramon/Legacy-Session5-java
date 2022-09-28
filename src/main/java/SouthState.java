public class SouthState implements State{
    private Rover rover;

    public SouthState(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void moveForward() throws InvalidInstructionException {
        rover.moveSouth();
    }

    @Override
    public void moveBackward() throws InvalidInstructionException {
        rover.moveNorth();
    }

    @Override
    public State rotate(Rotation direction) {
        if (direction == Rotation.I) {
            return new EastState(rover);
        }
        else {
            return new WestState(rover);
        }
    }

}
