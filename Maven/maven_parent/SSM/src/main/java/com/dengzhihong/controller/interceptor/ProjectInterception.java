package com.dengzhihong.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringMVC拦截器：
 * - 作用：
 *   1. 在指定的方法调用前后执行预先设定的代码
 *   2. 阻止原始方法的执行
 *   3. 总结：增强
 *  -核心原理：AOP思想
 */

//受SpringMVC容器管理
@Component

public class ProjectInterception implements HandlerInterceptor {

    /**
     *原始方法调用前执行的内容
     *返回值类型可以拦截控制的执行，true放行，false终止
     * handler:被调用的处理器对象，本质上是一个方法对象，对反射技术中的Method对象进行了再包装
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("----------preHandle1");
        return true;
    }

    /**
     * 原始方法调用后执行的内容:
     * 注意：如果处理器方法出现异常了，该方法不会执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("----------postHandle1");
    }

    /**
     *原始方法调用完成后执行的内容:
     * 注意：无论处理器方法内部是否出现异常，该方法都会执行。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("----------afterCompletion1");
    }
}
