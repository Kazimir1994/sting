package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.constans.validation;

public final class ValidationConstants {
    public static final String regexpIp = "^(?=.*[^\\.]$)((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.?){4}$";
    public static final int MaxPort = 65535;
    public static final int MinPort = 0;

    private ValidationConstants() {
    }
}
