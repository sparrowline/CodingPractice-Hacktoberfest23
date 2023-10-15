// This program will create disable or enable button using Swing.

package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class DisableEnableInSwing extends JFrame
{
	// create objects used in the frame.
	public static final String ENABLE = "ENABLE";
	public static final String DISABLE = "DISABLE";

	private JToolBar toolBar = new JToolBar();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu testMenu = new JMenu("Test");
	private MyAction theAction = new MyAction(this);
	
	// for disable the button.
	private JMenuItem disableActionItem= new JMenuItem("Disable the Action");

	public DisableEnableInSwing() 
	{
		// add menu objects.
		this.setJMenuBar(menuBar);
		
		menuBar.add(testMenu);
		testMenu.add(theAction);
		toolBar.add(theAction);

		// create button in menu to disable action.
		disableActionItem.setActionCommand(DISABLE);
		testMenu.add(disableActionItem);
    
		disableActionItem.addActionListener(new ActionListener() 
		{
			// perform the disable action.
			public void actionPerformed(ActionEvent e) 
			{
				// this works when button is enable.
				if (e.getActionCommand().equals(DISABLE))
				{
					theAction.setEnabled(false);
					disableActionItem.setText("Enable the Action");
					disableActionItem.setActionCommand(ENABLE);
				}
				// otherwise enable the button.
				else
				{
					theAction.setEnabled(true);
					disableActionItem.setText("Disable the Action");
					disableActionItem.setActionCommand(DISABLE);
				}
			}
		});
		
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// will set back color and size of the frame.
		this.getContentPane().setBackground(Color.red);
		this.setSize(320, 200);
		this.setVisible(true);
	}

	public static void main(String[] args) 
	{
		DisableEnableInSwing t = new DisableEnableInSwing();
	}
}

class MyAction extends AbstractAction
{
	// create JFrame object.
	JFrame f;
	boolean toggle = true;

	// function used for changing color.
	public MyAction(JFrame f)
	{
		super("Change Color");
		this.f = f;
	}

	// this will perform action and change color on click.
	public void actionPerformed(ActionEvent e)
	{
		if (toggle)
		{
			// for blue color.
			f.getContentPane().setBackground(Color.blue);
			toggle = false;
		}
		else
		{
			// for red color.
			f.getContentPane().setBackground(Color.red);
			toggle = true;
		}
		f.repaint();
	}
}
