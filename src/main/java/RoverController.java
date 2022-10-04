public class RoverController {

    private Rover rover;
    private boolean isLimitless;

    public RoverController(Rover rover, boolean isLimitless) {
        this.rover = rover;
        this.isLimitless = isLimitless;
    }

    public String processCommand(String command) throws InvalidInstructionException {
        String[] roverCommand = command.split("\n");
        String[] areaSizeCoordinates = roverCommand[0].split(" ");
        String[] positionCoordinates = roverCommand[1].split(" ");

        Area area = new LimitedArea(getXSize(areaSizeCoordinates), getYSize(areaSizeCoordinates));
        if (isLimitless) {
            area = new LimitlessArea(area);
        }
        this.rover.setArea(area);
        this.rover.setPosition(new Position(getXCoordinate(positionCoordinates), getYCoordinate(positionCoordinates)));
        this.rover.setOrientation(Orientation.valueOf(positionCoordinates[2]));

        for (String direction : roverCommand[2].split("")) {
            CommandFactory.initializeCommand(direction, this.rover).execute();
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
