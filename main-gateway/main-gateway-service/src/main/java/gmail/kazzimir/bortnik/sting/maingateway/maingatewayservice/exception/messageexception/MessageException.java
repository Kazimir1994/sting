package gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.exception.messageexception;

public class MessageException {
    public static final String ERROR_ROUTES_NOT_EXIST = "There are no routes in the database";

    public static String createMessage(String message, String body) {
        return String.format(message, body);
    }
}
