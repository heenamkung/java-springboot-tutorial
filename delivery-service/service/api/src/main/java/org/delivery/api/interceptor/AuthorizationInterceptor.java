package org.delivery.api.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Authorization interceptor URL: {} ", request.getRequestURL());

        //WEB, chrome 의 경우 GET, POST 전에 OPTION으로 지원하는지 체크하는 api가 있음. 통과(pass) 시켜줌
        if(HttpMethod.OPTIONS.matches(request.getMethod())){
            return true;
        }

        //js, html, png resource를 요청하는 경우 pass
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        // TODO: Header 검증

        return true;

    }
}
