package in.dreamplug.userservice.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author sidhant.aggarwal
 * @since 28/05/19
 */
@Getter
@AllArgsConstructor (access = AccessLevel.PRIVATE)
public enum Error {
    user_not_found(AppException.builder().message("User not found.").header("User not found").statusCode(404));

    private AppException.AppExceptionBuilder builder;

    public AppException.AppExceptionBuilder getBuilder() {
        return builder.errorCode(this.name());
    }
}
