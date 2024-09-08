package exception;


import lombok.Getter;
import lombok.Setter;

public enum ErrorCode {
    USER_NOT_FOUND(404, "Not Found User"),
    USER_NAME_EMPTY(400, "Name is empty"),
    USER_PASSWORD_EMPTY(400, "Password is empty"),
    USER_EMAIL_EMPTY(400, "Email is empty"),
    USER_EMAIL_EXIST(400, "Email Already Exist"),
    SQL_ERROR(500, "Sql error");
    @Getter
    private int code;
    @Getter
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }




}
