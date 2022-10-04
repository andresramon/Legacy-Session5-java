public class MoveBackwardCommand implements RoverCommand {

    private final Rover rover;

    public MoveBackwardCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() throws InvalidInstructionException {

        this.rover.move(MovementDirection.R);

    }
}
