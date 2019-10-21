package gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.messageexception;

public class MessageException {
    public static final String ERROR_ACCOUNT_DOES_NOT_EXIST = "Account with email:={ %S } does not exist";

    public static String createMessage(String message, String body) {
        return String.format(message, body);
    }
}
