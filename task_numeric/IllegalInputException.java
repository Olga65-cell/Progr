package task_numeric;

public class IllegalInputException extends Throwable {
    @Override
    public String getMessage() {
        return "Illegal input!";
    }
}
