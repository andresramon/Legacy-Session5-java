import java.util.EnumMap;
import java.util.Map;

public class Rover {

    private Position position;
    private Area area;
    private State state;


    public void rotate(Rotation direction) {
        this.state = this.state.rotate(direction);
    }

    public void move(MovementDirection direction) throws InvalidInstructionException {

        if (direction == MovementDirection.R) {
            this.state.moveBackward();
        } else {
            this.state.moveForward();
        }

    }

    public void moveSouth() throws InvalidInstructionException {
        checkMovementAllowedTo(Orientation.S);
        this.position.moveSouth();
    }

    public void moveEast() throws InvalidInstructionException {
        checkMovementAllowedTo(Orientation.E);
        this.position.moveEast();
    }

    public void moveNorth() throws InvalidInstructionException {
        checkMovementAllowedTo(Orientation.N);
        this.position.moveNorth();
    }

    public void moveWest() throws InvalidInstructionException {
        checkMovementAllowedTo(Orientation.O);
        this.position.moveWest();
    }

    private void checkMovementAllowedTo(Orientation e) throws InvalidInstructionException {
        if (!this.area.isMovementAllowed(this.position, e)) {
            throw new InvalidInstructionException();
        }
    }

    public void setOrientation(Orientation orientation) {
        initializeState(orientation);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String processCommand(String command) throws InvalidInstructionException {
        String[] roverCommand = command.split("\n");
        String[] areaSizeCoordinates = roverCommand[0].split(" ");
        String[] positionCoordinates = roverCommand[1].split(" ");

        area = new Area(Integer.parseInt(areaSizeCoordinates[0]), Integer.parseInt(areaSizeCoordinates[1]));
        position = new Position(Integer.parseInt(positionCoordinates[0]), Integer.parseInt(positionCoordinates[1]));

        initializeState(Orientation.valueOf(positionCoordinates[2]));

        for (String direction : roverCommand[2].split("")) {
            if (direction.equals("A") || direction.equals("R")) {
                move(MovementDirection.valueOf(direction));
            } else if (direction.equals("D") || direction.equals("I")) {
                rotate(Rotation.valueOf(direction));
            }
        }

        return position.getX() + " " + position.getY() + " " + this.state.getOrientation();
    }

    private void initializeState(Orientation orientation) {
        switch (orientation) {
            case N:
                state = new NorthState(this);
                break;
            case S:
                state = new SouthState(this);
                break;
            case E:
                state = new EastState(this);
                break;
            case O:
                state = new WestState(this);
                break;
        }
    }

    public Orientation getOrientation() {
        return state.getOrientation();
    }
}
