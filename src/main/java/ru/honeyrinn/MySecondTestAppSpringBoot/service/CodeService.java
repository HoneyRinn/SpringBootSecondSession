package ru.honeyrinn.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.honeyrinn.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.honeyrinn.MySecondTestAppSpringBoot.model.Request;

@Service
public interface CodeService {

    void isValid(Request request, BindingResult bindingResult) throws UnsupportedCodeException;
}
