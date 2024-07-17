package ui;

public class Menu {
    MenuItem[] menus;
    public Menu(int size) {
        menus = new MenuItem[size];
    }
    // 메뉴 항목 주입
    public void add(int ix, MenuItem item) {
        menus[ix] = item;
    }
    public void printMenu() {
        System.out.println("--------------------------------------------------------------");
        for(int i = 0; i < menus.length; i++) {
//            menus[i]는 MenuItem의 객체이므로 title만 가져와서 출력
            System.out.printf(" %d.%s | ", i+1, menus[i].getTitle());
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");
    }
    public Command getSelect() {
        int selectNo = Input.getInt("선택> ");
// 올바른 범위 인지 체크
//        index로 접근해야 되기 떄문에 -1을 해줌
//        menus에서 MenuItem 객체 하나를 접근해서 Command만 가져온다
        return menus[selectNo-1].getCommand();
    }
}
