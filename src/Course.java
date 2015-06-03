//Christopher Cano CS455 PA4 Extra Credit

/* EC= added to extra credit assignment
--------------------Course--------------------
- courseName: String
- courseId: String
- courseNum: int //EC
- courseUnits: int //EC
- location: String
- professor: String //EC
- timeAndDay: int //EC
- stuList: ArrayList<Student>
- average: double
- courseStuTot: int
----------------------------------------------
+ Course()
+ Course(String, String, String)
+ Course(Course)
+ getCourseName(): String
+ getLoc(): String
+ getCourseId(): String // Ex. Electrical Engineering - "EE"
+ getCourseNum(): int //EC Ex. EE "101"
+ getCourseUnit(): int //EC
+ getProfessor(): String
+ getTimeAndDay(): String
+ getStuList(): ArrayList<Student>
+ getAverage(): double
+ setName(String): void
+ setId(String): void
+ setCourseNum(int): void //EC
+ setCourseUnit(int): void //EC
+ setLoc(String): void
+ setProfessor(String): void //EC
+ setTimeAndDay(String): void //EC
- calcAvg(): void
+ search(String): boolean //searches list of students by last name
+ searchFirst(String): boolean //searches list of students by first name
+ addStudent(Student): void
+ removeStudent(String, String): void
+ editName(String, String): void // choice to edit first and last name or do nothing at all.
+ replaceAllScores(String, String): void //reads in a new list of scores for a single student
+ editScores(String, String): void //adds or removes a score one at a time for a student
+ printStuInfo(String, String): void //prints a single student's info, including list of scores
+ print(): void // prints course info to monitor
+ toString(): String
+ printToFile(): void //prints course info to a file
- format(double): String
+ bubbleSortLastName(ArrayList<Student>): void //sorts list of students by alphabetical order of last name
+ bubbleSortAvgScore(ArrayList<STudent>): void //sorts list of students by descending average score
+ readCourse(): Course
-----------------------------------------------
 */

import java.util.*;
import java.io.*;
import java.text.*;
//EC = added on to extra credit
public class Course {
	
	private String courseName;
	private String courseId;
	private int courseNum;//EC
	private int courseUnit; //EC
	private String location;
	private String professor; //EC
	private String timeAndDay; //EC
	private ArrayList<Student> stuList;
	private double average;
	private int courseStuTot;
	
	public Course(){
		
		courseName = "";
		courseId= "";
		courseNum = 0;//EC
		courseUnit = 0;//EC
		location = "";
		professor = "";//EC
		timeAndDay = "";//EC
		stuList = new ArrayList<Student>();
		calcAvg();
	}
	
	public Course(String name, String iD, int num, int unit,  String loc, String prof, String timeDay){
		
		courseName = name;
		courseId = iD;
		courseNum = num;//EC
		courseUnit = unit; //EC
		location = loc;
		professor = prof;//EC
		timeAndDay = timeDay;//EC
		stuList = new ArrayList<Student>();
		calcAvg();
	}
	
	public Course(Course course){
		
		courseName = course.courseName;
		courseId = course.courseId;
		courseNum = course.courseNum;//EC
		courseUnit = course.courseUnit; //EC
		location = course.location;
		professor = course.professor;//EC
		timeAndDay = course.timeAndDay;//EC
		stuList = course.stuList;
		calcAvg();
	}

	public String getCourseName(){
		
		return courseName;
	}
	
	public String getLoc(){
		
		return location;
	}
	
	public String getCourseId(){
		
		return courseId;
	}
	
	public int getCourseNum(){//EC
		
		return courseNum;
	}
	
	public int getCourseUnit(){//EC
		
		return courseUnit;
	}
	
	public String getProfessor(){//EC
		
		return professor;
	}
	
	public String getTimeAndDay(){//EC
		
		return timeAndDay;
	}
	public ArrayList<Student> getStuList(){
		
		return stuList;
	}
	
	public double getAverage(){
		
		calcAvg();
		return average;
	}
	
	public void setName(String name){
		
		courseName = name;
	}
	
	public void setId(String newId){
		
		courseId = newId;
	}
	
	public void setCourseNum(int num){//EC
		
		courseNum = num;
	}
	
	public void setCourseUnit(int unit){//EC
		
		courseUnit = unit;
	}
	
	public void setLoc(String loc){
		
		location = loc;
	}
	
	public void setProfessor(String prof){//EC
		
		professor = prof;
	}
	
	public void setTimeAndDay(String timeDay){//EC
		
		timeAndDay = timeDay;
	}
	
	private void calcAvg(){
		
		courseStuTot = 0;
		int courseTotScore= 0;
		for(int i =0;i<stuList.size();i++){
			
			if(stuList.get(i).getScoreList().size() >=6 && stuList.get(i).isValidScoreList() == true){
				courseTotScore+= stuList.get(i).getTot();
				courseStuTot++;
			}
		}
		
		int numScorePer = 6; //maximum number of scores per student that can be used for average calculation
		average = (double)courseTotScore/(numScorePer*courseStuTot);
	}
	
