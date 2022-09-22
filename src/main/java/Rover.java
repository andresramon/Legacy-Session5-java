public class Rover{

    private String orientation;

    public void rotate(String direction){

        if(direction.equals("I")){

            if(orientation.equals("N")){
                orientation = "O";
            }else if(orientation.equals("O")){
                orientation = "S";
            }else if(orientation.equals("S")){
                orientation = "E";
            }else if(orientation.equals("E")){
                orientation = "N";
            }
        }else if(direction.equals("D")){
            if(orientation.equals("N")){
                orientation = "E";
            }else if(orientation.equals("E")){
                orientation = "S";
            }else if(orientation.equals("S")){
                orientation = "O";
            }else if(orientation.equals("O")){
                orientation = "N";
            }
        }

    }

    public String getOrientation(){

        return orientation;
    }

    public void setOrientation(String orientation){
        this.orientation = orientation;
    }
}
