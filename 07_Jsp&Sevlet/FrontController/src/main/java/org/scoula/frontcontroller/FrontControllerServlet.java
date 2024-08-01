package org.scoula.frontcontroller;

import org.scoula.frontcontroller.command.Command;
import org.scoula.frontcontroller.controller.HomeController;
import org.scoula.frontcontroller.controller.TodoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//경로 지정하는 방법으 두가지 있다 1)디렉토리 기반 2)확장명 기반
//디렉토리 기반(/board), 확장명 기반(*.do)

@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet extends DispatcherServlet {
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
//        "/"경로로 접근하면 homeController의 getindex 메소드를 찾을 수 있다(메소드 참조)
//        put으로 Map에 아이템을 넣어준다
        getMap.put("/",homeController::getIndex);
        getMap.put("/todo/list",todoController::getList);
        getMap.put("/todo/view",todoController::getView);
        getMap.put("/todo/create",todoController::getCreate);

        postMap.put("/todo/create",todoController::postCreate);
        postMap.put("/todo/update",todoController::postUpdate);
        postMap.put("/todo/delete",todoController::postDelete);
    }
}
