import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RoverTest{

    @Test
    public void whenOrientationIsNorthAndCommandIsIThenOrientationShouldBeWest(){
        Rover rover = new Rover();
        rover.setOrientation(Orientation.N);

        rover.rotate(Rotation.I);

        Assertions.assertEquals(Orientation.O, rover.getOrientation());
    }

    @Test
    public void whenOrientationIsWestAndCommandIsIThenOrientationShouldBeSouth(){
        Rover rover = new Rover();
        rover.setOrientation(Orientation.O);

        rover.rotate(Rotation.I);

        Assertions.assertEquals(Orientation.S, rover.getOrientation());
    }

    @Test
    public void whenOrientationIsSouthAndCommandIsIThenOrientationShouldBeEast(){
        Rover rover = new Rover();
        rover.setOrientation(Orientation.S);

        rover.rotate(Rotation.I);

        Assertions.assertEquals(Orientation.E, rover.getOrientation());
    }

    @Test
    public void whenOrientationIsEastAndCommandIsIThenOrientationShouldBeNorth(){
        Rover rover = new Rover();
        rover.setOrientation(Orientation.E);

        rover.rotate(Rotation.I);

        Assertions.assertEquals(Orientation.N, rover.getOrientation());
    }

    @Test
    public void whenOrientationIsNorthAndCommandIsDThenOrientationShouldBeEast(){
        Rover rover = new Rover();
        rover.setOrientation(Orientation.N);

        rover.rotate(Rotation.D);

        Assertions.assertEquals(Orientation.E, rover.getOrientation());
    }

    @Test
    public void whenOrientationIsEastAndCommandIsDThenOrientationShouldBeSouth(){
        Rover rover = new Rover();
        rover.setOrientation(Orientation.E);

        rover.rotate(Rotation.D);

        Assertions.assertEquals(Orientation.S, rover.getOrientation());
    }

    @Test
    public void whenOrientationIsSouthAndCommandIsDThenOrientationShouldBeWest(){
        Rover rover = new Rover();
        rover.setOrientation(Orientation.S);

        rover.rotate(Rotation.D);

        Assertions.assertEquals(Orientation.O, rover.getOrientation());
    }

    @Test
    public void whenOrientationIsWestAndCommandIsDThenOrientationShouldBeNorth(){
        Rover rover = new Rover();
        rover.setOrientation(Orientation.O);

        rover.rotate(Rotation.D);

        Assertions.assertEquals(Orientation.N, rover.getOrientation());
    }

    @Test
    public void whenOrientationIsNorthAndCommandIsAThenCoordinateYShouldBeIncreasedInOne()
            throws InvalidInstructionException {
        Position initialposition = new Position(0, 0);
        Position finalPosition = new Position(0, 1);
        Orientation orientation = Orientation.N;
        MovementDirection movementDirection = MovementDirection.A;
        checkRoverMovementForGivenOrientationAndDirection(initialposition, finalPosition, orientation, movementDirection);
    }

    @Test
    public void whenOrientationIsNorthAndCommandIsRThenCoordinateYShouldBeDecreasedInOne()
            throws InvalidInstructionException {
        Position initialPosition = new Position(0, 1);
        Position finalPosition = new Position(0, 0);
        Orientation orientation = Orientation.N;
        MovementDirection movementDirection = MovementDirection.R;
        checkRoverMovementForGivenOrientationAndDirection(initialPosition, finalPosition, orientation, movementDirection);
    }

    @Test
    public void whenOrientationIsEastAndCommandIsAThenCoordinateXShouldBeIncreasedInOne()
            throws InvalidInstructionException {
        Position initialPosition = new Position(0, 0);
        Position finalPosition = new Position(1, 0);
        Orientation orientation = Orientation.E;
        MovementDirection movementDirection = MovementDirection.A;
        checkRoverMovementForGivenOrientationAndDirection(initialPosition, finalPosition, orientation, movementDirection);
    }

    @Test
    public void whenOrientationIsSouthAndCommandIsAThenCoordinateYShouldBeDecreasedInOne()
            throws InvalidInstructionException {
        Position initialPosition = new Position(0, 1);
        Position finalPosition = new Position(0, 0);
        Orientation orientation = Orientation.S;
        MovementDirection movementDirection = MovementDirection.A;
        checkRoverMovementForGivenOrientationAndDirection(initialPosition, finalPosition, orientation, movementDirection);
    }

    @Test
    public void whenOrientationIsWestAndCommandIsAThenCoordinateXShouldBeDecreasedInOne()
            throws InvalidInstructionException {
        Position initialPosition = new Position(1, 0);
        Position finalPosition = new Position(0, 0);
        Orientation orientation = Orientation.O;
        MovementDirection movementDirection = MovementDirection.A;
        checkRoverMovementForGivenOrientationAndDirection(initialPosition, finalPosition, orientation, movementDirection);
    }

    @Test
    public void whenOrientationIsEastAndCommandIsRThenCoordinateXShouldBeDecreasedInOne()
            throws InvalidInstructionException {
        Position initialPosition = new Position(1, 0);
        Position finalPosition = new Position(0, 0);
        Orientation orientation = Orientation.E;
        MovementDirection movementDirection = MovementDirection.R;
        checkRoverMovementForGivenOrientationAndDirection(initialPosition, finalPosition, orientation, movementDirection);
    }

    @Test
    public void whenOrientationIsSouthAndCommandIsRThenCoordinateYShouldBeIncreasedInOne()
            throws InvalidInstructionException {
        Position initialPosition = new Position(0, 0);
        Position finalPosition = new Position(0, 1);
        Orientation orientation = Orientation.S;
        MovementDirection movementDirection = MovementDirection.R;
        checkRoverMovementForGivenOrientationAndDirection(initialPosition, finalPosition, orientation, movementDirection);
    }

    @Test
    public void whenOrientationIsWestAndCommandIsRThenCoordinateXShouldBeIncreasedInOne()
            throws InvalidInstructionException {
        Position initialPosition = new Position(0, 0);
        Position finalPosition = new Position(1, 0);
        Orientation orientation = Orientation.O;
        MovementDirection movementDirection = MovementDirection.R;
        checkRoverMovementForGivenOrientationAndDirection(initialPosition, finalPosition, orientation, movementDirection);
    }

    @ParameterizedTest
    @MethodSource("illegalMovements")
    public void roverShouldNotMoveOutOfBounds(MovementDirection direction,Orientation orientation, Position position) {
        Rover rover = new Rover();
        rover.setPosition(position);
        rover.setOrientation(orientation);
        rover.setArea(new LimitedArea(5,5));

        Assertions.assertThrows(InvalidInstructionException.class, () -> {
            rover.move(direction);
        });
    }
    @Test
    public void roverShouldNotMoveOutOfBounds() throws InvalidInstructionException {
        Rover rover = new Rover();
        RoverController  controller = new RoverController(rover, false);
        String command = "5 5\n4 4 N\nA";

        Assertions.assertThrows(InvalidInstructionException.class, () -> {
            controller.processCommand(command);
        });
    }

    @Test
    public void roverShouldMoveOutOfBounds() throws InvalidInstructionException {
        Rover rover = new Rover();
        RoverController  controller = new RoverController(rover, true);
        String command = "5 5\n4 4 N\nA";
        String position = controller.processCommand(command);

        Assertions.assertEquals( "4 5 N", position);
    }


    @ParameterizedTest
    @MethodSource("roverCommandsToProcess")
    public void whenRoverReceiveACommandShouldProcessIt(String command, String expectedPosition) throws InvalidInstructionException{
        Rover rover = new Rover();
        RoverController controller = new RoverController(rover, false);
        String positionAndOrientation = controller.processCommand(command);

        Assertions.assertEquals(expectedPosition, positionAndOrientation);
    }


    private static Stream<Arguments> illegalMovements()
    {
        return Stream.of(
                Arguments.of(MovementDirection.A,Orientation.N, new Position(4,4)),
                Arguments.of(MovementDirection.R,Orientation.S, new Position(4,4)),
                Arguments.of(MovementDirection.A, Orientation.S, new Position(0,0)),
                Arguments.of(MovementDirection.R, Orientation.N, new Position(0,0)),
                Arguments.of(MovementDirection.A, Orientation.O, new Position(0,0)),
                Arguments.of(MovementDirection.A, Orientation.E, new Position(4,4)),
                Arguments.of(MovementDirection.R, Orientation.E, new Position(0,0)),
                Arguments.of(MovementDirection.R, Orientation.O, new Position(4,4))
        );
    }

    private  static  Stream<Arguments> roverCommandsToProcess(){
        return Stream.of(
                Arguments.of("5 5\n0 1 N\nA\n", "0 2 N"),
                Arguments.of("5 5\n0 1 N\nAD\n", "0 2 E"),
                Arguments.of("5 5\n0 1 N\nAI\n", "0 2 O"),
                Arguments.of("5 5\n0 1 N\nR\n", "0 0 N")
        );
    }

    private void checkRoverMovementForGivenOrientationAndDirection(Position initialPosition, Position finalPosition, Orientation orientation,
            MovementDirection movementDirection) throws InvalidInstructionException {
        Rover rover = new Rover();
        rover.setOrientation(orientation);
        rover.setPosition(initialPosition);
        rover.setArea(new LimitedArea(5,5));

        rover.move(movementDirection);


        Assertions.assertEquals(finalPosition, rover.getPosition());
        Assertions.assertEquals(orientation, rover.getOrientation());
    }

}
