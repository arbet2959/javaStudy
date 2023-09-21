package SwingEx1;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T02_ScrollPane extends JFrame{
	private JLabel lblImage;
	private JScrollPane scrollPane;
	
	
	public T02_ScrollPane() {
		setTitle("ScrollPane 연습");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		BorderLayout border = new BorderLayout();
		setLayout(border);
		
		add(getScrollPane(), border.CENTER);
	
	
	
	
	}//
	
	
	
	private JScrollPane getScrollPane() {
		scrollPane = new JScrollPane(getLblImage()); // JScrollpane에 레이블을 올려준다.
		return scrollPane;
	}



	private JLabel getLblImage() {
		lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon("./1.jpg"));
//		lblImage.setIcon(new ImageIcon(getClass().getResource("./1.jpg")));
		return lblImage;
	}



	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T02_ScrollPane t02 = new T02_ScrollPane();
				t02.setVisible(true);
				
			}
		});
	}
}
