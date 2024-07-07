package main;

import javax.swing.JFrame;

import com.apple.view.*;

public class App {
	public static void main(String args[]) throws Exception {	
		
        LoginPageGui frame = new LoginPageGui();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
