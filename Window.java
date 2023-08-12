import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {
    public void start() {
        // Window
        JFrame frame = new JFrame("Janela");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(200, 200);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        JTextField text = new JTextField(20);
        mainPanel.add(text);

        JButton button = new JButton("Submit");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status();
            }
        });

        mainPanel.add(button);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void status() {
        System.out.println("Status");
    }

}