	public boolean search(String lastName){
		
		for(int i =0;i<stuList.size();i++){
			
			if(stuList.get(i).getLastName().equalsIgnoreCase(lastName)){
				
				return true;
			}
			else{
			
			}
		}
		
		return false;
	}
	
	public boolean searchFirst(String firstName){
		
		for(int i =0;i<stuList.size();i++){
			
			if(stuList.get(i).getFirstName().equalsIgnoreCase(firstName)){
				
				return true;
			}
			else{
		
			}
		}
		
		return false;
	}
	
	public void addStudent(Student newStudent){
		
		if(search(newStudent.getLastName()) == true && searchFirst(newStudent.getFirstName())== true){
			
			boolean check = false;
			for(int i =0;i<stuList.size();i++){
				
				 if(stuList.get(i).getLastName().equalsIgnoreCase(newStudent.getLastName()) && stuList.get(i).getFirstName().equalsIgnoreCase(newStudent.getFirstName())){
					
				 	System.out.println("Cannot add student because student is already in class.");
				 	check = true;
				 	break;
				 }
			}
			if(check == false){
				
				stuList.add(newStudent);
				System.out.println("Student added!");
			}
		}
		else{
			
			stuList.add(newStudent);
			System.out.println("Student added!");
		}
		
	}
	
	public void removeStudent(String lastName, String firstName){
		
		if(search(lastName) == true && searchFirst(firstName)== true){
			
			boolean check = false;
			for(int i =0;i<stuList.size();i++){
				
				if(stuList.get(i).getLastName().equalsIgnoreCase(lastName) && stuList.get(i).getFirstName().equalsIgnoreCase(firstName)){
					
					stuList.remove(stuList.get(i));
					System.out.println("Student removed!");
					check = true;
					break;
				}
			}
			if(check == false){
				
				System.out.println("Cannot remove student because student is not part of the list.");
			}
		}
		else{
				
			System.out.println("Cannot remove student because student is not part of the list.");
		}
	}
	
	public void editName(String lastName, String firstName){
		
		if(search(lastName) == true && searchFirst(firstName) == true){
			
			for(int i = 0; i< stuList.size();i++){
				
				if(stuList.get(i).getLastName().equalsIgnoreCase(lastName) && stuList.get(i).getFirstName().equalsIgnoreCase(firstName)){
					
					Scanner in = new Scanner(System.in);
					
					System.out.println("Would you like to change his or her first name? Enter \"yes\" or \"no\": ");
					
					String answerOne = in.next();
					if(answerOne.equalsIgnoreCase("yes")){
						
						stuList.get(i).changeFirstName();
					}
					else if(answerOne.equalsIgnoreCase("no")){
						
						System.out.println("OK. First name unchanged.");
					}
					else{
						
						System.out.println("You did not enter \"yes\" or \"no\", I assume you did not want to change his or her first name.");
					}
					
					System.out.println("Would you like to change his or her last name? Enter \"yes\" or \"no\": ");
					
					String answerTwo = in.next();
					if(answerTwo.equalsIgnoreCase("yes")){
						
						stuList.get(i).changeLastName();
					}
					else if(answerTwo.equalsIgnoreCase("no")){
						
						System.out.println("OK. Last name unchanged.");
					}
					else{
						
						System.out.println("You did not enter \"yes\" or \"no\", I assume you did not want to change his or her last name.");
					}
				}
				else if(i == stuList.size() && !stuList.get(i).getLastName().equalsIgnoreCase(lastName) && !stuList.get(i).getFirstName().equalsIgnoreCase(firstName)){
					
					System.out.println("This student is not on the list.");
				}
			}
		}
		else{
			
			System.out.println("This student is not on the list.");
		}
	}
	
	public void replaceAllScores(String lastName, String firstName){
		
		if(search(lastName) == true && searchFirst(firstName) == true){
			
			for(int i = 0; i< stuList.size();i++){
				
				if(stuList.get(i).getLastName().equalsIgnoreCase(lastName) && stuList.get(i).getFirstName().equalsIgnoreCase(firstName)){
					
					stuList.get(i).readScore();
				}
			}
		}
		else{
			
			System.out.println("This student is not part of the list.");
		}
	}
	
	public void editScores(String lastName, String firstName){
		
		if(search(lastName) == true && searchFirst(firstName) == true){
			
			for(int i = 0; i< stuList.size();i++){
				
				if(stuList.get(i).getLastName().equalsIgnoreCase(lastName) && stuList.get(i).getFirstName().equalsIgnoreCase(firstName)){
					
					Scanner in = new Scanner(System.in);
					System.out.println("Would you like to add or remove a grade? Enter \"add\" or \"remove\" ");
					String answer = in.next();
					if(answer.equalsIgnoreCase("add")){
							
						stuList.get(i).addGradeToList();
					}
					else if(answer.equalsIgnoreCase("remove")){
						
						System.out.println("What score would you like to remove from " + stuList.get(i).getFirstName() + " " +  stuList.get(i).getLastName() + "'s list of scores shown below?");
						stuList.get(i).printScores();
						
						stuList.get(i).removeGradeFromList();
					}
					else{
						
						System.out.println("Neither of the presented options, \"add\" or \"remove\" was not entered, no action taken.");
					}
				}
			}
		}
		else{
			
			System.out.println("This student is not part of the list.");
		}
	}
	
