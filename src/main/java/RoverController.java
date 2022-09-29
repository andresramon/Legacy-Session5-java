public class RoverController {

    private Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
    }

    public String processCommand(String command) throws InvalidInstructionException {
        String[] roverCommand = command.split("\n");
        String[] areaSizeCoordinates = roverCommand[0].split(" ");
        String[] positionCoordinates = roverCommand[1].split(" ");

        this.rover.setArea(new Area(getXSize(areaSizeCoordinates), getYSize(areaSizeCoordinates)));
        this.rover.setPosition(new Position(getXCoordinate(positionCoordinates), getYCoordinate(positionCoordinates)));
        this.rover.setOrientation(Orientation.valueOf(positionCoordinates[2]));

        for (String direction : roverCommand[2].split("")) {
            if (direction.equals("A") || direction.equals("R")) {
                this.rover.move(MovementDirection.valueOf(direction));
            } else if (direction.equals("D") || direction.equals("I")) {
                this.rover.rotate(Rotation.valueOf(direction));
            }
        }

        return rover.toString();
    }

    private int getYCoordinate(String[] positionCoordinates) {
        return Integer.parseInt(positionCoordinates[1]);
    }

    private int getXCoordinate(String[] positionCoordinates) {
        return Integer.parseInt(positionCoordinates[0]);
    }

    private int getYSize(String[] areaSizeCoordinates) {
        return Integer.parseInt(areaSizeCoordinates[1]);
    }

    private int getXSize(String[] areaSizeCoordinates) {
        return Integer.parseInt(areaSizeCoordinates[0]);
    }

}
