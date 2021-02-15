package in.dreamplug.userservice.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor (access = AccessLevel.PRIVATE)
public enum BugError {
    bug_not_found(AppException.builder().message("Bug not found.").header("Bug not found").statusCode(404));

    private AppException.AppExceptionBuilder builder;

    public AppException.AppExceptionBuilder getBuilder() {
        return builder.errorCode(this.name());
    }
}