	public void printStuInfo(String lastName, String firstName){
		
		System.out.println(toString());
		if(search(lastName) == true && searchFirst(firstName) == true){
			
			for(int i = 0; i< stuList.size();i++){
				
				if(stuList.get(i).getLastName().equalsIgnoreCase(lastName) && stuList.get(i).getFirstName().equalsIgnoreCase(firstName)){
					
					stuList.get(i).printScores();
					}
				}
			}
		else{
			
			System.out.println("This student is not part of the list.");
			}
		}
	
	public void print(){
		
		System.out.println(toString());
		System.out.println("Name\t\t\tID\t\t\t\tAverage\t\t\tGrade");
		for(int i = 0; i<stuList.size();i++){
			
			stuList.get(i).print();
		}
		
		//take out before turning in, not supposed to have
	//	String courseAverage = format(getAverage());
		//System.out.println("\nClass Average for " + courseStuTot + " student(s):\t" + courseAverage);
	}
	
	public String toString(){
		
		String generalInfo = getCourseId() + " " + getCourseNum() + "\n" + getCourseName() + "\nUnits: " + getCourseUnit() + "\nLocation: " + getLoc() + "\nSchedule: "+ getTimeAndDay() + "\nProfessor: " + getProfessor() + "\nRegistered: " + getStuList().size() + " student(s)\n";
		
		return generalInfo;
	}
	
	public void printToFile(){
		
		try{
			Scanner in = new Scanner(System.in);
			System.out.println("What is the name of the file you wish to print to?");
			String outFileName = in.next();
			PrintWriter writer = new PrintWriter(outFileName);//("data1b.txt");
		
			writer.println(getCourseName() + "\n"+ getCourseId() + "\n" + getLoc() + "\nName\t\t\tID\t\t\t\tAverage\t\t\tGrade");
		
			for(int i = 0; i<stuList.size();i++){
			
				writer.println(stuList.get(i).toString());
			}
		
			String courseAverage = format(getAverage());
			writer.println("\nClass Average for " + courseStuTot + " student(s):\t" + courseAverage);
			writer.close();
			System.out.println("Printed to file!");
			}catch(FileNotFoundException e){
		
				e.printStackTrace();
			}
		}
	
	private String format(double value){
		
		NumberFormat gradeRep = new DecimalFormat();
		gradeRep = new DecimalFormat("0.00");
		String newFormat = gradeRep.format(value);
		
		return newFormat;
	}
	
	public void bubbleSortLastName(ArrayList<Student> stuList){
		
		boolean checkSwap = true;
		int j = 0;
		
		while(checkSwap){
			checkSwap = false;
			j++;
			
			for(int i = 0; i < stuList.size() - j; i++){
				
				if(stuList.get(i).getLastName().compareTo(stuList.get(i+1).getLastName()) > 0){
					
					Student temp = stuList.get(i);
					stuList.set(i,stuList.get(i+1));
					stuList.set(i+1, temp);
					checkSwap = true;
				}
			}
		}
		
		System.out.println("List sorted by last name, alphabetical order!");
	}
	
	public void bubbleSortAvgScore(ArrayList<Student> stuList){
		
		boolean checkSwap = true;
		int j = 0;
		
		while(checkSwap){
			checkSwap = false;
			j++;
			
			for(int i = 0; i < stuList.size() - j; i++){
				
				if(stuList.get(i).getAvg() < stuList.get(i+1).getAvg()){
				
					Student temp = stuList.get(i);
					stuList.set(i,stuList.get(i+1));
					stuList.set(i+1, temp);
					checkSwap = true;
				}
			}
		}
		
		System.out.println("List sorted by average score, highest to lowest!");
	}
	
	public Course readCourse(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("What is the name of this course?");
		String courseName = in.nextLine();
		System.out.println("What is the id for this course (ex. Computer Science id - CSCI)?");
		String courseId = in.next();
		System.out.println("What is the course number (ex. 101, 202,..etc.)?");
		int courseNum = in.nextInt();
		System.out.println("How many units is this course?");
		int units = in.nextInt();
		System.out.println("What is the location or building/room number of this course?");
		in.nextLine();
		String location = in.nextLine();
		System.out.println("What is the name of the professor of the course?");
		String prof = in.nextLine();
		System.out.println("What is the schedule for this class?\nEnter it in this format: MWF 12:00 P.M. - 12:50 P.M.\nMonday - M\nTuesday - T\nWednesday - W\nThursday - Th\nFriday - F\nSaturday - S\nSunday - Sun\nPut multiple day abbreviations together and time as shown above.");
		String timeAndDay = in.nextLine();
		
		Course newCourse = new Course(courseName, courseId, courseNum, units, location, prof, timeAndDay);
		
		return newCourse;
	}
}
