package ru.honeyrinn.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.honeyrinn.MySecondTestAppSpringBoot.model.Request;

@Service
public interface ModifyRequestService {

    void modify(Request request);
}
