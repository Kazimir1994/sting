package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.annotation;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.annotation.constraint.IpInstanceValidatorConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IpInstanceValidatorConstraint.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IpInstanceValidator {
    String message() default "Ip format is not valid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}