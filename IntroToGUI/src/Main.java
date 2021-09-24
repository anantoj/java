import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;


public class Main extends JFrame{
	JPanel mainPanel, northPanel, southPanel, genderPanel;
	JLabel titleLabel, usernameLabel, passLabel, addressLabel, genderLabel, educationLabel, ageLabel, hobbyLabel;
	JTextField usernameInput;
	JPasswordField passInput;
	JTextArea addressInput;
	JRadioButton maleBtn, femaleBtn;
	ButtonGroup genderGroup;
	JComboBox educationComboBox;
	Vector<String> education, hobby, monthVec;
	JSpinner ageSpinner;
	SpinnerListModel month;
	JList hobbyList;
	JCheckBox tnc;
	JButton registerBtn;
	
	public Main() {
		// Initialize Frame (BorderLayout is actually already default)
		setLayout(new BorderLayout()); 
		
		// Initialize Panels
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(8, 2, 10, 10));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		// Register Title
		titleLabel = new JLabel("REGISTER"); // Label = Texts
		titleLabel.setFont(new Font("calibri", Font.BOLD, 28));
		titleLabel.setForeground(Color.blue);
		northPanel.add(titleLabel);
		
		// Username Text Field
		usernameLabel = new JLabel("Username");
		usernameInput = new JTextField();
		mainPanel.add(usernameLabel);
		mainPanel.add(usernameInput);
		
		// Password
		passLabel = new JLabel("Password");
		passInput = new JPasswordField();
		mainPanel.add(passLabel);
		mainPanel.add(passInput);
		
		// Address Text Area
		addressLabel = new JLabel("Address");
		addressInput = new JTextArea();
		mainPanel.add(addressLabel);
		mainPanel.add(addressInput);
		
		// Create a separate panel to fix layout
		genderPanel = new JPanel();
		genderPanel.setLayout(new GridLayout(1,2));
		
		// Gender Radio Button
		genderLabel = new JLabel("Gender");
		maleBtn = new JRadioButton("Male");
		femaleBtn = new JRadioButton("Female");
		genderPanel.add(maleBtn);
		genderPanel.add(femaleBtn);
		
		mainPanel.add(genderLabel);
		mainPanel.add(genderPanel);
		
		// Button Group so only 1 can be selected
		genderGroup = new ButtonGroup();
		genderGroup.add(maleBtn);
		genderGroup.add(femaleBtn);
		
		// Education Combo Box
		// First Create vector
		educationLabel = new JLabel("Education");
		
		education = new Vector<>();
		education.add("Elementary");
		education.add("Middle");
		education.add("High");
		
		// Add Vector to Combo Box
		educationComboBox = new JComboBox(education);
		mainPanel.add(educationLabel);
		mainPanel.add(educationComboBox);
		
		// Age Spinner 
		ageLabel = new JLabel("Age");
		
		// This is optional, can remove monthVec and month SpinnerListModel
		monthVec = new Vector<String>();
		monthVec.add("May");
		monthVec.add("June");
		monthVec.add("July");
		month = new SpinnerListModel(monthVec);
		
		ageSpinner = new JSpinner(month); // Parameter here is optional
		mainPanel.add(ageLabel);
		mainPanel.add(ageSpinner);
		
		// Hobby List
		hobbyLabel = new JLabel("Hobbies");
		hobby = new Vector<String>();
		hobby.add("eat");
		hobby.add("sleep");
		
		hobbyList = new JList(hobby);
		
		mainPanel.add(hobbyLabel);
		mainPanel.add(hobbyList);
		
		// TNC Checkbox
		tnc = new JCheckBox("I Agree with the tnc");
		mainPanel.add(tnc);
		
		// Button
		registerBtn = new JButton("Register");
		southPanel.add(registerBtn);
		
		
		// Add panels to Frame
		add(northPanel,BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
	
		// Frame and GUI Setting
		setVisible(true);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();

	}

}
