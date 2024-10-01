package ru.honeyrinn.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.honeyrinn.MySecondTestAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {

    Response modify (Response response);
}
