package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.constans.validation;

public final class ValidationConstants {
    public static final String REGEX_IP = "^(?=.*[^\\.]$)((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.?){4}$";
    public static final int MAX_PORT = 65535;
    public static final int MIN_PORT = 0;

    private ValidationConstants() {
    }
}
