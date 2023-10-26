package com.example.visao.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.visao.constraints.NomeCursoConstraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NomeCursoConstraint.class)
public @interface NomeCursoValidation {
    String message() default "Nome Fora do Padrão";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}
