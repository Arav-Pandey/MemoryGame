import javax.swing.*;
import java.awt.*;

public class App {
    public static int amountOpen = 0;
    public static JLabel correctLabel = new JLabel("Correct: 0 / 8");
    public static JLabel tryLabel = new JLabel("\t Tries: 0");

    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("Memory Game");
        frame.setSize(500, 650);
        frame.setLayout(new BorderLayout());

        tryLabel.setForeground(Color.white);
        correctLabel.setForeground(Color.white);

        JPanel resetPanel = new JPanel();
        resetPanel.setBackground(Color.black);
        JButton resetButton = new JButton("Reset Board");
        resetButton.setFocusable(false);
        resetPanel.add(correctLabel);
        resetPanel.add(resetButton);
        resetPanel.add(tryLabel);
        frame.add(resetPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        frame.add(buttonPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardController cc = new CardController(16, buttonPanel);

        resetButton.addActionListener(e -> {
            cc.resetBoard(tryLabel, correctLabel);
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
