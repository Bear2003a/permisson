package exception;

import lombok.Getter;

public enum SuccessCode {

    GET_SUCCESS(200, "Success"),
    CREATE_SUCCESS(201, "Create success");

    @Getter
    private int code;
    @Getter
    private String message;

    SuccessCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
