package com.baichen.exception;

import com.baichen.pojo.JsonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date: 2019-10-04 23:24
 * @Author: baichen
 * @Description Ajax 请求 异常捕获
 */
public class AjaxExceptionHandler {
    /**
     * //    @ExceptionHandler(value = Exception.class)
     */
    public JsonResult defaultErrorHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());
    }
}
