package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    ServletContext sc;

//    설정에 있는 application scope를 sc에 할당해서 초기화해준다
    @Override
    public void init (ServletConfig config) throws ServletException {
        sc = config.getServletContext();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        application scop에 속성 설정
        sc.setAttribute("scopeName", "applicationScope 값"); // Application Scope

//        현재 세션을 가져오거나 존재하지 않으면 새로 생성
        HttpSession session = request.getSession(); // Session Scope
//        Session Scope에 속성 설정
        session.setAttribute("scopeName", "sessionScope 값");

//        Request Scope에 속성 설정
        request.setAttribute("scopeName", "requestScope 값"); // Request Scope

        Member member = new Member ("홍길동", "hong");
        request.setAttribute("member", member);

//        scope.jsp화면 포워딩
        request.getRequestDispatcher("scope.jsp").forward(request, response);
    }
}