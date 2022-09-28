import java.util.EnumMap;
import java.util.Map;

public class Rover{

    private static final Map<Orientation, Orientation> directionLeftMap = new EnumMap<>(Orientation.class);
    private static final Map<Orientation, Orientation> directionRightMap = new EnumMap<>(Orientation.class);

    static{
        directionRightMap.put(Orientation.N, Orientation.E);
        directionRightMap.put(Orientation.E, Orientation.S);
        directionRightMap.put(Orientation.S, Orientation.O);
        directionRightMap.put(Orientation.O, Orientation.N);

        directionLeftMap.put(Orientation.N, Orientation.O);
        directionLeftMap.put(Orientation.O, Orientation.S);
        directionLeftMap.put(Orientation.S, Orientation.E);
        directionLeftMap.put(Orientation.E, Orientation.N);
    }

    private Orientation orientation;
    private Position position;
    private Area area;


    public void rotate(Rotation direction){

        if(direction == Rotation.I){
            orientation = directionLeftMap.get(orientation);
        }else if(direction == Rotation.D){
            orientation = directionRightMap.get(orientation);
        }
    }

    public void move(MovementDirection direction) throws InvalidInstructionException {

        if (direction == MovementDirection.R) {
            moveBackward();
        } else {
            moveForward();
        }

    }

    private void moveBackward() throws InvalidInstructionException {
        if (this.orientation == Orientation.E) {
            checkMovementAllowedTo(Orientation.O);
            this.position.moveWest();
        } else if (this.orientation == Orientation.S) {
            checkMovementAllowedTo(Orientation.N);
            this.position.moveNorth();
        } else if (this.orientation == Orientation.O) {
            checkMovementAllowedTo(Orientation.E);
            this.position.moveEast();
        } else {
            checkMovementAllowedTo(Orientation.S);
            this.position.moveSouth();
        }
    }

    private void moveForward() throws InvalidInstructionException {
        checkMovementAllowedTo(orientation);
        if (this.orientation == Orientation.E) {
            this.position.moveEast();
        } else if(this.orientation == Orientation.O) {
            this.position.moveWest();
        } else if(this.orientation == Orientation.S) {
            this.position.moveSouth();
        }  else {
            this.position.moveNorth();
        }
    }

    private void checkMovementAllowedTo(Orientation e) throws InvalidInstructionException {
        if (!this.area.isMovementAllowed(this.position, e)) {
            throw new InvalidInstructionException();
        }
    }

    public Orientation getOrientation(){

        return orientation;
    }

    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
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

    public String processCommand(String command) throws InvalidInstructionException{
        String[] roverCommand  = command.split("\n");
        String[] areaSizeCoordinates = roverCommand[0].split(" ");
        String[] positionCoordinates = roverCommand[1].split(" ");

        area = new Area(Integer.parseInt(areaSizeCoordinates[0]), Integer.parseInt(areaSizeCoordinates[1]));
        position = new Position(Integer.parseInt(positionCoordinates[0]), Integer.parseInt(positionCoordinates[1]));
        orientation = Orientation.valueOf(positionCoordinates[2]);

        for (String direction: roverCommand[2].split("")){
            if (direction.equals("A")){
                move(MovementDirection.valueOf(direction));
            }
            else if (direction.equals("D")){
                rotate(Rotation.valueOf(direction));
            }
        }

        return position.getX() + " " + position.getY() + " " + orientation;
    }
}
