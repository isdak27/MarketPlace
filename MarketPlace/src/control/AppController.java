package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PrincipalFrame;

public class AppController implements ActionListener {

	private PrincipalFrame frontend;

	public AppController() {
		frontend = new PrincipalFrame(this);
	}

	public PrincipalFrame getFrontend() {
		return frontend;
	}

	public static void main(String[] args) {
		new AppController();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
