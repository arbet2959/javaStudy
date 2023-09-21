package Swing2_JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T05_JWindow5 extends JWindow {
	JLabel lblImg;
	
	public T05_JWindow5() {
		setSize(500,300);
		

//		lblImg = new JLabel("안녕하세요.");
//		add(lblImg);
		lblImg = new JLabel();
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/1.jpg")));
		add(lblImg); //이미지레이블 예시
		
//		Jwindow2를 화면 중앙에 띄우기
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		Point centerPoint = ge.getCenterPoint();
//		int leftTopX = centerPoint.x-this.getWidth()/2;
//		int leftTopY = centerPoint.y-this.getHeight()/2;
//		setLocation(leftTopX, leftTopY);
		
		setLocationRelativeTo(null); // 화면중앙에띄우기 간단히
		
		addMouseListener(new MouseAdapter() {
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
				T05_JWindow5 t4 = new T05_JWindow5();
				t4.setVisible(true);
				
			}
		});
	}
}
