import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends ResquetAPI {
    private JFrame frame;
    private JPanel mainPanel;

    private GridBagConstraints gridBC;

    private String[] methods = { "POST", "GET", "PUT", "DELETE" };

    private JTextArea consoleText;
    private JScrollPane scrollPane;
    private JLabel status;

    Window() {
        frame = new JFrame("Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 700);

        mainPanel = new JPanel(new GridBagLayout());

        consoleText = new JTextArea(20, 50);
        consoleText.setEditable(false);

        scrollPane = new JScrollPane(consoleText);

        status = new JLabel("Undefined");

        gridBC = new GridBagConstraints();
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

        JTextField urlAPI = new JTextField(null, "https://pokeapi.co/api/v2/pokemon/ditto", 0);

        requestPanel.add(urlAPI);

        JButton requestButton = new JButton("Send");
        requestPanel.add(requestButton);

        requestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) options.getSelectedItem();

                String data = request(urlAPI.getText(), selected);

                requestData(data);
            }
        });

        mainPanel.add(requestPanel, gridBC);
    }

    private void panelStatusBar() {
        gridBC.gridx = 1;
        gridBC.gridy = 0;
        gridBC.fill = GridBagConstraints.NONE;

        JPanel statusPanel = new JPanel();

        statusPanel.add(status);

        mainPanel.add(status, gridBC);

        gridBC.gridx = 1;
        gridBC.gridy = 1;

        mainPanel.add(consoleText, gridBC);
    }

    private void requestData(String request) {
        System.out.println(request);

        consoleText.setText(request);
        status.setText("" + requestStatus);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void start() {
        selectMethod();
        panelStatusBar();

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(mainPanel);

        frame.pack();

        frame.setVisible(true);
    }
}
