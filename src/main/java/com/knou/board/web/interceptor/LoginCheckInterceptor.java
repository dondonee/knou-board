package com.knou.board.web.interceptor;

import com.knou.board.web.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();  // 로그인 이전 페이지
        HttpSession session = request.getSession();

        // 미인증 사용자 -> 로그인 페이지로 이동
        if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            session.setAttribute(SessionConst.PREV_URL, requestURI);
            response.sendRedirect("/login");
            return false;
        }

        // 인증된 사용자 -> 요청 처리 진행
        return true;
    }
}
