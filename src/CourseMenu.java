//Christopher Cano CS 455 PA4

/*
----------CourseMenu---------------------------
+ main(String[]): void
+ read(Course, String): void
+ print(Course): void
+ printToFile(Course): void
+ addStudent(Course, Scanner): void
+ removeStudent(Course, Scanner): void
+ editStudentName(Course, Scanner): void
+ editStudentScores(Course, Scanner): void
+ replaceScores(Course, Scanner): void
+ printStudentInfo(Course, Scanner): void
+ sortLastName(Course): void
+ sortAvgScore(Course): void
-----------------------------------------------
 */
import java.util.*;
import java.io.*;
public class CourseMenu {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		Course myCourse = new Course();
		
		while(true){
			
			System.out.println("\nChoose a command by entering one of the commands by typing its corresponding alphabetical letter(s) and pressing enter:"
								+ "\nr - Read a file."
								+ "\np - Print file contents to the monitor."
								+ "\na - Add a student."
								+ "\nrs - Remove a student."
								+ "\npf - Print to file."
								+ "\npi - Print individual student info."
								+ "\nen - Edit a student's name."
								+ "\nes - Edit a student's grades."
								+ "\nrg - Replace a student's grades with a new list."
								+ "\ns - Sort list of students into alphabetical order by last name."
								+ "\nsa - Sort list of students by descending average score."
								+ "\nq - Quit and exit the program.");
			
			String choices = in.next();
			
			String readFile = "r";
			String printToMonitor = "p";
			String printToFile = "pf";
			String printStuInfo = "pi";
			String addStudent = "a";
			String removeStudent = "rs";
			String editName = "en";
			String editScores = "es";
			String replaceScores = "rg";
			String sortLastName = "s";
			String sortAvgScore = "sa";
			String quit = "q";
			
			if(choices.equalsIgnoreCase(readFile)){
			
				System.out.println("What file do you want to read and analyze? ");
				
				String fileName = in.next();
				read(myCourse,fileName);
			}
			else if(choices.equalsIgnoreCase(printToMonitor)){
				
				print(myCourse);
			}
			else if(choices.equalsIgnoreCase(printToFile)){
				
				printToFile(myCourse);
			}
			else if(choices.equalsIgnoreCase(printStuInfo)){
				
				printStudentInfo(myCourse, in);
			}
			else if(choices.equalsIgnoreCase(addStudent)){
				
				addStudent(myCourse,in);
			}
			else if(choices.equalsIgnoreCase(removeStudent)){
				
				removeStudent(myCourse,in);
			}
			else if(choices.equalsIgnoreCase(editName)){
				
				editStudentName(myCourse, in);
			}
			else if(choices.equalsIgnoreCase(editScores)){
				
				editStudentScores(myCourse, in);
			}
			else if(choices.equalsIgnoreCase(replaceScores)){
				
				replaceScores(myCourse, in);
			}
			else if(choices.equalsIgnoreCase(sortLastName)){
				
				sortLastName(myCourse);
			}
			else if(choices.equalsIgnoreCase(sortAvgScore)){
				
				sortAvgScore(myCourse);
			}
			else if(choices.equalsIgnoreCase(quit)){
				
				System.exit(0);
			}
			else{
				
				System.out.println("Not a valid command, choose one from below.");
			}
		}
	}
	
	public static void read(Course course, String fileName){
		
		try{
			
			File file = new File(fileName);
			Scanner in = new Scanner(file);
			
			String courseName = in.nextLine();
			courseName = courseName.trim();
			String courseInfo = in.nextLine();//String courseId = in.nextLine();
			Scanner idScanner = new Scanner(courseInfo);//EC
			String courseId = idScanner.next();//EC
			int courseNum = idScanner.nextInt();//EC
			//courseId = courseId.trim();
			String courseLocation = in.nextLine();
			courseLocation = courseLocation.trim();
			
			course.setName(courseName);
			course.setId(courseId);//EC
			course.setCourseNum(courseNum);//EC
			//course.setId(courseId);
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
	
	public static void print(Course course){
		
		course.print();
	}
	
	public static void printToFile(Course course){
		
		course.printToFile();
	}
	
	public static void addStudent(Course course, Scanner in){
		
		System.out.println("Enter the last name of the student you want to add: ");
		String lastName = in.next();
		System.out.println("Enter the first name of the student you want to add: ");
		String firstName = in.next();
		System.out.println("What is his/her ID number?");
		long id = in.nextLong();
		Student newStudent = new Student(firstName, lastName, id);
		newStudent.readScore();
		course.addStudent(newStudent);
		
	}
	
	public static void removeStudent(Course course, Scanner in){
		
		System.out.println("Enter the last name of the student you want to remove: ");
		String lastName = in.next();
		System.out.println("Enter the first name of the student you want to remove: ");
		String firstName = in.next();
		course.removeStudent(lastName, firstName);
		
	}
	
	public static void editStudentName(Course course, Scanner in){
		
		System.out.println("Enter the last name of the student whose name you want to edit: ");
		String lastName = in.next();
		System.out.println("Enter the first name of the student whose name you want to edit: ");
		String firstName = in.next();
		course.editName(lastName, firstName);
	}
	
	public static void editStudentScores(Course course, Scanner in){
		
		System.out.println("Enter the last name of the student whose grades you want to edit: ");
		String lastName = in.next();
		System.out.println("Enter the first name of the student whose grades you want to edit: ");
		String firstName = in.next();
		course.editScores(lastName, firstName);
	}
	
	public static void replaceScores(Course course, Scanner in){
		
		System.out.println("Enter the last name of the student whose grades you want to replace: ");
		String lastName = in.next();
		System.out.println("Enter the first name of the student whose grades you want to replace: ");
		String firstName = in.next();
		course.replaceAllScores(lastName, firstName);
	}
	
	public static void printStudentInfo(Course course, Scanner in){
		
		System.out.println("Enter the last name of the student whose info you want to edit: ");
		String lastName = in.next();
		System.out.println("Enter the first name of the student whose info you want to edit: ");
		String firstName = in.next();
		course.printStuInfo(lastName, firstName);
	}
	
	public static void sortLastName(Course course){
		
		course.bubbleSortLastName(course.getStuList());
	}
	
	public static void sortAvgScore(Course course){
		
		course.bubbleSortAvgScore(course.getStuList());
	}

}