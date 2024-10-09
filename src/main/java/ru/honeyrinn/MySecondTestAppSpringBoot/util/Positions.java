package ru.honeyrinn.MySecondTestAppSpringBoot.util;

import lombok.Getter;

@Getter
public enum Positions {

    DEV(2.2),
    HR(1.2),
    SA(1.6),
    UT(2.0),
    DEVOPS(1.8),
    TL(2.6);

    private final double positionCoefficient;

    Positions(double positionCoefficient) {
        this.positionCoefficient = positionCoefficient;
    }
}
