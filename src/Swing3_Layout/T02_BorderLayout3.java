package Swing3_Layout;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class T02_BorderLayout3 extends JFrame{
	private JButton btn1, btn2, btn3;
	private JPanel pnl;
	
	public T02_BorderLayout3() {
		setTitle("BorderLayout연습3");
		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		btn1 = new JButton("Hi");
		add(btn1, BorderLayout.NORTH);
		
		btn2 = new JButton("버튼2");
		btn3 = new JButton("버튼3");
		pnl = new JPanel();
		
		pnl.add(btn2);
		pnl.add(btn3);
		add(pnl,BorderLayout.SOUTH);
		
		
		//-=============================================================================
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "안녕버튼을 누르셨습니다");
			}
		});
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T02_BorderLayout3 t02 = new T02_BorderLayout3();
				t02.setVisible(true);
				
			}
		});
	}//
}
