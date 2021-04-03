package hnue.it.shoppingonline;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import hnue.it.shoppingonline.CustomerController;
import hnue.it.shoppingonline.CustomerModel;

import javax.swing.JTabbedPane;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CustomerView extends JFrame {
	DefaultTableModel tableModel;
	
	private JPanel contentPane;
	private JTable tblCustomer;
	private JTextField tfUserName;
	private JTextField tfPhoneNumber;
	private JTextField tfEmail;
	private JButton btnAdd;
	private JComboBox cbCustomerType;
	private JButton btnDelete; 
	ArrayList<CustomerModel> cusLst = new ArrayList();
	
	/**
	 * Create the frame.
	 */
	public void initComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 606);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Customer", null, panel, null);
		panel.setLayout(null);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBounds(10, 202, 89, 23);
		panel.add(btnAdd);
		
		btnDelete = new JButton("DELETE");
		
		btnDelete.setBounds(330, 202, 89, 23);
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 236, 429, 220);
		panel.add(scrollPane);
		
		tblCustomer = new JTable();
		
		tblCustomer.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Fullname", "Phone Number", "Email", "Customer Type"
			}
		));
		scrollPane.setViewportView(tblCustomer);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name:");
		lblNewLabel_1.setBounds(28, 26, 63, 14);
		panel.add(lblNewLabel_1);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(127, 26, 261, 20);
		panel.add(tfUserName);
		tfUserName.setColumns(10);
		
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setBounds(127, 64, 261, 20);
		panel.add(tfPhoneNumber);
		tfPhoneNumber.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number:");
		lblNewLabel_2.setBounds(28, 64, 78, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(28, 103, 46, 14);
		panel.add(lblNewLabel_3);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(127, 103, 261, 20);
		panel.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Customer Type");
		lblNewLabel_4.setBounds(28, 139, 78, 14);
		panel.add(lblNewLabel_4);
		
		cbCustomerType = new JComboBox();
		cbCustomerType.setModel(new DefaultComboBoxModel(new String[] {"User", "Guest"}));
		cbCustomerType.setBounds(127, 139, 71, 22);
		panel.add(cbCustomerType);
				
	}
	
	private void addEvents() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullname = tfUserName.getText();
				String phone_number = tfPhoneNumber.getText();
				String email = tfEmail.getText();
				String customer_type = cbCustomerType.getSelectedItem().toString();
				CustomerModel cus = new CustomerModel(fullname, phone_number, email, customer_type);
				CustomerController.insert(cus);
				showCustomer();
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = tblCustomer.getSelectedRow();
				if (selectedIndex >= 0) {
					CustomerModel cus = cusLst.get(selectedIndex);
					CustomerController.delete(cus.getId());
					showCustomer();
				}

			}
		});
	}
	public CustomerView() {
		initComponents();
		addEvents();
		tableModel = (DefaultTableModel) tblCustomer.getModel();
		showCustomer();
	}
	
	private void showCustomer() {
		cusLst = CustomerController.findAll();
		
		tableModel.setRowCount(0);
		
		cusLst.forEach((cus) -> {
			tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, cus.getUsername(), cus.getPhoneNumber(), cus.getEmail(), cus.getCustomerType()});
		});
	
	
	}
}
