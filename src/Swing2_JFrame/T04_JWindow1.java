package Swing2_JFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_JWindow1 extends JWindow implements MouseListener {
	JButton exitBtn;
	
	public T04_JWindow1() {
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
		exitBtn.addMouseListener(this);
	}
	
	
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@override
			public void run() {
				T04_JWindow1 t4 = new T04_JWindow1();
				t4.setVisible(true);
				
			}
		});
	}





	@Override
	public void mouseClicked(MouseEvent e) {
		dispose();
	}
	





	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		}


	@Override
	public void mouseEntered(MouseEvent e) {
	}





	@Override
	public void mouseExited(MouseEvent e) {
	
	}
}
