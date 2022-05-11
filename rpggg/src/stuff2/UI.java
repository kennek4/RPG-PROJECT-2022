package stuff2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI implements Runnable {

    private JFrame root;
    private InputDriver inputDriver;
    private HeartBeat hb;
    public JPanel outputBox = new JPanel();

    public UI(InputDriver inputDriver, HeartBeat hb) {
        this.hb = hb;
        this.inputDriver = inputDriver;
    }

    @Override
    public void run() {

        // Making the main window
        root = new JFrame("This is the UI");
        root.setSize(new Dimension(1280, 720));
        root.addKeyListener(inputDriver);
        root.setLocationRelativeTo(null);
        root.setResizable(false);

        GridBagConstraints c = new GridBagConstraints();
        root.setLayout(new GridBagLayout());

        c.fill = GridBagConstraints.HORIZONTAL;

        // Adding the separate zones
        JPanel imgPanel = new JPanel();
        imgPanel.setBackground(Color.BLACK);
        imgPanel.setPreferredSize(new Dimension(300, 300));
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.insets = new Insets(25, 25, 10, 10);
        root.add(imgPanel, c);

        // Inspect Box
        JPanel inspectBox = new JPanel();
        inspectBox.setBackground(Color.GRAY);
        inspectBox.setPreferredSize(new Dimension(800, 300));
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.insets = new Insets(25, 10, 15, 25);
        root.add(inspectBox, c);

        // Output Panel
        outputBox.setLayout(new BoxLayout(outputBox, BoxLayout.Y_AXIS));
        outputBox.setBackground(Color.GREEN);
        outputBox.setPreferredSize(new Dimension(350, 300));
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.insets = new Insets(10, 25, 25, 25);

        // Text boxes
        JLabel textBoxOne = new JLabel("1");
        JLabel textBoxTwo = new JLabel("2");
        JLabel textBoxThree = new JLabel("3");
        JLabel textBoxFour = new JLabel("4");
        JLabel textBoxFive = new JLabel("5");

        // Buttons
        JButton btn1 = new JButton("Take Cover");
        btn1.setPreferredSize(new Dimension(100, 100));
        btn1.addActionListener(a -> hb.takeCover());

        JButton btn2 = new JButton("Shooting");
        btn2.setPreferredSize(new Dimension(100, 100));
        btn2.addActionListener(b -> hb.shootingPos());

        JButton btn3 = new JButton("attack");
        btn3.setPreferredSize(new Dimension(100, 100));
        btn3.addActionListener(f -> hb.queuePlayerAttack());

        JButton btn4 = new JButton("reload");
        btn4.setPreferredSize(new Dimension(100, 100));
        btn4.addActionListener(d -> hb.queueReload());

        outputBox.add(textBoxOne);
        outputBox.add(textBoxTwo);
        outputBox.add(textBoxThree);
        outputBox.add(textBoxFour);
        outputBox.add(textBoxFive);

        root.add(btn1);
        root.add(btn2);
        root.add(btn3);
        root.add(btn4);

        root.add(outputBox, c);

        root.pack();
        root.setVisible(true);
    }
}
