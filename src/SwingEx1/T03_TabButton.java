package SwingEx1;


import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T03_TabButton extends JFrame{
	private JTabbedPane tabbedPane;
	private JPanel pnTab1, pnTab2;
	
	
	public T03_TabButton() {
		setTitle("TabButton 연습");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		add(getTabbedPane(), BorderLayout.CENTER);
		
		
	
	
	
	}//
	
	
	
	



	private JTabbedPane getTabbedPane() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.addTab("탭1", null, getPnTab1());
		tabbedPane.addTab("탭2", null, getPnTab2());
		return tabbedPane;
	}







	private	JPanel getPnTab1() {
		pnTab1 = new JPanel();
		JLabel lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon(getClass().getResource("./1.jpg")));
		pnTab1.add(lblImage);
		return pnTab1;
	}
	private	JPanel getPnTab2() {
		pnTab2 = new JPanel();
		JLabel lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon(getClass().getResource("./2.jpg")));
		pnTab2.add(lblImage);
		return pnTab2;
	}







	private Component getTabButton() {
		// TODO Auto-generated method stub
		return null;
	}







	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T03_TabButton t03 = new T03_TabButton();
				t03.setVisible(true);
				
			}
		});
	}
}
