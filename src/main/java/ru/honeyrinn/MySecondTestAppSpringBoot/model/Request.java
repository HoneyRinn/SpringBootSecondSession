package ru.honeyrinn.MySecondTestAppSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.Positions;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.Systems;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @NotBlank
    @Max(32)
    private String uid; //Уникальный идентификатор сообщения

    @NotBlank
    @Max(32)
    private String operationUid; //Уникальный идентификатор операции

    private Systems systemName; //Имя системы отправителя

    @NotBlank
    private String systemTime; //Время создания сообщения

    private String source; //Наименование ресурса

    private Positions positions; //Должность
    private Boolean isManager; //Проверка на управленческую должность
    private Double salary; //Зарплата
    private Double bonus; //Премия
    private Integer workDays; //Количество отработанных дней за год

    @Min(1)
    @Max(100000)
    private int communicationId; //Уникальный идентификатор ресурса

    private int templateId; //Уникальный идентификатор шаблона
    private int productCode; //Код продукта
    private int smsCode; //Смс код

    @Override
    public String toString(){
        return "{"+
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }
}
