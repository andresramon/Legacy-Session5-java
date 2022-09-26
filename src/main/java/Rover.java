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

    public void rotate(Rotation direction){

        if(direction == Rotation.I){
            orientation = directionLeftMap.get(orientation);
        }else if(direction == Rotation.D){
            orientation = directionRightMap.get(orientation);
        }
    }

    public void move(MovementDirection direction) {

        if (direction == MovementDirection.R) {
            moveBackward();
        } else {
            moveForward();
        }

    }

    private void moveBackward() {
        if (this.orientation == Orientation.E) {
            this.position.moveWest(1);
        } else if (this.orientation == Orientation.S) {
            this.position.moveNorth(1);
        } else if (this.orientation == Orientation.O) {
            this.position.moveEast(1);
        } else {
            this.position.moveSouth(1);
        }
    }

    private void moveForward() {
        if (this.orientation == Orientation.E) {
            this.position.moveEast(1);
        } else if(this.orientation == Orientation.O) {
            this.position.moveWest(1);
        } else if(this.orientation == Orientation.S) {
            this.position.moveSouth(1);
        }  else {
            this.position.moveNorth(1);
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


}
