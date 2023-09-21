package Swing2_JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class T01_JFrame extends JFrame{
	JButton btnExit;
	public T01_JFrame() {
		setTitle("스윙연습!");
		setBounds(300,200,300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 창 종료
		
		btnExit = new JButton("Exit");
		add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});

	}
	
	
	
	
	public static void main(String[] args) {
		T01_JFrame t1 = new T01_JFrame();
		t1.setVisible(true);
	}
}
