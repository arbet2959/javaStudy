package Swing3_Layout;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class T05_NullLayout2 extends JFrame {
	private JButton btnExit, btnInput, btnReset;
	private int xPos = 100;
	private JLabel lblTitle, lbl1, lbl2, lbl3;
	private int yPos = 100;
	
	private JLabel lblName,lblAge;
	private JTextField txtName, txtAge;
	private JTextArea txtaContent;
	
	
	public T05_NullLayout2() {
		setTitle("절대위치 레이아웃");
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(null);
		
		add(getlblName());
		add(getlblAge());
		add(gettxtName());
		add(getTxtAge());
		
		add(getbtnExit());
		add(getbtnInput());
		add(getbtnReset());
		
		add(getLblTitle());
		add(gettxtaContent());

	
	//============================================================================================================================================
		btnInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = "";
				str += "성명 : "+ txtName.getText()+"\n";
				str += "나이 : "+ txtAge.getText();
				lblTitle.setText("회원가입정보");
				txtaContent.setText(str);
				
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				
			}
		});

		btnExit.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "종료");
				System.exit(0);
				
			}
		});
		
	}
	

		private JTextArea gettxtaContent() {
			txtaContent = new JTextArea();
			txtaContent.setBackground(Color.CYAN);
			txtaContent.setBounds(100, 250, 150, 150);
			return txtaContent;
		}


		private JLabel getLblTitle() {
			lblTitle = new JLabel();
			lblTitle.setBackground(Color.CYAN);
			lblTitle.setBounds(100,200,150,150);
			return lblTitle;
	}




	private JTextField getTxtAge() {
		txtAge = new JTextField();
		txtAge.setBounds(xPos+130, yPos+50, 100, 30);
		return txtAge;
	}

	private JTextField gettxtName() {
		txtName = new JTextField();
		txtName.setBounds(xPos+130, yPos, 100, 30);
		return txtName;
	}

	private JLabel getlblAge() {
		lblAge = new JLabel();
		lblAge.setText("나 이");
		lblAge.setBounds(xPos, yPos+50, 50, 30);
		return lblAge;
	}

	private JLabel getlblName() {
		lblName = new JLabel();
		lblName.setText("성 명");
		lblName.setBounds(xPos, yPos, 50, 30);
		return lblName;
	}

	
	private JButton getbtnReset() {
		btnReset = new JButton();
		btnReset.setText("리 셋");
		btnReset.setBounds(450, 600,	70, 40);
		return btnReset;
	}
	
	private JButton getbtnInput() {
		btnInput = new JButton();
		btnInput.setText("입 력");
		btnInput.setBounds(350, 600,	70, 40);
		return btnInput;
	}
	private JButton getbtnExit() {
		btnExit = new JButton();
		btnExit.setText("종 료");
		btnExit.setBounds(550, 600,	70, 40);
		return btnExit;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T05_NullLayout2 t05 = new T05_NullLayout2();
				t05.setVisible(true);
			}
		});
	}
}
