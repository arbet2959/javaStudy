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

public class InsaSearch extends JFrame {

	private JPanel contentPane;
	private JTextField txtName, txtAge;
	private ButtonGroup buttonGroup = new ButtonGroup();	
	private JRadioButton rbMale, rbFemale;
	private JButton btnUpdate, btnDelete, btnClose;
	private InsaVO vo;
	private InsaDAO dao;
	private InsaService service;
	
	int res=0;
	


	/**
	 * Create the frame.
	 * @param vo2 
	 */
	public InsaSearch(InsaVO vo) {
//		System.out.println(vo.toString());
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
		
		JLabel lblTitle = new JLabel("선택조회");
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
		txtName.setText(vo.getName());
		pn2.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(247, 134, 221, 32);
		txtAge.setText(vo.getAge()+"");
		pn2.add(txtAge);
		
		rbMale = new JRadioButton("남자");
		rbMale.setSelected(true);
		rbMale.setBounds(249, 217, 121, 32);
		if(vo.getGender().equals("남자")) rbMale.setSelected(true);
		pn2.add(rbMale);
		
		rbFemale = new JRadioButton("여자");
		rbFemale.setBounds(396, 217, 121, 32);
		if(vo.getGender().equals("여자")) rbFemale.setSelected(true);
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
		
		String[] ymds = vo.getIpsail().substring(0,10).split("-");
		
		
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setBounds(225, 300, 60, 23);
		cbYY.setSelectedItem(ymds[0]);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setBounds(330, 300, 60, 23);
		cbMM.setSelectedItem(ymds[1]);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setBounds(432, 300, 60, 23);
		cbDD.setSelectedItem(ymds[2]);
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
		
		btnUpdate = new JButton("수정하기");
		btnUpdate.setBounds(33, 10, 175, 53);
		pn3.add(btnUpdate);
		
		btnDelete = new JButton("삭제하기");
		btnDelete.setBounds(260, 10, 175, 53);
		pn3.add(btnDelete);
		
		btnClose = new JButton("창 닫기");
		btnClose.setBounds(455, 10, 175, 53);
		pn3.add(btnClose);
		
		
		//-----------------------------------------------------------------------------------------------------------------
		//회원정보수정버튼
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String age = txtAge.getText();
				String gender;
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				InsaVO vo = new InsaVO();
				

				if(!Pattern.matches("[0-9]+", age)) {
					JOptionPane.showMessageDialog(null, "나이를 다시 입력해주세요");
					txtAge.requestFocus();
				}else if(Pattern.matches("[0-9]+", age)) {
					dao = InsaDAO.getInstance();
					vo = dao.getNameSearch(name);
						//정상입력
						if(rbMale.isSelected()) gender ="남자";
						else gender = "여자";
						vo.setName(name);
						vo.setAge(Integer.parseInt(age));
						vo.setGender(gender);
						vo.setIpsail(ipsail);
						
						res = dao.setInsaUpdate(vo);
						
						if(res ==0)	JOptionPane.showMessageDialog(null, "수정실패");
						if(res ==1)	{
							JOptionPane.showMessageDialog(null, "수정성공!");	
							dispose();
						}
					}
			}
		
		});
		
		//삭제버튼
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();

				int ans = JOptionPane.showConfirmDialog(null, name + "회원을 삭제하시겠습니까?","회원삭제",JOptionPane.YES_NO_OPTION);
				if(ans ==0) {
					dao = InsaDAO.getInstance();
					res = dao.setInsaDelete(name);
					if(res == 1) {
						JOptionPane.showMessageDialog(null, "삭제되었습니다.");
						dispose();
					}
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "회원삭제 실패했습니다");
					}
				}
				if(ans==1) {
					JOptionPane.showMessageDialog(null, "취소했습니다.");
				}
				
			}
		});

		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
}
