package com.dengzhihong.controller;

import com.dengzhihong.exception.BusinessException;
import com.dengzhihong.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @RestControllerAdvice用于标识当前类为REST风格对应的异常处理器。
 * 说明：此注解自带@ResponseBody注解与@Component注解，具备对应的功能
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

    /**
     * 系统异常
     * 作用：设置指定异常的处理方案，功能等同于控制器方法，出现异常后终止原始控制器执行，并转入当前方法执行。
     * 说明：此类方法可以根据处理的异常不同，制作多个方法分别处理对应的异常。
     */
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }


    /**
     *除了自定义的其他异常处理器
     */
    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后再试！");
    }
}
