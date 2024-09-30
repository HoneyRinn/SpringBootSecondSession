package ru.honeyrinn.MySecondTestAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;

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
    private String code;

    @NotBlank
    private String errorCode;

    @NotBlank
    private String errorMessage;
}
