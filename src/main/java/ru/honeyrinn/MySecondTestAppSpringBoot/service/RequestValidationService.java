package ru.honeyrinn.MySecondTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.honeyrinn.MySecondTestAppSpringBoot.exception.ValidationFailedException;

@Slf4j
@Service
public class RequestValidationService implements ValidationService{
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if(bindingResult.hasErrors()){
            log.error("ошибка в bidingResult");
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
}
