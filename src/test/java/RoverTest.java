import com.sun.glass.ui.Screen;
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
    public void whenOrientationIsNorthAndCommandIsAThenCoordinateYShouldBeIncreasedInOne(){
        Position position = new Position(0,0);
        Rover rover = new Rover();
        rover.setOrientation(Orientation.N);
        rover.setPosition(position);

        rover.move(MovementDirection.A);

        Position finalPosition = new Position(0,1);

        Assertions.assertEquals(finalPosition, rover.getPosition());
        Assertions.assertEquals(Orientation.N, rover.getOrientation());
    }

    @Test
    public void whenOrientationIsNorthAndCommandIsRThenCoordinateYShouldBeDecreasedInOne(){
        Position position = new Position(0,1);
        Rover rover = new Rover();
        rover.setOrientation(Orientation.N);
        rover.setPosition(position);

        rover.move(MovementDirection.R);

        Position finalPosition = new Position(0,0);

        Assertions.assertEquals(finalPosition, rover.getPosition());
        Assertions.assertEquals(Orientation.N, rover.getOrientation());
    }

}
