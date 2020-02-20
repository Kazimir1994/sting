package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain;

public enum ValidationResultNodeMessageEnum {
    NULL("IP cannot be null"),
    NOT_MATCH("IP does not match pattern"),
    NONEXISTENT_PORT("The specified port cannot exist"),
    IP_ADDRESS_NOT_AVAILABLE("IP address not available");
    private String message;

    ValidationResultNodeMessageEnum(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
