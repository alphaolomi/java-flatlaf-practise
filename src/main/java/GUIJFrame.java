import javax.swing.*;

public class GUIJFrame extends JFrame {//inheriting JFrame
    JFrame jFrame;

    GUIJFrame() {
        JButton jButton = new JButton("click");//create button
        jButton.setBounds(130, 100, 100, 40);

        add(jButton);//adding button on frame
        setSize(400, 500);
        setLayout(null);
        setVisible(true);
    }
}