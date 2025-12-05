import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Card extends JButton {
    private ImageIcon Spider = new ImageIcon("ScreenShots/Spider.png");
    private ImageIcon Bee = new ImageIcon("ScreenShots/Bee.png");
    private ImageIcon Capybara = new ImageIcon("ScreenShots/Capybara.png");
    private ImageIcon Dog = new ImageIcon("ScreenShots/Dog.png");
    private ImageIcon Llama = new ImageIcon("ScreenShots/Llama.png");
    private ImageIcon Octopus = new ImageIcon("ScreenShots/Octopus.png");
    private ImageIcon PurpOctopus = new ImageIcon("ScreenShots/PurpOctopus.png");
    private ImageIcon Worker = new ImageIcon("ScreenShots/Worker.png");
    private JLabel tryLabel = App.tryLabel;
    private JLabel correctLabel = App.correctLabel;
    private ArrayList<ImageIcon> values = new ArrayList<ImageIcon>(Arrays.asList(
            Spider,
            Spider,
            Bee,
            Bee,
            Capybara,
            Capybara,
            Dog,
            Dog,
            Llama,
            Llama,
            Octopus,
            Octopus,
            PurpOctopus,
            PurpOctopus,
            Worker,
            Worker));

    public Card(CardController cc) {
        Random random = new Random();

        super();
        super.setFocusable(false);
        super.setBackground(Color.black);
        super.setForeground(Color.white);

        ImageIcon val = values.get(random.nextInt(values.size()));
        values.remove(val);

        super.addActionListener(e -> {
            super.setBackground(Color.gray);

            cc.whenOpened(this, tryLabel, correctLabel);
            super.setIcon(val);

        });
    }

    public void reset() {
        super.setIcon(null);
        super.setBackground(Color.black);
    }
}