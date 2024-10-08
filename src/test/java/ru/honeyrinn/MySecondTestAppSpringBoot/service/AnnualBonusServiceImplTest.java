package ru.honeyrinn.MySecondTestAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnnualBonusServiceImplTest {

    @Test
    void calculate() {

        //given
        Positions positions = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        //when
        double result = new AnnualBonusServiceImpl().calculate(positions, salary, bonus, workDays);
        //then
        double expected = 360493.8271604938;
        double expected2 = 361;
        assertThat(result).isEqualTo(expected);
    }
}