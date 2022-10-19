import javax.swing.*;
import java.awt.*;

public class Window extends Canvas{
    public Window(int width, int height, String title, Main main){
        JFrame jFrame = new JFrame(title);

        jFrame.setPreferredSize(new Dimension(width, height));
        jFrame.setMaximumSize(new Dimension(width, height));
        jFrame.setMinimumSize(new Dimension(width, height));

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(true);
        jFrame.setFocusable(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(main);
        jFrame.setVisible(true);
        main.start();
    }
}
