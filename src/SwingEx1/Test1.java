package SwingEx1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Test1 extends JFrame {
	private JTextField textId;
	private JPasswordField textpwd;
	private JTextField textName;
	private JTextField textEmail;
	private JTextField textAge;
	private JButton btnInput, btnEXit, btnReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 frame = new Test1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test1() {
		setTitle("스윙연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입창");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(80, 30, 550, 60);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("아이디");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(12, 130, 100, 40);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("비밀번호");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(12, 215, 100, 40);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("이름");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(12, 300, 100, 40);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("이메일");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setBounds(12, 385, 100, 40);
		getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("나이");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setBounds(12, 470, 100, 40);
		getContentPane().add(lblNewLabel_1_5);
		
		textId = new JTextField();
		textId.setBounds(124, 130, 446, 40);
		getContentPane().add(textId);
		textId.setColumns(10);
		
		textpwd = new JPasswordField();
		textpwd.setColumns(10);
		textpwd.setBounds(124, 215, 446, 40);
		getContentPane().add(textpwd);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(124, 300, 446, 40);
		getContentPane().add(textName);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(124, 385, 446, 40);
		getContentPane().add(textEmail);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(124, 470, 446, 40);
		getContentPane().add(textAge);
		
		btnInput = new JButton("회원가입");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				str += "아이디 : " + textId.getText() + "\n";
				str += "비밀번호 : " + textpwd.getText() + "\n";
				str += "성 명 : " + textName.getText() + "\n";
				str += "이메일 : " + textEmail.getText() + "\n";
				str += "나 이: " + textAge.getText() + "\n";
				
				JOptionPane.showMessageDialog(null, str);
			}
		});
		btnInput.setBounds(608, 130, 149, 40);
		getContentPane().add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textId.setText("");
				textpwd.setText("");
				textName.setText("");
				textEmail.setText("");
				textAge.setText("");
			}
		});
		btnReset.setBounds(608, 215, 149, 40);
		getContentPane().add(btnReset);
		
		btnEXit = new JButton("창닫기");
		btnEXit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEXit.setBounds(608, 300, 149, 40);
		getContentPane().add(btnEXit);
	}
}
