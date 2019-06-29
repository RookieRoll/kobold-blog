package koboldblogweb.koboldblogweb.exceptions;

import koboldblogweb.koboldblogweb.viewmodel.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 28076
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse<?> defaultExceptionHandler(HttpServletRequest request,Exception ex){
        CommonResponse response=new CommonResponse(HttpStatus.INTERNAL_SERVER_ERROR,ex);
        response.setMessage(ex.getMessage());
        return response;
    }
}
