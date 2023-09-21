package Swing2_JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T02_invokeLater extends JFrame{
	JButton btnExit;
	public T02_invokeLater() {
		setTitle("스윙 이벤트큐 연습");
		setBounds(300,200,300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 창 종료
		
		System.out.println("22222222222222222");
		
		btnExit = new JButton("Exit");
		add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
//		addWindowListener(new WindowAdapter() {
//		@Override
//		public void windowClosing(WindowEvent e) {
//			System.exit(0);
//		}
//		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우X키때 JFrame도 종료
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("11111111111111111111111111111111111111");
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				T02_invokeLater t2 = new T02_invokeLater();
				t2.setVisible(true);
				System.out.println(Thread.currentThread().getName());
				
			}
		});
		System.out.println("3333333333333333333333333333333333333333");
		System.out.println(Thread.currentThread().getName());
	}
}
