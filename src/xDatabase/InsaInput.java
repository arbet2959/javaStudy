package xDatabase;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class InsaInput extends JFrame {

	private JPanel contentPane;
	private JTextField txtName, txtAge;
	private ButtonGroup buttonGroup = new ButtonGroup();	
	private JRadioButton rbMale, rbFemale;
	private JButton btnInput, btnReset, btnClose;
	private InsaVO vo;
	private InsaDAO dao;
	private InsaService service;
	private int res=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsaInput frame = new InsaInput();
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
	public InsaInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 72);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("회 원 가 입");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 30));
		lblTitle.setBounds(12, 10, 760, 52);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 82, 784, 383);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("이 름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.BOLD, 15));
		lblName.setBounds(58, 51, 183, 32);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나 이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.BOLD, 15));
		lblAge.setBounds(58, 134, 183, 32);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성 별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.BOLD, 15));
		lblGender.setBounds(58, 217, 183, 32);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입 사 일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("굴림", Font.BOLD, 15));
		lblIpsail.setBounds(58, 300, 183, 32);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(247, 51, 221, 32);
		pn2.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(247, 134, 221, 32);
		pn2.add(txtAge);
		
		rbMale = new JRadioButton("남자");
		rbMale.setSelected(true);
		rbMale.setBounds(249, 217, 121, 32);
		pn2.add(rbMale);
		rbFemale = new JRadioButton("여자");
		rbFemale.setBounds(396, 217, 121, 32);
		pn2.add(rbFemale);
		buttonGroup.add(rbFemale);
		buttonGroup.add(rbMale);
		
		String[] yy = new String[24];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		for(int i=0; i<yy.length; i++)
			yy[i] = i+2000+"";
		
		for(int i=0; i<mm.length; i++)
			mm[i] = i+1+"";
		
		for(int i=0; i<dd.length; i++)
			dd[i] = i+1+"";
		
		
		
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setBounds(225, 300, 60, 23);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setBounds(330, 300, 60, 23);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setBounds(432, 300, 60, 23);
		pn2.add(cbDD);
		
		JLabel lblNewLabel = new JLabel("년");
		lblNewLabel.setBounds(292, 300, 32, 23);
		pn2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("월");
		lblNewLabel_1.setBounds(396, 300, 32, 23);
		pn2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("일");
		lblNewLabel_2.setBounds(504, 300, 32, 23);
		pn2.add(lblNewLabel_2);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 475, 784, 86);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("가입신청");
		btnInput.setBounds(33, 10, 175, 53);
		pn3.add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setBounds(260, 10, 175, 53);
		pn3.add(btnReset);
		
		btnClose = new JButton("창 닫기");
		btnClose.setBounds(455, 10, 175, 53);
		pn3.add(btnClose);
		
		
		//-----------------------------------------------------------------------------------------------------------------
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String age = txtAge.getText();
				String gender;
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				boolean checkName;
				btnReset.doClick();
				if(!Pattern.matches("[가-힣]+", name)) {
					JOptionPane.showMessageDialog(null, "이름을 다시 입력해주세요");
					txtName.requestFocus();
				}else if(!Pattern.matches("[0-9]+", age)) {
					JOptionPane.showMessageDialog(null, "숫자를 다시 입력해주세요");
					txtAge.requestFocus();
				}else if(Pattern.matches("[가-힣]+", name) &&
					Pattern.matches("[0-9]+", age)) {
					dao = InsaDAO.getInstance();
					vo = dao.getNameSearch(name);
					if(vo.getName()!=null) {
						JOptionPane.showMessageDialog(null, "이미 가입된 회원입니다.");
						txtName.requestFocus();
					}else {
						//정상입력
						if(rbMale.isSelected()) gender ="남자";
						else gender = "여자";
						vo.setName(name);
						vo.setAge(Integer.parseInt(age));
						vo.setGender(gender);
						vo.setIpsail(ipsail);
						
						res = dao.setInsaInput(vo);
						
						if(res ==0)	JOptionPane.showMessageDialog(null, "회원가입실패");
						if(res ==1)	{
							JOptionPane.showMessageDialog(null, "회원가입성공!");
							btnReset.doClick();
							dispose();
						}
						
							
						
						//정상자료
					}
				}
					
				
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				rbMale.setSelected(true);
				service = new InsaService();
				 
				vo= service.getDefaultDate(); //오늘날짜얻기
				cbYY.setSelectedItem(vo.getStrYY());
				cbMM.setSelectedItem(vo.getStrMM());
				cbDD.setSelectedItem(vo.getStrDD());
				 
				 txtName.requestFocus();
				
			}
		});
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
}
