import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class CourseMenuViewer {

	private static final int FRAME_WIDTH = 100;
	private static final int FRAME_HEIGHT = 100;
	
	public static void main(String[] args){
		
		
		CourseMenuFrame menu = new CourseMenuFrame();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setSize(275,280);
		menu.setVisible(true);
		/*Course myCourse = new Course();
		
		JFrame frame = new JFrame();
		
		JButton readButton = new JButton("Read File");
		JButton printMonitorButton = new JButton("Print to Monitor");
		JButton printToFileButton = new JButton("Print to File");
		JButton printStudentInfoButton = new JButton("Print Student Info");
		JButton addStudentButton = new JButton("Add Student");
		JButton removeStudentButton = new JButton("Remove Student");
		JButton editScoresButton = new JButton("Edit Scores");
		JButton replaceScoresButton = new JButton("Replace Scores");
		JButton editNameButton = new JButton("Print Student Info");
		JButton sortButton = new JButton("Sort Student List");
		JButton quitButton = new JButton("Quit Program");*/
		
		/*ButtonGroup group = new ButtonGroup();
		
		group.add(readButton);
		group.add(printMonitorButton);
		group.add(printToFileButton);
		group.add(printStudentInfoButton);
		group.add(addStudentButton);
		group.add(removeStudentButton);
		group.add(editScoresButton);
		group.add(replaceScoresButton);
		group.add(editNameButton);
		group.add(sortButton);
		group.add(quitButton);*/
		
		/*class readListener implements ActionListener{
			
			public void actionPerformed(ActionEvent event){
				
				
			}
			
		}*/
		
		
		
		
	}
	
	public static void read(Course course, String fileName){
		
		try{
			
			File file = new File(fileName);
			Scanner in = new Scanner(file);
			
			String courseName = in.nextLine();
			courseName = courseName.trim();
			String courseId = in.nextLine();
			courseId = courseId.trim();
			String courseLocation = in.nextLine();
			courseLocation = courseLocation.trim();
			
			course.setName(courseName);
			course.setId(courseId);
			course.setLoc(courseLocation);
			
			while(in.hasNextLine()){
				
				String stuName = in.nextLine();
				Scanner in2 = new Scanner(stuName);
				
				String firstName = in2.next();
				String lastName = in2.next();
				//stuName = stuName.trim();
				
				String numericInfo = in.nextLine();
				Scanner in3 = new Scanner(numericInfo);
				
				long stuId = in3.nextLong();
				
				Student newStu = new Student(firstName, lastName, stuId);
				
				int count = 0;
				int maxNumScore = 8;
				while(in3.hasNextInt()){
					
					int newScore = in3.nextInt();
					newStu.addScore(newScore);
					count++;
					if(count == maxNumScore){
						break;
					}
				}
				
				course.addStudent(newStu);
			}
			
			System.out.println("File read!");
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
