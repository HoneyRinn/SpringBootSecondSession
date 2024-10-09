package ru.honeyrinn.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.Positions;

@Service
public interface QuarterlyBonusService {
    double calculate(Boolean isManager, double salary, int workDays);
}
