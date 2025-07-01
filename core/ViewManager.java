package core;

import javax.swing.*;
import java.util.HashMap;

public class ViewManager {
    private static final HashMap<String, JFrame> views = new HashMap<>();
    private static JFrame currentFrame;

    public static void register(String alias, JFrame view) {
        views.put(alias, view);
    }

    public static void show(String alias) {
        if (currentFrame != null) {
            currentFrame.setVisible(false);
        }
        JFrame frame = views.get(alias);
        if (frame != null) {
            currentFrame = frame;
            frame.setVisible(true);
        } else {
            System.out.println("❌ View alias not found: " + alias);
        }
    }
}
