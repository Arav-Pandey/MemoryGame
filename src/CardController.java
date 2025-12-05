import java.awt.Color;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class CardController {
    private ArrayList<Card> cards;
    private int amountOpen;
    private Card card1;
    private Timer t;
    public static int tries = 0;
    public static int correct = 0;

    CardController(int number, JPanel panel) {
        cards = new ArrayList<Card>();
        amountOpen = 0;

        for (int i = 0; i < number; i++) {
            Card e = new Card(this);
            cards.add(e);
            panel.add(e);
        }
    }

    public void whenOpened(Card c, JLabel tryLabel, JLabel correctLabel) {
        amountOpen++;

        if (amountOpen == 1) {
            card1 = c;
            card1.setEnabled(false);
        }

        if (amountOpen == 2) {
            setAllEnabledCards(false);

            t = new Timer(1500, e -> {
                amountOpen = 0;

                System.out.println(card1.getIcon() + "" + c.getIcon());
                if (card1.getIcon().toString().equals((c.getIcon().toString()))) {
                    card1.setBackground(Color.blue);
                    c.setBackground(Color.blue);

                    correct++;
                    updateCorrect(correctLabel);

                    card1.setEnabled(false);
                    c.setEnabled(false);
                } else {
                    card1.reset();
                    c.reset();
                }

                tries++;
                updateTries(tryLabel);
                setAllEnabledCards(true);
            });
            t.setRepeats(false); // important: make it behave like setTimeout()
            t.start();

        }
    }

    public void resetBoard(JLabel tryLabel, JLabel correctLabel) {
        t.stop();
        for (Card c : cards) {
            c.reset();
        }
        tries = 0;
        correct = 0;
        updateTries(tryLabel);
        updateCorrect(correctLabel);
    }

    public void setAllEnabledCards(boolean bool) {
        for (Card c : cards) {
            c.setEnabled(bool);
        }
    }

    public void updateTries(JLabel tryLabel) {
        tryLabel.setText("\t Tries: " + tries);
    }

    public void updateCorrect(JLabel correctLabel) {
        correctLabel.setText("Correct: " + correct + " / 8");
    }
}