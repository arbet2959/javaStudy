package Swing2_JFrame;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_JWindow2 extends JWindow {
	JButton exitBtn;
	
	public T04_JWindow2() {
		setSize(500,300);
		
		exitBtn = new JButton("종료");
		add(exitBtn);
		
//		exitBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//				
//			}
//		});
		
//		Jwindow2를 화면 중앙에 띄우기
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		Point centerPoint = ge.getCenterPoint();
//		int leftTopX = centerPoint.x-this.getWidth()/2;
//		int leftTopY = centerPoint.y-this.getHeight()/2;
//		setLocation(leftTopX, leftTopY);
		
		setLocationRelativeTo(null); // 화면중앙에띄우기 간단히
		
		exitBtn.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent e) {
//			System.exit(0);  프로세스종료
//			setVisible(false);  숨기기
			dispose(); //현재스레드종료
			}
		});
	}
	
	
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@override
			public void run() {
				T04_JWindow2 t4 = new T04_JWindow2();
				t4.setVisible(true);
				
			}
		});
	}
}
