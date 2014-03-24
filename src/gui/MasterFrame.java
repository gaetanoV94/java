package gui;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.util.*;
import types.*;

/**
 * @author Colin
 */
public class MasterFrame extends JFrame {
    private JPanel  top_panel;
    private JPanel  curr_page;
    private JButton logout_button;
    private JButton back_button;
    private JLabel  role_label;
    private JLabel  crumbs;  // This won't be a JLabel later.
    private List<JPanel> pages;

    // This will take an `Account` object and populate itself according to
    // the Account type.
    public MasterFrame(Account a) {
	// Initialize components.
	top_panel     = new JPanel();
	logout_button = new JButton("Logout");
	back_button   = new JButton("Back");
	role_label    = new JLabel("Role: Filler...");  // Changes according to `a`.
	crumbs        = new JLabel("Breadcrumbs here...");

	// Various settings.
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setTitle("MarkShark - Blah");  // Changes according to `a`.
	setResizable(true);
	setLayout(new GridLayout(2,1));

	// Set up action listeners
	back_button.addActionListener(e -> goBackAction(e));
	logout_button.addActionListener(e -> logoutAction(e));

	// Set up persistent top bar
	top_panel.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	c.gridx = 0;
	c.gridy = 0;
	c.anchor = GridBagConstraints.LINE_START;
	top_panel.add(crumbs, c);

	c.gridx = 2;
	c.gridy = 0;
	c.weighty = 1.0;
	c.anchor = GridBagConstraints.LINE_END;
	top_panel.add(role_label, c);

	c.gridx = 0;
	c.gridy = 1;
	c.weighty = 0;
	c.anchor = GridBagConstraints.LINE_START;
	top_panel.add(back_button, c);

	c.gridx = 2;
	c.gridy = 1;
	c.anchor = GridBagConstraints.LINE_END;
	c.weighty = 1.0;
	top_panel.add(logout_button, c);

	// Set up bottom panel according to `a`.
	// Using Instructor for testing purposes
	curr_page = new LandingPageInstructor();

	// Render the Frame.
	add(top_panel);
	add(curr_page);
	pack();
    }

    public void run() {
	this.setVisible(true);
    }

    private void goBackAction(ActionEvent e) {
	System.out.println("Going back.");
    }

    private void logoutAction(ActionEvent e) {
	System.out.println("Logging out...");
	// TODO: Write to the system log?
	this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
