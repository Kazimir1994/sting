package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidationErrorResponse {
    private List<Violation> violations = new ArrayList<>();

    public List<Violation> getViolations() {
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }

    public void add(Violation violation) {
        violations.add(violation);
    }

    @Override
    public String toString() {
        return "ValidationErrorResponse{" +
                "violations=" + violations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidationErrorResponse that = (ValidationErrorResponse) o;
        return Objects.equals(violations, that.violations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(violations);
    }
}
