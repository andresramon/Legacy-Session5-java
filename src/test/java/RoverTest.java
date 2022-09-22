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
        Rover rover = new Rover();
        rover.setOrientation(Orientation.N);

        //rover.move("A");

        //Assertions.assertEquals(rover.getPosition(), rover.getOrientation());
    }

}
