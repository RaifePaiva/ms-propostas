package br.com.zup.mspropostas.annotations.impl;

import br.com.zup.mspropostas.annotations.UniqueValueParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueParamImpl implements ConstraintValidator<UniqueValueParam, String> {

    @PersistenceContext
    private EntityManager entityManager;

    private String atributo;

    private Class<?> dClass;

    @Override
    public void initialize(UniqueValueParam parametro) {
        atributo = parametro.fieldName();
        dClass = parametro.domainClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("select 1 from "+dClass.getName()+" where " + atributo + "=:value");
        query.setParameter("value", value);

        List<?> list = query.getResultList();
        return list.isEmpty();
    }

}
