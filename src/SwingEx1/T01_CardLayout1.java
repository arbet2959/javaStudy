package SwingEx1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T01_CardLayout1 extends JFrame{
	private JButton btn1, btn2 ,btn3 ,btn4;
	private JPanel pnCenter, pnSouth, pn1, pn2, pn3, pn4;
	public T01_CardLayout1() {
		setTitle("카드레이아웃연습");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		
		btn1 = new JButton("다음");
		btn2 = new JButton("처음");
		btn3 = new JButton("마지막");
		btn4 = new JButton("파랑");
		
		pnCenter = new JPanel();
		pnSouth = new JPanel();
		pn1 = new JPanel();
		pn1.setBackground(Color.GREEN);
		pn2 = new JPanel();
		pn2.setBackground(Color.BLUE);
		pn3 = new JPanel();
		pn3.setBackground(Color.RED);
		pn4 = new JPanel();
		pn4.setBackground(Color.GRAY);
		
		add(pnCenter, BorderLayout.CENTER);
		add(pnSouth, BorderLayout.SOUTH);
		
		CardLayout card =new CardLayout();
		pnCenter.setLayout(card);
		pnCenter.add(pn1);
		pnCenter.add(pn2,"파랑");
		pnCenter.add(pn3);
		pnCenter.add(pn4);
		
		pnSouth.add(btn1);
		pnSouth.add(btn2);
		pnSouth.add(btn3);
		pnSouth.add(btn4);
	
	//=======================================================================================================================
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(pnCenter);
			}
		});
	
		btn2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			card.first(pnCenter);
		}
	});
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.last(pnCenter);
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(pnCenter, "파랑");
			}
		});
	
}
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T01_CardLayout1 t01 = new T01_CardLayout1();
				t01.setVisible(true);
			}
		});
	}
}
