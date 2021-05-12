package br.com.zupacademy.halinecosta.casadocodigo.criaCliente;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zupacademy.halinecosta.casadocodigo.ExistValueValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = CpfCnpjValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface CpfCnpjValue {
    String message() default "{CPF ou CNPJ inválido }";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
