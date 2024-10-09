package ru.honeyrinn.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.DateTimeUtil;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.Positions;

import java.time.Year;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService{

    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {

        int year = Year.now().getValue();
        double result = salary * bonus * positions.getPositionCoefficient() / workDays;
        if (year % 4 == 0 && year % 400 == 0) return result * 366;
        else return result * 365;
    }
}