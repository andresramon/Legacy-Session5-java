public interface State {
    void moveForward() throws InvalidInstructionException;
    void moveBackward() throws InvalidInstructionException;

    State rotate(Rotation direction);
}
