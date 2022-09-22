import java.util.HashMap;
import java.util.Map;

public class Rover{

    private Orientation orientation;
    private Map<Orientation, Orientation> directionLeftMap = new HashMap<Orientation, Orientation>(){{
       put(Orientation.N, Orientation.O);
       put(Orientation.O, Orientation.S);
       put(Orientation.S, Orientation.E);
       put(Orientation.E, Orientation.N);
    }};

    private Map<Orientation, Orientation> directionRightMap = new HashMap<Orientation, Orientation>(){{
        put(Orientation.N, Orientation.E);
        put(Orientation.E, Orientation.S);
        put(Orientation.S, Orientation.O);
        put(Orientation.O, Orientation.N);
    }};

    public void rotate(String direction){

        if(direction.equals("I")){
            orientation = directionLeftMap.get(orientation);
        }else if(direction.equals("D")){
            orientation = directionRightMap.get(orientation);
        }
    }

    public Orientation getOrientation(){

        return orientation;
    }

    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }
}
