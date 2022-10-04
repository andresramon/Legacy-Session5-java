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


    private void initializeState(Orientation orientation) {
        state = StateFactory.initializeState(orientation, this);
    }

    public Orientation getOrientation() {
        return state.getOrientation();
    }

    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + state.getOrientation();
    }
}
