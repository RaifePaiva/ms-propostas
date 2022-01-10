package br.com.zup.mspropostas.annotations;

import br.com.zup.mspropostas.annotations.impl.UniqueValueParamImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValueParamImpl.class)
public @interface UniqueValueParam {

    String message() default "O valor informado já existe em nossa base de dados.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();

}
