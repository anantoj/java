import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener, MouseListener, KeyListener{
	JMenuBar mb;
	JMenu menuNews, menuManage, menuAccount;
	JMenuItem MenuItemShow, MenuItemAdd, AccountItemProfile, AccountItemLogout;
	JDesktopPane desktop;
	JInternalFrame iframeShowNews, iframeShowStaff, iframeAddStaff;
	JLabel lbInfo, idStaff, nameStaff, statusStaff, mouseAction, count;
	JTable table;
	JScrollPane scrollPane;
	JPanel ShowDetailStaff, addStaff;
	JTextField textField;
	public Main() {
		
		// TODO Auto-generated constructor stub
		
		
		mb = new JMenuBar();
		menuNews = new JMenu("News");
		menuManage = new JMenu("Manage Staff");
		menuAccount = new JMenu("Account");
		
		// Manage Staff Submenu
		MenuItemAdd = new JMenuItem("Add Staff");
		MenuItemShow = new JMenuItem("Show Staff");
		mb.add(menuNews);
		mb.add(menuManage);
		mb.add(menuAccount);
		
		// Account Submenu
		AccountItemProfile = new JMenuItem("My Profile");
		AccountItemLogout = new JMenuItem("Logout");
		
		
		menuManage.add(MenuItemAdd);
		menuManage.add(MenuItemShow);
		
		menuAccount.add(AccountItemProfile);
		menuAccount.add(AccountItemLogout);
		
		desktop = new JDesktopPane();
		add(desktop, BorderLayout.CENTER);
		
		iframeShowNews = new JInternalFrame("News Update");		
		lbInfo = new JLabel("No News");
		iframeShowNews.add(lbInfo);		
		iframeShowNews.setSize(700,400);
		iframeShowNews.setVisible(true);
		desktop.add(iframeShowNews);
		
		
		iframeShowStaff = new JInternalFrame("Show Staff");
		insertTable();		
		iframeShowStaff.setSize(700,400);
		iframeShowStaff.setVisible(false);
		desktop.add(iframeShowStaff);
		
		
		iframeAddStaff = new JInternalFrame("Add Staff");
		addStaff = new JPanel(new GridLayout(2,2));
		textField = new JTextField();
		addStaff.add(new JLabel("Staff Name:"));
		addStaff.add(textField);
		addStaff.add(new JLabel("Count Character:"));
		iframeAddStaff.setSize(700,400);
		iframeShowStaff.setVisible(false);
		desktop.add(iframeAddStaff);
		
		// Listeners
		MenuItemShow.addActionListener(this);
		menuNews.addActionListener(this);
		MenuItemAdd.addActionListener(this);
		table.addMouseListener(this);
		textField.addKeyListener(this);
		AccountItemLogout.addActionListener(this);
		// Modify JFrame
		setTitle("Home Page");	
		setJMenuBar(mb);
		setVisible(true);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void insertTable() {
		String[] columnNames = new String[] {
				"id", "Name", "Status"
		};
		Object[][] rowData = new Object[][] {
			{1, "Name1", "Active"},
			{2, "Name2", "Not Active"},
			{3, "Name3", "Active"},
		};
		table = new JTable(rowData, columnNames);
		
		scrollPane = new JScrollPane(table);
		iframeShowStaff.add(scrollPane, BorderLayout.CENTER);
		
		ShowDetailStaff = new JPanel(new GridLayout(4,2));
		idStaff = new JLabel("-");
		nameStaff = new JLabel("-");
		statusStaff = new JLabel("-");
		mouseAction = new JLabel("-");
		
		ShowDetailStaff.add(idStaff);
		ShowDetailStaff.add(nameStaff);
		ShowDetailStaff.add(statusStaff);
		ShowDetailStaff.add(mouseAction);
		
		iframeShowStaff.add(ShowDetailStaff, BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == MenuItemShow) {
			iframeShowNews.setVisible(false);
			iframeShowStaff.setVisible(true);
			iframeAddStaff.setVisible(false);
		}
		else if (e.getSource() == menuNews) {
			iframeShowNews.setVisible(true);
			iframeShowStaff.setVisible(false);
			iframeAddStaff.setVisible(false);
		}
		else if (e.getSource() == MenuItemAdd) {
			iframeAddStaff.setVisible(true);
			iframeShowNews.setVisible(false);
			iframeShowStaff.setVisible(false);
		}
		else if (e.getSource() == AccountItemLogout) {
			int i = JOptionPane.showConfirmDialog(this, "Are You Sure About That?");
			if (i == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		idStaff.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
		nameStaff.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
		statusStaff.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseAction.setText("Mouse Enter");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		idStaff.setText("-");
		nameStaff.setText("-");
		statusStaff.setText("-");
		mouseAction.setText("Mouse Exited");
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		String name = textField.getText();
		
	}

}
