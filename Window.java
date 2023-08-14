import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends ResquetAPI {
    private JFrame frame = new JFrame("Window");
    private JPanel mainPanel = new JPanel(new GridBagLayout());;

    private GridBagConstraints gridBC = new GridBagConstraints();

    private String[] methods = { "POST", "GET", "PUT", "DELETE" };

    Window() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 700);
    }

    public JPanel setPanel(JPanel panel, int rows, int columns) {
        return panel = new JPanel(new GridLayout(rows, columns));
    }

    private void selectMethod() {
        // Pré config do novo item grid adicionado
        gridBC.gridx = 0;
        gridBC.gridy = 0;
        gridBC.fill = GridBagConstraints.HORIZONTAL;
        gridBC.weightx = 1.0;

        JPanel requestPanel = new JPanel();
        requestPanel.setLayout(new BoxLayout(requestPanel, BoxLayout.X_AXIS));

        JComboBox<String> options = new JComboBox<>(methods);
        requestPanel.add(options);

        JTextField urlAPI = new JTextField(null, "URL", 0);

        requestPanel.add(urlAPI);

        JButton requestButton = new JButton("Send");
        requestPanel.add(requestButton);

        requestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) options.getSelectedItem();

                request(urlAPI.getText(), selected);
            }
        });

        mainPanel.add(requestPanel, gridBC);
    }

    private void statusBar(int status) {
        gridBC.gridx = 1;
        gridBC.gridy = 0;
        gridBC.fill = GridBagConstraints.NONE;

        JPanel statusPanel = new JPanel();

        JLabel statusLabel = new JLabel("Any");
        statusPanel.add(statusLabel);

        if (status == 400) {
            statusLabel.setText(status + "Bad request");
        }

        mainPanel.add(statusLabel, gridBC);
    }

    private void consoleData() {
        gridBC.gridx = 1;
        gridBC.gridy = 1;

        JLabel data = new JLabel();

        mainPanel.add(data, gridBC);
    }

    public void start() {

        gridBC.gridx = 0;

        selectMethod();
        statusBar(0);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }
}
