package Swing3_Layout;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T02_BorderLayout extends JFrame {
		private JButton btnNorth, btnSouth, btnWest, btnEast, btnCenter;
	
	public T02_BorderLayout() {
		setTitle("BorderLayout 연습");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout());	
		getContentPane().add(getBtnNorth(), BorderLayout.NORTH);
		getContentPane().add(getBtnSouth(), BorderLayout.SOUTH);
		getContentPane().add(getBtnWest(), BorderLayout.WEST);
		getContentPane().add(getBtnEast(), BorderLayout.EAST);
		add(getBtnCenter(), BorderLayout.CENTER);
	}
	
	
	private JButton getBtnNorth() {
		btnNorth = new JButton("북쪽");
		return btnNorth;
	}
	private JButton getBtnSouth() {
		btnSouth = new JButton("남쪽");
		return btnSouth;
	}
	private JButton getBtnEast() {
		btnEast = new JButton("동쪽");
		return btnEast;
	}
	private JButton getBtnWest() {
		btnWest = new JButton("서쪽");
		return btnWest;
	}
	private JButton getBtnCenter() {
		btnCenter = new JButton("중앙");
		return btnCenter;
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T02_BorderLayout t2 = new T02_BorderLayout();
				t2.setVisible(true);
			}
		});
	}
}
