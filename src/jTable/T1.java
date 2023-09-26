package jTable;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import xDatabase.InsaDAO;
import xDatabase.InsaVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class T1 extends JFrame {

	private JPanel contentPane;
	private JTable tbl;
	private JScrollPane sp;
	
//	Vector<String> title = null;
//	Vector<String> vData = null;
	Vector title, vData;
	DefaultTableModel dtm;
	static InsaDAO dao;
	// xDatabase패키지의 InsaDAO클래스 참조...(import)

	public static void main(String[] args) {
		dao = InsaDAO.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T1 frame = new T1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	public T1() {
		setTitle("JTable 연습(DB에서 값을 가져와서 JTable에 뿌리기)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 480);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 584, 70);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JButton btnNewButton = new JButton("종  료");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 18));
		btnNewButton.setBounds(406, 10, 155, 50);
		pn1.add(btnNewButton);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 69, 584, 301);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(12, 10, 560, 281);
//		pn2.add(scrollPane);
//		
//		tbl = new JTable();
//		scrollPane.setViewportView(tbl);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 371, 584, 70);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMsg = new JLabel("JTABLE에서 선택된 값을 출력합니다.");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("굴림", Font.PLAIN, 16));
		lblMsg.setBounds(12, 10, 560, 50);
		pn3.add(lblMsg);
		
		/* 아래로 JTable 설계하기 */
		// - '부제목'과 '데이터'를 Vector 타입으로 준비한다.
		
		// 1. '부제목'을 Vector타입으로 준비한다.
		title = new Vector<>();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		// 2. '데이터'를 Vector타입으로 준비한다. - 데이터는 Databse에서 가져온다.
		vData = dao.getInsaList();
		
		// 3. DB에서 가져온 자료를 DefaultTableModel을 생성하면서 담아준다.
		dtm = new DefaultTableModel(vData, title);
		
		// 4. DefaultTableModel에 담긴 Vector형식의 자료와 타이틀로 JTable을 생성시켜준다.(생성시 담아준다.)
		tbl = new JTable(dtm);
		
		// 5. 자료가 담긴 table을 JScrollPane생성시에 함께 담아서 생성한다.
		sp = new JScrollPane(tbl);
		sp.setBounds(12, 10, 560, 281);
		
		// 6. JScrollPane을 패널에 올려준다.
		pn2.add(sp);
		
		
		/* ======================================================== */
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}
