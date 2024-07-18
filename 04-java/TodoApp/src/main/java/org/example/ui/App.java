package org.example.ui;

package org.scoula.lib.cli;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.command.ExitCommand;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;

public abstract class App {
    Menu menu;

    public App() {

    }

    public void init(){
        menu=new Menu();
        createMenu(menu);
//        모든 앱에 동일하게 들어갈 수 있는 종료 메뉴만 따로 빼둠
        menu.add(new MenuItem("종료",new ExitCommand()));
    }

    public void createMenu(Menu menu){

    }

    public void run() {
        init();
        while(true) {
            try {
                menu.printMenu();
                Command command = menu.getSelect();
                command.execute();
            } catch (Exception e) {
                e.printStackTrace();
// System.out.println("에러: " + e.getMessage());
            }
        }
    }
}

