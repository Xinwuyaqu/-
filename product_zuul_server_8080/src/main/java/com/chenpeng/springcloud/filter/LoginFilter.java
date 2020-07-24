package com.chenpeng.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    /*
    * 表示过滤器的类型
    *  pre：前置过滤
    *  routing：在路由器请求调用时过滤
    *  post：在error和routing之后调用
    *  error：处理请求时发生错误调用
    * */
    @Override
    public String filterType() {
        return "pre";
    }

    /*
    * 代表过滤器执行的顺序
    * 数字越小执行顺序越靠前
    * */
    @Override
    public int filterOrder() {
        return 1;
    }

    /*
    * 表示过滤器是否生效
    * true：生效
    * false：不生效
    * */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /*
    * 过滤器执行的方法
    *  登录验证，只有登录时返回的token=admin时才能成功访问
    *  否则无效
    *    需要在访问时网址后添加
    *       ?token=admin
    * */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest ctxRequest = ctx.getRequest();
        String token = ctxRequest.getParameter("token");
        if(!("admin".equals(token.trim()))){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }

        return null;
    }
}
