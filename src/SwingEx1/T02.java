package SwingEx1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class T02 extends JFrame {
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel contentPane;
	private JRadioButton rdbtnMale, rdbtnFemale;
	private JCheckBox chckbxHobby1, chckbxHobby2, chckbxHobby3, chckbxHobby4; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T02 frame = new T02();
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
	public T02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 772, 105);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("라디오 버튼 연습");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 10, 772, 85);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 115, 772, 323);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("성  별");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(39, 43, 101, 39);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("취  미");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(39, 114, 101, 39);
		panel_1.add(lblNewLabel_1_1);
		
		rdbtnMale = new JRadioButton("남  자");
		rdbtnMale.setSelected(true);
		rdbtnMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMale.setBounds(157, 43, 101, 39);
		buttonGroup.add(rdbtnMale);
		panel_1.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("여  자");
		rdbtnFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnFemale.setBounds(268, 43, 101, 39);
		buttonGroup.add(rdbtnFemale);
		panel_1.add(rdbtnFemale);
		
		JLabel lblMsg = new JLabel("");
		lblMsg.setBackground(new Color(128, 255, 255));
		lblMsg.setFont(new Font("굴림", Font.PLAIN, 12));
		lblMsg.setBounds(26, 191, 264, 85);
		panel_1.add(lblMsg);
		
		chckbxHobby1 = new JCheckBox("등  산");
		chckbxHobby1.setBounds(208, 122, 74, 23);
		panel_1.add(chckbxHobby1);
		
		chckbxHobby2 = new JCheckBox("바  둑");
		chckbxHobby2.setBounds(349, 122, 74, 23);
		panel_1.add(chckbxHobby2);
		
		chckbxHobby3 = new JCheckBox("체   스");
		chckbxHobby3.setBounds(490, 122, 74, 23);
		panel_1.add(chckbxHobby3);
		
		chckbxHobby4 = new JCheckBox("오   목");
		chckbxHobby4.setBounds(631, 122, 74, 23);
		panel_1.add(chckbxHobby4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 456, 772, 95);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSubmit = new JButton("전   송");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender, hobby = null;
				if(rdbtnMale.isSelected()) gender = rdbtnMale.getText();
				else gender = rdbtnFemale.getText();
				if(chckbxHobby1.isSelected()) hobby +=  chckbxHobby1.getText() +"\t";
				if(chckbxHobby2.isSelected()) hobby +=  chckbxHobby2.getText() +"\t";
				if(chckbxHobby3.isSelected()) hobby +=  chckbxHobby3.getText() +"\t";
				if(chckbxHobby4.isSelected()) hobby +=  chckbxHobby4.getText() +"\t";
				
				lblMsg.setText(gender);
				lblMsg.setText(hobby);
			}
		});
		btnSubmit.setBounds(160, 27, 166, 58);
		panel_2.add(btnSubmit);
		
		JButton btnReset = new JButton("종   료");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnReset.setBounds(433, 27, 166, 58);
		panel_2.add(btnReset);
	}
}
