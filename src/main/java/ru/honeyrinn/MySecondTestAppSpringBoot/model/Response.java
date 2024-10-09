package ru.honeyrinn.MySecondTestAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.Codes;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.ErrorCodes;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.ErrorMessages;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class Response {

    @NotBlank
    private String uid; //Уникальный идентификатор сообщения

    @NotBlank
    private String operationUid; //Уникальный идентификатор операции

    @NotBlank
    private String systemTime; //Время создания сообщения

    @NotBlank
    private Codes code; //Код сообщения

    @NotBlank
    private Double annualBonus; //Ежегодня премия

    @NotBlank
    private ErrorCodes errorCode; //Наименование ошибка

    @NotBlank
    private ErrorMessages errorMessage; //Сообщение об ошибке
}
