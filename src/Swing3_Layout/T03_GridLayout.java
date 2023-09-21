package Swing3_Layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T03_GridLayout extends JFrame {
	private JButton[][] btn;	
	
	public T03_GridLayout() {
		setTitle("GrideLayout연습");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new GridLayout(2, 3));
		
//		add(getBtn1());
//		add(getBtn2());
//		add(getBtn3());
//		add(getBtn4());
//		add(getBtn5());
//		add(getBtn6());
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<3;j++) {
				add(getBtn()[i][j]);
			}
		}
	}	
	

	private JButton[][] getBtn() {
		int cnt = 1;
		btn = new JButton[2][3];
		for(int i=0; i<2; i++) {	
			for(int j=0; j<3;j++) {
				btn[i][j] = new JButton("버튼"+cnt++);
			}
		}
		return btn;
	}




















	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T03_GridLayout t03 = new T03_GridLayout();
				t03.setVisible(true);
			}
		});
	}
}