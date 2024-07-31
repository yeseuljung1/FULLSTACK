//package org.scoula.ex05;
//
//import org.scoula.ex05.domain.Member;
//import org.scoula.ex05.dto.LoginDTO;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet("/login")
//public class LogoutServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
////        getParameter 내에 있는 이름은 input 의 name과 같은지 확인할것
//        String userid = request.getParameter("userid");
//        String passwd = request.getParameter("passwd");
//
//        LoginDTO loginDTO = new LoginDTO(userid, passwd);
////위에서 만들어진 변수 정보를 request 내에 세팅한다
//        request.setAttribute("userid", userid);
//        request.setAttribute("passwd", passwd);
////설정한 request를 login.jsp로 보내서 화면을 띄워준다
//        request.setAttribute("login", loginDTO)  ;
//
//        HttpSession session = request.getSession();
//        Member member = new Member("홍길동",userid);
//        request.setAttribute("member", member);
//
//        request.getRequestDispatcher("login.jsp").forward (request, response);
//    }
//}
