import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    private void checkRoverMovementForGivenOrientationAndDirection(Position initialPosition, Position finalPosition, Orientation orientation,
            MovementDirection movementDirection) throws InvalidInstructionException {
        Rover rover = new Rover();
        rover.setOrientation(orientation);
        rover.setPosition(initialPosition);
        rover.setArea(new Area(5,5));

        rover.move(movementDirection);


        Assertions.assertEquals(finalPosition, rover.getPosition());
        Assertions.assertEquals(orientation, rover.getOrientation());
    }

    @Test
    public void roverShouldNotMoveOutOfBoundsOnTheSouth() {

        Rover rover = new Rover();
        rover.setPosition(new Position(0,0));
        rover.setOrientation(Orientation.S);
        rover.setArea(new Area(5,5));

        Assertions.assertThrows(InvalidInstructionException.class, () -> {
            rover.move(MovementDirection.A);
        });
    }

    @Test
    public void roverShouldNotMoveOutOfBoundsOnTheWest() {

        Rover rover = new Rover();
        rover.setPosition(new Position(0,0));
        rover.setOrientation(Orientation.O);
        rover.setArea(new Area(5,5));

        Assertions.assertThrows(InvalidInstructionException.class, () -> {
            rover.move(MovementDirection.A);
        });
    }

    @Test
    public void roverShouldNotMoveOutOfBoundsOnTheEast(){
        Rover rover = new Rover();
        rover.setPosition(new Position(4,0));
        rover.setOrientation(Orientation.E);
        rover.setArea(new Area(5,5));

        Assertions.assertThrows(InvalidInstructionException.class, () -> {
            rover.move(MovementDirection.A);
        });
    }

    @Test
    public void roverShouldNotMoveOutOfBoundsOnTheNorth() {
        Rover rover = new Rover();
        rover.setPosition(new Position(4,4));
        rover.setOrientation(Orientation.N);
        rover.setArea(new Area(5,5));

        Assertions.assertThrows(InvalidInstructionException.class, () -> {
            rover.move(MovementDirection.A);
        });
    }



}
