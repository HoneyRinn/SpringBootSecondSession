package ru.honeyrinn.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.honeyrinn.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.honeyrinn.MySecondTestAppSpringBoot.model.Request;

@Service
public class UnsupportedCodeService implements CodeService{

    @Override
    public void isValid(Request request, BindingResult bindingResult) throws UnsupportedCodeException {
        if(request.getUid().equals("123")) throw new UnsupportedCodeException(bindingResult.getFieldError().toString());
    }
}
