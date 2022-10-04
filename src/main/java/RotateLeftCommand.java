public class RotateLeftCommand implements RoverCommand {

    private final Rover rover;

    public RotateLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        this.rover.rotate(Rotation.I);
    }
}
