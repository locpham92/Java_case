import manage.ManageStaff;
import menu.MenuHome;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static ManageStaff menuStaff = new ManageStaff();
    static MenuHome menuHome = new MenuHome();
    public static void main(String[] args) {
        menuHome.login();
    }
}