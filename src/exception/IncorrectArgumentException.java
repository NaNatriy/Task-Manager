package exception;

public class IncorrectArgumentException extends RuntimeException{
    private String argument;

    public IncorrectArgumentException(String argument){
        super(argument);
    }

    public String getArgument() {
        return argument;
    }
}
