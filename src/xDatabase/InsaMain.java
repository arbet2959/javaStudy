package xDatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsaMain extends JFrame {
	private JButton btnInput, btnSearch, btnList, btnExit;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsaMain frame = new InsaMain();
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
	public InsaMain() {
		setTitle("인사관리 메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 10, 784, 77);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("인사관리프로그램 ver1.0");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 22));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(23, 0, 733, 67);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 97, 784, 367);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMain = new JLabel("");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setIcon(new ImageIcon(InsaMain.class.getResource("/xDatabase/images/main.jpg")));
		lblMain.setBounds(0, 0, 784, 346);
		pn2.add(lblMain);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 474, 784, 77);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("사원 등록");
		btnInput.setBounds(36, 25, 150, 42);
		pn3.add(btnInput);
		
		btnSearch = new JButton("개별조회");
		btnSearch.setBounds(222, 25, 150, 42);
		pn3.add(btnSearch);
		
		btnList = new JButton("전체조회");
		btnList.setBounds(408, 25, 150, 42);
		pn3.add(btnList);
		
		btnExit = new JButton("종료");
		btnExit.setBounds(594, 25, 150, 42);
		pn3.add(btnExit);
	

	//================================================================================================================================
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsaInput();
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("이름을 입력해 주세요");
				InsaDAO dao = InsaDAO.getInstance();
				InsaVO vo = new InsaVO();
				vo = dao.getNameSearch(name);
				if(vo.getName()==null) JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.");
				else new InsaSearch(vo);
			}
		});
		
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}
