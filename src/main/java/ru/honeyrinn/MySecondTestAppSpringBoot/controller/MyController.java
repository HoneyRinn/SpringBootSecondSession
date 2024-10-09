package ru.honeyrinn.MySecondTestAppSpringBoot.controller;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.honeyrinn.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.honeyrinn.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.honeyrinn.MySecondTestAppSpringBoot.model.Request;
import ru.honeyrinn.MySecondTestAppSpringBoot.model.Response;
import ru.honeyrinn.MySecondTestAppSpringBoot.service.CodeService;
import ru.honeyrinn.MySecondTestAppSpringBoot.service.ModifyRequestService;
import ru.honeyrinn.MySecondTestAppSpringBoot.service.ModifyResponseService;
import ru.honeyrinn.MySecondTestAppSpringBoot.service.ValidationService;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.Codes;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.DateTimeUtil;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.ErrorCodes;
import ru.honeyrinn.MySecondTestAppSpringBoot.util.ErrorMessages;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final CodeService codeService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;

    @Autowired
    public MyController(ValidationService validationService,
                        CodeService codeService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifySystemTimeRequestService") ModifyRequestService modifyRequestService) {
        this.validationService = validationService;
        this.codeService = codeService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult){


        log.info("request: {}", request);

        Response response = createDefaultResponse(request);

        try{
            codeService.isValid(request, bindingResult);
            validationService.isValid(bindingResult);
        } catch (UnsupportedCodeException e) {
            return handleException(response, Codes.FAILED, ErrorCodes.UNSUPPORTED_EXCEPTION, ErrorMessages.UNSUPPORTED, HttpStatus.BAD_REQUEST);
        } catch (ValidationFailedException e) {
            return handleException(response, Codes.FAILED, ErrorCodes.VALIDATION_EXCEPTION, ErrorMessages.VALIDATION, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return handleException(response, Codes.FAILED, ErrorCodes.UNKNOWN_EXCEPTION, ErrorMessages.UNKNOWN, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //modifyRequestService.modify(request);
        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
    }

    private Response createDefaultResponse(Request request) {
        return Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
    }

    private ResponseEntity<Response> handleException(Response response, Codes code, ErrorCodes errorCode, ErrorMessages errorMessage, HttpStatus status) {
        response.setCode(code);
        response.setErrorCode(errorCode);
        response.setErrorMessage(errorMessage);
        log.error("response: {}", response);
        return new ResponseEntity<>(response, status);
    }
}
