package hnue.it.shoppingonline;

import java.awt.EventQueue;

import hnue.it.shoppingonline.CustomerView;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerView frame = new CustomerView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
