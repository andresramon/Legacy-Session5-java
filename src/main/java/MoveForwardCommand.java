public class MoveForwardCommand implements RoverCommand {

    private final Rover rover;

    public MoveForwardCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() throws InvalidInstructionException {
        this.rover.move(MovementDirection.A);
    }
}
