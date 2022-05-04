package stuff2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class UI {
	
	private JFrame root;
	
	public UI(InputDriver inputDriver) {
		
		// Making the main window
		root = new JFrame("This is the UI");
		root.setSize(new Dimension(1280,720));
		root.addKeyListener(inputDriver);
		root.setLocationRelativeTo(null);
		root.setResizable(false);
		
		GridBagConstraints c = new GridBagConstraints();
		root.setLayout(new GridBagLayout());
		
		c.fill = GridBagConstraints.HORIZONTAL;

		// Adding the separate zones
		JPanel imgPanel = new JPanel();
		imgPanel.setBackground(Color.BLACK);
		imgPanel.setPreferredSize(new Dimension(300,300));
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
        JPanel outputBox = new JPanel();
        outputBox.setLayout(new BoxLayout(outputBox, BoxLayout.Y_AXIS));
        outputBox.setBackground(Color.GREEN);
        outputBox.setPreferredSize(new Dimension(350, 300));
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.insets = new Insets(10, 25, 25, 25);
        
        
        JButton btn1 = new JButton("button 1");
        btn1.setPreferredSize(new Dimension(200,100));
        JButton btn2 = new JButton("button 2");
        btn2.setPreferredSize(new Dimension(200,100));
        JButton btn3 = new JButton("button 3");
        btn3.setPreferredSize(new Dimension(200,100));
        
        outputBox.add(btn1);
        outputBox.add(btn2);
        outputBox.add(btn3);
        
        root.add(outputBox, c);

		root.pack();
		root.setVisible(true);
	}
}
