package xDatabase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class InsaList extends JFrame {

	private JPanel contentPane;
	private JTable tbl;
	private JScrollPane sp;
	private ButtonGroup genderGroup = new ButtonGroup();
	private JComboBox cbColumn;
	@SuppressWarnings("rawtypes")
	Vector title, vData;
	DefaultTableModel dtm;
	
	InsaDAO dao = InsaDAO.getInstance();
	private JTextField txtCondition;

	@SuppressWarnings("unchecked")
	public InsaList() {
		setTitle("JTable 연습(DB에서 값을 가져와서 JTable에 뿌리기)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 70);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JButton btnExit = new JButton("종  료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 13));
		btnExit.setBounds(704, 9, 68, 36);
		pn1.add(btnExit);
		
		cbColumn = new JComboBox();
		cbColumn.setModel(new DefaultComboBoxModel(new String[] {"idx", "name", "age", "gender", "ipsail"}));
		cbColumn.setBounds(12, 24, 107, 36);
		pn1.add(cbColumn);
		
		txtCondition = new JTextField();
		txtCondition.setBounds(138, 25, 302, 34);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		JButton btnSearch = new JButton("조건검색");
		btnSearch.setBounds(467, 24, 117, 35);
		pn1.add(btnSearch);
		
		JButton btnContainSearch = new JButton("포함검색");
		btnContainSearch.setBounds(588, 24, 104, 35);
		pn1.add(btnContainSearch);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 69, 784, 410);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 478, 784, 83);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnNameAsc = new JButton("성명오름차순");
		btnNameAsc.setBounds(450, 10, 100, 28);
		pn3.add(btnNameAsc);
		
		
		JButton btnNameDesc = new JButton("성명내림차순");
		btnNameDesc.setBounds(450, 45, 100, 28);
		pn3.add(btnNameDesc);
		
		JButton btnAgeAsc = new JButton("나이오름차순");
		btnNameAsc.setBounds(330, 10, 100, 28);
		pn3.add(btnNameAsc);
		
		
		JButton btnAgeDesc = new JButton("나이내림차순");
		btnNameDesc.setBounds(330, 45, 100, 28);
		pn3.add(btnNameDesc);
		
		JRadioButton rdMale = new JRadioButton("남자");
		rdMale.setBounds(28, 13, 121, 23);
		genderGroup.add(rdMale);
		pn3.add(rdMale);
		
		JRadioButton rdFemale = new JRadioButton("여자");
		rdFemale.setBounds(28, 48, 121, 23);
		genderGroup.add(rdFemale);
		pn3.add(rdFemale);
		
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
		sp.setBounds(12, 10, 772, 390);
		
		// 6. JScrollPane을 패널에 올려준다.
		pn2.add(sp);
		
		//Jtable안에 셀 정렬하기
		tableCellAlign(tbl);
		
		/* ======================================================== */
		
		// 성명 오름차순 버튼
		btnNameAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getList("name","asc");
				dtm.setDataVector(vData, title);
			}
		});
		
	// 성명 내림차순 버튼
		btnNameDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getList("name","desc");
				dtm.setDataVector(vData, title);
			}
		});
		
		// 나이 오름차순 버튼
		btnAgeAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getList("age","asc");
				dtm.setDataVector(vData, title);
			}
		});
		
	// 나이 내림차순 버튼
		btnAgeDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getList("age","desc");
				dtm.setDataVector(vData, title);
			}
		});
		
		
			rdMale.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vData = dao.getSearch("gender", "남자");
					dtm.setDataVector(vData, title);
				}
			});
			
			rdFemale.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vData = dao.getSearch("gender","여자");
					dtm.setDataVector(vData, title);
				}
			});
			
			//조건검색
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String column = cbColumn.getSelectedItem().toString();
					String condition = txtCondition.getText();
					vData = dao.getSearch(column,condition);
					dtm.setDataVector(vData, title);
					
				}
			});
//			//포함검색
//			btnContainSearch.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					String column = cbColumn.getSelectedItem().toString();
//					String condition = txtCondition.getText();
//					
//					vData = dao.getContainSearch(column,condition);
//					dtm.setDataVector(vData, title);
//				}
//			}); //포함검색 통합하는거 망함
		// table안의 셀을 클릭할때 입력된 정보 가져오기
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbl.getSelectedRow();
				int col = tbl.getSelectedColumn();
				
				Object value = tbl.getValueAt(row, col);
				
				// lblMsg.setText("row:" + row + ", col:" + col + ", value:" + value);
			}
		});
		//콤보박스의 컬럼을 고르면 옆에 텍스트로 이동
		cbColumn.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				txtCondition.requestFocus();
			}
		}); 
		//텍스트필드에서 엔터누르면 조건검색 실행;
		txtCondition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String column = cbColumn.getSelectedItem().toString();
					String condition = txtCondition.getText();
					vData = dao.getSearch(column,condition);
					dtm.setDataVector(vData, title);
				}
			}
		});
		

		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				dispose();
			}
		});
		
	}

	private void tableCellAlign(JTable tbl2) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		TableColumnModel tcm = tbl.getColumnModel();
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		
		
		}
	}
	
	
}
