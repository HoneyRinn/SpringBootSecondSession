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
    private String uid;

    @NotBlank
    private String operationUid;

    @NotBlank
    private String systemTime;

    @NotBlank
    private Codes code;

    @NotBlank
    private ErrorCodes errorCode;

    @NotBlank
    private ErrorMessages errorMessage;
}
