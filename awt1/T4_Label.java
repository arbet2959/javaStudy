package awt1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class T4_Label  extends Frame implements WindowListener, ActionListener{
	
	public T4_Label(){
		super("프레임테스트");
//		setSize(400,300);
		setBounds(300, 300, 400, 300); // 300,300픽셀 떨어져서 실행되도록 시작위치 변경
		
		//이름표 : 레이블 컴포넌트
		Label lbl = new Label("회 원 가 입 폼");
		this.add(lbl);
		
		//버튼 컴포넌트
		Button btnExit = new Button("종 료");
		add(btnExit);
		
		setVisible(true);   //-Dfile.encoding=MS949 runconfig - argument
		
		/*===============================================================================================================*/
		btnExit.addActionListener(this);
		addWindowListener(this);
		
	}
	
	public static void main(String[] args) {
		new T4_Label();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
	
	
}
