import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JTextField amountField;
    private JTextField percentField;
    private JLabel resultLabel;

    public Calculator() {
        JFrame frame = new JFrame("Financial Calculator App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel amountLabel = new JLabel("Сума:");
        amountLabel.setBounds(10, 20, 80, 25);
        panel.add(amountLabel);

        amountField = new JTextField(20);
        amountField.setBounds(100, 20, 165, 25);
        panel.add(amountField);

        JLabel percentLabel = new JLabel("Проценти (%):");
        percentLabel.setBounds(10, 50, 80, 25);
        panel.add(percentLabel);

        percentField = new JTextField(20);
        percentField.setBounds(100, 50, 165, 25);
        panel.add(percentField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(10, 80, 150, 25);
        panel.add(calculateButton);

        resultLabel = new JLabel("Резултат: ");
        resultLabel.setBounds(10, 110, 300, 25);
        panel.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateFormula();
            }
        });
    }

    private void calculateFormula() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            double percent = Double.parseDouble(percentField.getText());
            double result = (amount / 1000) * percent;
            resultLabel.setText("Резултат: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Невалидна сума. Моля, въведете валидни числа.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}