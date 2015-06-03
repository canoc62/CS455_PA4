
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CourseMenuFrame extends JFrame {
	
	private JTextField label;
	private JTextField label2;
	private JTextField label3;
	private JPasswordField passwordField;
	
	public CourseMenuFrame(){
		
		super("Course Editor");
		setLayout(new FlowLayout());
		
		label = new JTextField(10);
		//label.setToolTipText("This program helps you add students and scores.");
		add(label);
		label2 = new JTextField("Enter text here: ");
		add(label2);
		label3 = new JTextField("Uneditable",20);
		label3.setEditable(false);
		add(label3);
		
		passwordField = new JPasswordField("mypass");
		add(passwordField);
		
		
	}

}
