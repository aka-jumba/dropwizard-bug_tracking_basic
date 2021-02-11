package in.dreamplug.userservice.exception;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sidhant.aggarwal
 * @since 12/01/2020
 */
public class AppExceptionMapper implements ExceptionMapper<AppException> {
    private static final Logger log = LoggerFactory.getLogger(AppExceptionMapper.class);

    public AppExceptionMapper() {
    }

    @Produces({"application/json"})
    public Response toResponse(AppException e) {
        Map<String, Object> response = new HashMap();
        response.put("error_code", e.getErrorCode());
        response.put("status_code", e.getStatusCode());
        response.put("header", e.getHeader());
        response.put("message", e.getMessage());
        response.put("information", e.getInformation());
        log.error("App Exception : {}", e.toString());
        return Response.status(e.getStatusCode()).entity(response).build();
    }
}
