public class RoverController {

    private Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
    }

    public String processCommand(String command) throws InvalidInstructionException {
        String[] roverCommand = command.split("\n");
        String[] areaSizeCoordinates = roverCommand[0].split(" ");
        String[] positionCoordinates = roverCommand[1].split(" ");

        this.rover.setArea(new Area(Integer.parseInt(areaSizeCoordinates[0]), Integer.parseInt(areaSizeCoordinates[1])));
        this.rover.setPosition(new Position(Integer.parseInt(positionCoordinates[0]), Integer.parseInt(positionCoordinates[1])));

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

}
