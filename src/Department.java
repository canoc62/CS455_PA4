//Christopher Cano PA4 Extra Credit

/*
------------------Department-------------------------
- courseLst: ArrayList<Course>
- college: string
- department: string
- school: string
-----------------------------------------------------
+ Department()
+ Department(string,string,string)
+ Department(Department)
+ setCollege(string): void
+ setDepartment(string): void
+ setSchoolName(string): void
+ getCourseList(): ArrayList<Course>
+ getCollege(): string
+ getDepartment(): string
+ getSchool(): string
+ addCourse(Course): void
+ removeCourse(): void
+ addStudent(): void
+ removeStudent(): void
+ searchNum(int): boolean
+ searchId(int): boolean
+ toString(): string
+ print(): void
+ printToFile(): void
+ printListOfCourses(): void
+ coursePrint(): void
+ coursePrintToFile(): void
+ editStudentName(): void
+ editStudentScores(): void
+ replaceStudentScores(): void
+ printStuInfo(): void
+ sortLastName(): void
+ sortAvgScore(): void
+ readCourseId(): string
+ readCourseNum(): int
+ bubbleSortCourseNum(Department): void
----------------------------------------------------------
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class Department {
	
	private ArrayList<Course> courseList;
	private String college;
	private String department;
	private String school;
	
	public Department(){
		
		college = "";
		department = "";
		school = "";
		courseList = new ArrayList<Course>();
	}
	
	public Department(String collegeName, String departmentName, String theSchoolName){
		
		college = collegeName;
		department = departmentName;
		school = theSchoolName;
		courseList = new ArrayList<Course>();
	}
	
	public Department(Department otherDepartment){
		
		college = otherDepartment.college;
		department = otherDepartment.department;
		school = otherDepartment.school;
		courseList = otherDepartment.courseList;
	}
	
	public void setCollege(String name){
		
		college = name;
	}
	
	public void setDepartment(String name){
		
		department = name;
	}
	
	public void setSchoolName(String name){
		
		school = name;
	}
	
	public ArrayList<Course> getCourseList(){
		
		return courseList;
	}
	
	public String getCollege(){
		
		return college;
	}
	public String getDepartment(){
		
		return department;
	}
	
	public String getSchool(){
		
		return school;
	}
	
	public void addCourse(Course newCourse){
		
		courseList.add(newCourse);
	}
	
	public void removeCourse(){
		
		String courseId = readCourseId();
		int courseNum = readCourseNum();
		if(searchId(courseId) == true && searchNum(courseNum) == true){
			
			for(int i = 0; i<courseList.size(); i++){
				
				if(courseList.get(i).getCourseId().equalsIgnoreCase(courseId) && courseList.get(i).getCourseNum() == courseNum){
					
					courseList.remove(courseList.get(i));
				}
			}
		}
	}
	
	public void addStudent(){
		
		String courseId = readCourseId();
		int courseNum = readCourseNum();
		if(searchId(courseId) == true && searchNum(courseNum) == true){
			
			for(int i = 0; i<courseList.size(); i++){
				
				if(courseList.get(i).getCourseId().equalsIgnoreCase(courseId) && courseList.get(i).getCourseNum() == courseNum){
					
					Scanner in = new Scanner(System.in);
					System.out.println("Enter the last name of the student you want to add: ");
					String lastName = in.next();
					System.out.println("Enter the first name of the student you want to add: ");
					String firstName = in.next();
					System.out.println("What is his/her ID number?");
					long id = 0;
					while(true){
						
						if(in.hasNextInt()){
						
							id = in.nextLong();
							break;
						}
						else{
						
							System.out.println("Input for courseNum not a value of type long, please enter a value of type long: ");
							in.next();
						}
					}
					Student newStudent = new Student(firstName, lastName, id);
					newStudent.readScore();
					courseList.get(i).addStudent(newStudent);
				}
			}
		}
		else{
			
			System.out.println("Course does not exist or has not been read in.");
		}
	}
	
	public void removeStudent(){
		
		String courseId = readCourseId();
		int courseNum = readCourseNum();
		if(searchId(courseId) == true && searchNum(courseNum) == true){
			
			for(int i = 0; i<courseList.size(); i++){
				
				if(courseList.get(i).getCourseId().equalsIgnoreCase(courseId) && courseList.get(i).getCourseNum() == courseNum){
					
					Scanner in = new Scanner(System.in);
					System.out.println("Enter the last name of the student you want to remove: ");
					String lastName = in.next();
					System.out.println("Enter the first name of the student you want to remove: ");
					String firstName = in.next();
					courseList.get(i).removeStudent(lastName, firstName);
					}
				}
			}
		else{
			
			System.out.println("Course does not exist or has not been read in.");
		}
	}
	
	public boolean searchNum(int courseNum){
		
		for(int i =0; i<courseList.size(); i++){
			
			if(courseList.get(i).getCourseNum() == courseNum){
				
				return true;
			}
		}
		
		return false;
	}
	
	public boolean searchId(String id){
		
		for(int i = 0; i< courseList.size(); i++){
			
			if(courseList.get(i).getCourseId().equalsIgnoreCase(id)){
				
				return true;
			}
		}
		
		return false;
	}
	
	public String toString(){
		
		String departmentInfoHead = getCollege() + "\n" + getSchool() + "\n" + getDepartment() + "\n";
		
		String departmentInfo = "-------------------------------------------\n";
		for(int i = 0; i < courseList.size(); i++){
			
			departmentInfo += courseList.get(i).toString() + "\n";
		}
		
		departmentInfo = departmentInfoHead + departmentInfo; //+ "\nTotal " + getDepartment() + " Enrollment: " + numStudents();
		
		return departmentInfo;
	}
	
	public void print(){
		
		System.out.println(toString());
	}
	
	public void printToFile(){
		
	try{
		
		Scanner in = new Scanner(System.in);
		System.out.println("What is the name of the file you wish to print to?");
		String outFileName = in.next();
		PrintWriter writer = new PrintWriter(outFileName);//("data1b.txt");
	
		//writer.println(getCourseName() + "\n"+ getCourseId() + "\n" + getLoc() + "\nName\t\t\tID\t\t\t\tAverage\t\t\tGrade");
		writer.println(toString());
		writer.close();
		System.out.println("Printed to file!");
		}catch(FileNotFoundException e){
	
			e.printStackTrace();
		}
	}
	
	public void printListofCourses(){
		
		for(int i = 0; i < courseList.size(); i++){
			
			System.out.println(courseList.get(i).getCourseId() + " " + courseList.get(i).getCourseNum());
		}
	}
	
	public void coursePrint(){
		
		String courseId = readCourseId();
		int courseNum = readCourseNum();
		if(searchId(courseId) == true && searchNum(courseNum) == true){
			
			for(int i = 0; i<courseList.size(); i++){
				
				if(courseList.get(i).getCourseId().equalsIgnoreCase(courseId) && courseList.get(i).getCourseNum() == courseNum){
					
					courseList.get(i).print();
				}
			}
		}
		else{
			
			System.out.println("Course does not exist or has not been read in.");
		}
	}
	
	public void coursePrintToFile(){
		
		String courseId = readCourseId();
		int courseNum =  readCourseNum();
		if(searchId(courseId) == true && searchNum(courseNum) == true){
			
			for(int i = 0; i<courseList.size(); i++){
				
				if(courseList.get(i).getCourseId().equalsIgnoreCase(courseId) && courseList.get(i).getCourseNum() == courseNum){
					
					courseList.get(i).printToFile();
				}
			}
		}
		else{
			
			System.out.println("Course does not exist or has not been read in.");
		}
	}
	
	public void editStudentName(){
		
		String courseId = readCourseId();
		int courseNum = readCourseNum();
		if(searchId(courseId) == true && searchNum(courseNum) == true){
			
			for(int i = 0; i<courseList.size(); i++){
				
				if(courseList.get(i).getCourseId().equalsIgnoreCase(courseId) && courseList.get(i).getCourseNum() == courseNum){
					
					Scanner in = new Scanner(System.in);
					System.out.println("Enter the last name of the student whose name you want to edit: ");
					String lastName = in.next();
					System.out.println("Enter the first name of the student whose name you want to edit: ");
					String firstName = in.next();
					courseList.get(i).editName(lastName, firstName);
				}	
			}		
		}
		else{
			
			System.out.println("Course does not exist or has not been read in.");
		}
	}
	
	public void editStudentScores(){
		
		String courseId = readCourseId();
		int courseNum = readCourseNum();
		if(searchId(courseId) == true && searchNum(courseNum) == true){
			
			for(int i = 0; i<courseList.size(); i++){
				
				if(courseList.get(i).getCourseId().equalsIgnoreCase(courseId) && courseList.get(i).getCourseNum() == courseNum){
					
					Scanner in = new Scanner(System.in);
					System.out.println("Enter the last name of the student whose grades you want to edit: ");
					String lastName = in.next();
					System.out.println("Enter the first name of the student whose grades you want to edit: ");
					String firstName = in.next();
					courseList.get(i).editScores(lastName, firstName);
				}	
			}		
		}
		else{
			
			System.out.println("Course does not exist or has not been read in.");
		}
	}
	
	public void replaceStudentScores(){
		
		String courseId = readCourseId();
		int courseNum = readCourseNum();
		if(searchId(courseId) == true && searchNum(courseNum) == true){
			
			for(int i = 0; i<courseList.size(); i++){
				
				if(courseList.get(i).getCourseId().equalsIgnoreCase(courseId) && courseList.get(i).getCourseNum() == courseNum){
					
					Scanner in = new Scanner(System.in);
					System.out.println("Enter the last name of the student whose grades you want to replace: ");
					String lastName = in.next();
					System.out.println("Enter the first name of the student whose grades you want to replace: ");
					String firstName = in.next();
					courseList.get(i).replaceAllScores(lastName, firstName);
				}
			}
		}
	}
	
	public void printStuInfo(){
		
		String courseId = readCourseId();
		int courseNum = readCourseNum();
		if(searchId(courseId) == true && searchNum(courseNum) == true){
			
			for(int i = 0; i<courseList.size(); i++){
				
				if(courseList.get(i).getCourseId().equalsIgnoreCase(courseId) && courseList.get(i).getCourseNum() == courseNum){
					
					Scanner in = new Scanner(System.in);
					System.out.println("Enter the last name of the student whose info you want to print: ");
					String lastName = in.next();
					System.out.println("Enter the first name of the student whose info you want to print: ");
					String firstName = in.next();
					courseList.get(i).printStuInfo(lastName, firstName);
				}
			}
		}
		else{
			
			System.out.println("Course does not exist or has not been read in.");
		}
	}
	
	public void sortLastName(){
		
		String courseId = readCourseId();
		int courseNum = readCourseNum();
		if(searchId(courseId) == true && searchNum(courseNum) == true){
			
			for(int i = 0; i<courseList.size(); i++){
				
				if(courseList.get(i).getCourseId().equalsIgnoreCase(courseId) && courseList.get(i).getCourseNum() == courseNum){
					
					courseList.get(i).bubbleSortLastName(courseList.get(i).getStuList());
				}
			}
		}
		else{
			
			System.out.println("Course does not exist or has not been read in.");
		}
	}
	
	public void sortAvgScore(){
		
		String courseId = readCourseId();
		int courseNum = readCourseNum();
		if(searchId(courseId) == true && searchNum(courseNum) == true){
			
			for(int i = 0; i<courseList.size(); i++){
				
				if(courseList.get(i).getCourseId().equalsIgnoreCase(courseId) && courseList.get(i).getCourseNum() == courseNum){
					
					courseList.get(i).bubbleSortAvgScore(courseList.get(i).getStuList());
				}
			}
		}
		else{
			
			System.out.println("Course does not exist or has not been read in.");
		}
	}
	
	public String readCourseId(){
		
		print();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the course ID (EE, CSCI, etc...) of the course you would like to add a student to:");
		String courseId = in.next();
	
		return courseId;
	}
	
	public int readCourseNum(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the course number (101, 202, etc...) of the course you would like to add a student to:");
		int courseNum = 0;
		while(true){
			
			if(in.hasNextInt()){
			
				courseNum = in.nextInt();
				break;
			}
			else{
			
				System.out.println("Input for courseNum not an integer, please enter an integer: ");
				in.next();
			}
		}
		return courseNum;
	}
	
	public void bubbleSortCourseNum(Department department){
		
		boolean checkSwap = true;
		int j = 0;
		
		while(checkSwap){
			checkSwap = false;
			j++;
			
			for(int i = 0; i < courseList.size() - j; i++){
				
				if(courseList.get(i).getCourseNum() > courseList.get(i+1).getCourseNum()){
				
					Course temp = courseList.get(i);
					courseList.set(i,courseList.get(i+1));
					courseList.set(i+1, temp);
					checkSwap = true;
				}
			}
		}
		
		System.out.println("Course list sorted by descending course number!");
	}
}
