package org.scoula.frontcontroller;

import org.scoula.frontcontroller.command.Command;
import org.scoula.frontcontroller.controller.HomeController;
import org.scoula.frontcontroller.controller.TodoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet {
    Map<String, Command> getMap; //get 요청이 들어왔을 경우 사용할 맵
    Map<String, Command> postMap; //post 요청이 들어왔을 경우 사용 할 맵

    //    뷰의 기본 경로와 확자아자를 설정해준다
    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";

    HomeController homeController = new HomeController();
    TodoController todoController = new TodoController();

    //    서블릿 초기화 메소드
    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();
     createMap(getMap,postMap)
    }
    protected void createMap (Map<String, Command> getMap, Map<String, Command> postMap) {
    }

    public void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        실행결과는 jsp의 이름으로 받아옴
        String viewName = command.execute(request, response);
        if(viewName.startsWith("redirect:")) { // redirect 처리
            response.sendRedirect (viewName.substring("redirect:".length()));
        } else { // forward 처리
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }

    //get요청을 처리하는 메소드
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Command command = getCommand(request);
        if (command != null) {
            execute(command,request,response);
        } else {
            //없는 페이지일 경우 404에러 처리
            String view = prefix +"404"+suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    private String getCommandName(HttpServletRequest request) {
        String requestURI = request.getRequestURI(); //"/context값/식별값"
        String contextPath = request.getContextPath();
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand (HttpServletRequest request) {
//        request에서 commamd 이름만 추출
        String commandName = getCommandName (request);
        Command command;

//        equalsIgnoreCase("GET") : "get"이라는 단어와 대소문자 구분 없이 비교
//        request에서 받아온 메소드가 get 이면 getMap에서 커맨드 찾기
        if(request.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
//        request에서 받아온 메소드가 post 이면 postMap에서 커맨드 찾기

            command = postMap.get(commandName);
        }
        return command;
    }
}
