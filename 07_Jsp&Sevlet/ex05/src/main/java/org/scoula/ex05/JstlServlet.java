package org.scoula.ex05;


import org.scoula.ex05.domain.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jstl_ex")
public class JstlServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Member member = new Member("홍길동_" + i, "hong_" + i);
            members.add(member);
        }
//          10명의 리스트 정보를 request scope에 속성 설정
        request.setAttribute("members", members);
        request.setAttribute("role", "ADMIN");

        String userid = request.getParameter("userid");

        HttpSession session = request.getSession();
        Member user = new Member("정예슬",userid);
        session.setAttribute("user", user);



        request.getRequestDispatcher("jstl_ex.jsp") .forward(request, response);
    }
}
