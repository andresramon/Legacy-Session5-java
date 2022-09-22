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

}
