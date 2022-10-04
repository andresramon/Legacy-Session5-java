public class CommandFactory {

    static RoverCommand initializeCommand(String instruction, Rover rover) {

        switch (instruction) {
            case "A": return new MoveForwardCommand(rover);
            case "R": return new MoveBackwardCommand(rover);
            case "I": return new RotateLeftCommand(rover);
            case "D": return new RotateRightCommand(rover);
        }

        return null;

    }

}
