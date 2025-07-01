import core.ViewManager;
import views.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView login = new LoginView();
        ViewManager.register("login", login);
        ViewManager.show("login");
    }
}
