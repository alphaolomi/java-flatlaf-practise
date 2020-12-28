import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

public class MainApp {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        // create UI here...
        GUIJFrame frame = new GUIJFrame();
        frame.setTitle("Campus IT Asset Manager");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
