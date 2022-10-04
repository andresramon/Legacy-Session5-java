public class RotateRightCommand implements RoverCommand {

    private final Rover rover;

    public RotateRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        this.rover.rotate(Rotation.D);
    }
}
