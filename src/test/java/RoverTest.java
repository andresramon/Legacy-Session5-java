import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoverTest{

    @Test
    public void whenOrientationIsNorthAndCommandIsIThenOrientationShouldBeWest(){
        Rover rover = new Rover();
        rover.setOrientation("N");

        rover.rotate("I");

        Assertions.assertEquals("O", rover.getOrientation());
    }

    @Test
    public void whenOrientationIsWestAndCommandIsIThenOrientationShouldBeSouth(){
        Rover rover = new Rover();
        rover.setOrientation("O");

        rover.rotate("I");

        Assertions.assertEquals("S", rover.getOrientation());
    }

    @Test
    public void whenOrientationIsSouthAndCommandIsIThenOrientationShouldBeEast(){
        Rover rover = new Rover();
        rover.setOrientation("S");

        rover.rotate("I");

        Assertions.assertEquals("E", rover.getOrientation());
    }

    @Test
    public void whenOrientationIsEastAndCommandIsIThenOrientationShouldBeNorth(){
        Rover rover = new Rover();
        rover.setOrientation("E");

        rover.rotate("I");

        Assertions.assertEquals("N", rover.getOrientation());
    }

    @Test
    public void whenOrientationIsNorthAndCommandIsDThenOrientationShouldBeEast(){
        Rover rover = new Rover();
        rover.setOrientation("N");

        rover.rotate("D");

        Assertions.assertEquals("E", rover.getOrientation());
    }

    @Test
    public void whenOrientationIsEastAndCommandIsDThenOrientationShouldBeSouth(){
        Rover rover = new Rover();
        rover.setOrientation("E");

        rover.rotate("D");

        Assertions.assertEquals("S", rover.getOrientation());
    }

    @Test
    public void whenOrientationIsSouthAndCommandIsDThenOrientationShouldBeWest(){
        Rover rover = new Rover();
        rover.setOrientation("S");

        rover.rotate("D");

        Assertions.assertEquals("O", rover.getOrientation());
    }

    @Test
    public void whenOrientationIsWestAndCommandIsDThenOrientationShouldBeNorth(){
        Rover rover = new Rover();
        rover.setOrientation("O");

        rover.rotate("D");

        Assertions.assertEquals("N", rover.getOrientation());
    }


}
