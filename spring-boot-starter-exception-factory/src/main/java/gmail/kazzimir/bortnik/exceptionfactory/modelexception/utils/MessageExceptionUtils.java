package gmail.kazzimir.bortnik.exceptionfactory.modelexception.utils;

public class MessageExceptionUtils {
    public static String createMessage(String message, String body) {
        return String.format(message, body);
    }
}
