
//Christopher Cano CS 455 PA4 Extra Credit

/*
----------CourseMenu---------------------------
+ main(String[]): void
+ showOptions(): void
+ read(Department, String): void
+ addCourse(Department): void
+ removeCourse(Department): void
+ print(Department): void
+ printToFile(Department): void
+ printCourse(Department): void
+ printCourseToFile(Department): void
+ addStudent(Department): void
+ removeStudent(Department): void
+ editStudentName(Department): void
+ editStudentScores(Department): void
+ replaceScores(Department): void
+ printStudentInfo(Department): void
+ sortLastName(Department): void
+ sortAvgScore(Department): void
+ sortCourse(Department): void
-----------------------------------------------
 */

//EC --> added to extra credit assignment
import java.util.*;
import java.io.*;
public class Menu {//error check id
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("What college or university is this department part of?");
		String collegeName = in.nextLine();
		System.out.println("What department(Electrical Engineering, Computer Science, Art, Communications...etc.) are you going to add courses to? ");
		String departmentName = in.nextLine();
		System.out.println("What school is the department part of?");
		String schoolName = in.nextLine();
		Department myDepartment = new Department(collegeName, departmentName, schoolName);
		
		
		while(true){
			
			showOptions();
			String choices = in.next();
			
			String readFile = "r";
			String printToMonitor = "p";
			String printCourse = "pc";
			String printCourseToFile = "pcf";
			String printToFile = "pf";
			String printStuInfo = "pi";
			String addCourse = "ac";
			String removeCourse = "rc";
			String addStudent = "a";
			String removeStudent = "rs";
			String editName = "en";
			String editScores = "es";
			String replaceScores = "rg";
			String sortLastName = "s";
			String sortAvgScore = "sa";
			String sortCourse = "sc";
			String quit = "q";
			
			if(choices.equalsIgnoreCase(readFile)){
			
				System.out.println("What file do you want to read and analyze? ");
				
				String fileName = in.next();
				read(myDepartment,fileName);
			}
			else if(choices.equalsIgnoreCase(addCourse)){
				
				addCourse(myDepartment);
			}
			else if(choices.equalsIgnoreCase(removeCourse)){
				
				removeCourse(myDepartment);
			}
			else if(choices.equalsIgnoreCase(printToMonitor)){
				
				print(myDepartment);
			}
			else if(choices.equalsIgnoreCase(printToFile)){
				
				printToFile(myDepartment);
			}
			else if(choices.equalsIgnoreCase(printCourse)){
				
				printCourse(myDepartment);
			}
			else if(choices.equalsIgnoreCase(printCourseToFile)){
				
				printCourseToFile(myDepartment);
			}
			else if(choices.equalsIgnoreCase(printStuInfo)){
				
				printStudentInfo(myDepartment);
			}
			else if(choices.equalsIgnoreCase(addStudent)){
				
				addStudent(myDepartment);
			}
			else if(choices.equalsIgnoreCase(removeStudent)){
				
				removeStudent(myDepartment);
			}
			else if(choices.equalsIgnoreCase(editName)){
				
				editStudentName(myDepartment);
			}
			else if(choices.equalsIgnoreCase(editScores)){
				
				editStudentScores(myDepartment);
			}
			else if(choices.equalsIgnoreCase(replaceScores)){
				
				replaceScores(myDepartment);
			}
			else if(choices.equalsIgnoreCase(sortLastName)){
				
				sortLastName(myDepartment);
			}
			else if(choices.equalsIgnoreCase(sortAvgScore)){
				
				sortAvgScore(myDepartment);
			}
			else if(choices.equalsIgnoreCase(sortCourse)){
				
				sortCourse(myDepartment);
			}
			else if(choices.equalsIgnoreCase(quit)){
				
				System.exit(0);
			}
			else{
				
				System.out.println("Not a valid command, choose one from below.");
			}
		}
	}
	
	public static void showOptions(){
		
		System.out.println("\nChoose a command by entering one of the commands by typing its corresponding alphabetical letter(s) and pressing enter:"
				+ "\nr - Read a file of course contents. Course will be added to department list."
				+ "\nac - Add a course."
				+ "\nrc - Remove a course."
				+ "\np - Print department info (course list) contents to the monitor."
				+ "\na - Add a student to a particular course."
				+ "\nrs - Remove a student from a particular course."
				+ "\npc - Print a particular course's content to the monitor."
				+ "\npcf - Print a partiular course's content to a file."
				+ "\npf - Print department info (course list) to file."
				+ "\npi - Print an individual student's info of a particular course."
				+ "\nen - Edit a student's name of a particular course."
				+ "\nes - Edit a student's grades of a particular course."
				+ "\nrg - Replace a student's grades with a new list."
				+ "\ns - Sort list of students in a course into alphabetical order by last name."
				+ "\nsa - Sort list of students in a course by descending average score."
				+ "\nsc - Sort list of Courses by course number."
				+ "\nq - Quit and exit the program.");
		
	}
	
	public static void read(Department department, String fileName){
		
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
			int courseUnit = in.nextInt();
			in.nextLine();
			String courseTimeAndDay = in.nextLine(); //EC
			String courseProf = in.nextLine(); //EC
			
			Course course = new Course();
			course.setName(courseName);
			course.setId(courseId);//EC
			course.setCourseNum(courseNum);//EC
			//course.setId(courseId);
			course.setLoc(courseLocation);
			course.setCourseUnit(courseUnit);//EC
			course.setProfessor(courseProf); //EC
			course.setTimeAndDay(courseTimeAndDay); //EC
			
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
			department.addCourse(course);
			System.out.println("File read!");
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static void addCourse(Department department){
		
		Course newCourse = new Course();
		department.addCourse(newCourse.readCourse());
		System.out.println("Course added!");
	}
	
	public static void removeCourse(Department department){
		
		department.removeCourse();
	}
	
	public static void print(Department department){
		
		department.print();
	}
	
	public static void printToFile(Department department){
		
		department.printToFile();
	}
	
	public static void printCourse(Department department){
		
		department.coursePrint();
	}
	
	public static void printCourseToFile(Department department){
		
		department.coursePrintToFile();
	}
	
	public static void addStudent(Department department){
		
		department.addStudent();
	}
	
	public static void removeStudent(Department department){
		
		department.removeStudent();
	}
	
	public static void editStudentName(Department department){
		
		department.editStudentName();
	}
	
	public static void editStudentScores(Department department){
		
		department.editStudentScores();
	}
	
	public static void replaceScores(Department department){
		
		department.replaceStudentScores();
	}
	
	public static void printStudentInfo(Department department){
		
		department.printStuInfo();
	}
	
	public static void sortLastName(Department department){
		
		department.sortLastName();
	}
	
	public static void sortAvgScore(Department department){
		
		department.sortAvgScore();
	}
	
	public static void sortCourse(Department department){
		
		department.bubbleSortCourseNum(department);
	}

}
