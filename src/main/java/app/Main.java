package app;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import controller.Controller;
import javax.swing.UIManager;

public class Main {
    static void main() {
        initComponents();
    }
    static void initComponents() {
        FlatDarkPurpleIJTheme.setup();
        UIManager.put("Button.arc", 30);
        Controller controller = new Controller();
        controller.initialize();
    }
}
