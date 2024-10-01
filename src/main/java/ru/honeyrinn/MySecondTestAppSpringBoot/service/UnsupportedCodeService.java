package ru.honeyrinn.MySecondTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.honeyrinn.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.honeyrinn.MySecondTestAppSpringBoot.model.Request;

@Slf4j
@Service
public class UnsupportedCodeService implements CodeService{

    @Override
    public void isValid(Request request, BindingResult bindingResult) throws UnsupportedCodeException {
        if(request.getUid().equals("123")) {
            log.error("Ошибка в Uid");
            throw new UnsupportedCodeException(bindingResult.getFieldError().toString());
        }
    }
}
