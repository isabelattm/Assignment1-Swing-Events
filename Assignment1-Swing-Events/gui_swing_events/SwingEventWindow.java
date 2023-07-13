package gui_swing_events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SwingEventWindow extends JFrame implements ActionListener {
    private int rdoChecked = 1;
    private JPanel mainPanel;
    private JLabel lblMain, lblRequest, lblResult;
    private JRadioButton rdoTotal, rdoAverage, rdoMax, rdoMin;
    private JButton calculateButton;
    private JTextField txtInput;
    private JTextField txtOutput;

    public SwingEventWindow() {
        setTitle("Swing Events");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        createGUI();
        attachEvents();

        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void createGUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        lblMain = new JLabel("Excel Functions");
        lblMain.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblRequest = new JLabel("Enter your numbers separated by commas:");
        lblRequest.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtInput = new JTextField(20);
        txtInput.setAlignmentX(Component.CENTER_ALIGNMENT);

        rdoTotal = new JRadioButton("Total");
        rdoAverage = new JRadioButton("Average");
        rdoMax = new JRadioButton("Maximum");
        rdoMin = new JRadioButton("Minimum");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdoTotal);
        buttonGroup.add(rdoAverage);
        buttonGroup.add(rdoMax);
        buttonGroup.add(rdoMin);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(1, 4));
        radioPanel.add(rdoTotal);
        radioPanel.add(rdoAverage);
        radioPanel.add(rdoMax);
        radioPanel.add(rdoMin);
        radioPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        calculateButton = new JButton("Calculate");
        calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblResult = new JLabel("Result:");
        lblResult.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtOutput = new JTextField(20);
        txtOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(lblMain);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(lblRequest);
        mainPanel.add(txtInput);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(radioPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(calculateButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(lblResult);
        mainPanel.add(scrollPane);

        add(mainPanel);
    }

    private void attachEvents() {
        calculateButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            String input = txtInput.getText();
            Excel excel = new Excel(input);

            if (rdoTotal.isSelected()) {
                double total = excel.calculateTotal();
                txtOutput.setText(String.format("Total: %.2f", total));
            } else if (rdoAverage.isSelected()) {
                double average = excel.calculateAverage();
                txtOutput.setText(String.format("Average: %.2f", average));
            } else if (rdoMax.isSelected()) {
                double maximum = excel.calculateMaximum();
                txtOutput.setText(String.format("Maximum: %.2f", maximum));
            } else if (rdoMin.isSelected()) {
                double minimum = excel.calculateMinimum();
                txtOutput.setText(String.format("Minimum: %.2f", minimum));
            }
        }
    }
}




    

