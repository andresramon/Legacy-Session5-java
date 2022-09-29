public class StateFactory {


    static State initializeState(Orientation orientation, Rover rover) {

        switch (orientation) {
            case N:
                return new NorthState(rover);
            case S:
                return new SouthState(rover);
            case E:
                return new EastState(rover);
            case O:
                return new WestState(rover);
        }
        return null;
    }
}
