//Christopher Cano CS455 PA4 Extra Credit
/*
-----------Student-----------------------------------------------
- scoreList: ArrayList<Integer>
- grade: String
- avgScore: double
- totScore: int
- minScore: int
- secMin: int
-----------------------------------------------------------------
+ Student()
+ Student(String, String, long)
+ Student(Student)
+ getScoreList(): ArrayList<Integer>
+ addScore(int): void //adds one single score to an arraylist
+ readScore(): void //adds up to 8 scores to arraylist
+ getGrade(): int
+ getAvg(): double
+ getTot(): double //get total sum of scores
+ getNumScores: int
- calcTot(): void //calculate total sum of scores
- detectMins(): void //determines minimum scores within an arraylist of scores
- calcAvg(): void //calculates average of 6 highest scores
- setGrade(): String
+ isValidScoreList(): boolean //checks if arraylist of scores is valid, greater than or equal to 6
+ isValidScore(int): boolean //checks if score is >=0 and <=100
+ searchScore(int): boolean
+ toString(): String
+ print(): void
+ printScores(): void
+ equals(Object): boolean
- format(double): String
+ changeFirstName(): void
+ changeLastName(): void
+ addGradeToList(): void
+ removeGradeFromList(): void
-----------------------------------------------------------------
 */


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;//ArrayList;

public class Student extends Person{

	private ArrayList<Integer> scoreList;
	private String grade;
	private double avgScore;
	private int totScore;
	private int minScore;
	private int secMin;
	
	public Student(){
		
		super();
		scoreList = new ArrayList<Integer>();
		setGrade();//grade = "";
		getAvg();//avgScore = 0.0;
	}
	
	public Student(String firstName, String lastName, long ident){
		
		super(firstName, lastName, ident);
		scoreList = new ArrayList<Integer>();
		setGrade();
		getAvg();
	}
	
	public Student(Student student){
		
		super(student.getFirstName(),student.getLastName(),student.getId());
		scoreList = student.scoreList;
		setGrade();
		getAvg();
	}
	
	public ArrayList<Integer> getScoreList(){
		
		return scoreList;
	}
	
	public void addScore(int score){
		
		if(scoreList.size() < 8){
			
				scoreList.add(score);
		}
		else{
			
			System.out.println("Cannot add anymore grades, list is at its maximum allowance of 8 scores. You may remove a grade if you want to add a new one.");
		}
	}
	
	public void readScore(){
		
		scoreList = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter up to 8 valid scores for the student, you may stop before 8 by entering a non-integer. If more than 8 scores are entered, only first 8 will be read: ");
		int count = 0;
		int maxNumScore = 8;
		while(in.hasNextInt()){
			
			int newScore = in.nextInt();
			addScore(newScore);
			count++;
			if(count == maxNumScore){
				
				break;
			}
		}
	}
	
	public String getGrade(){
		
		return grade;
	}
	
	public double getAvg(){
		
		calcAvg();
		return avgScore;
	}
	
	public double getTot(){
		
		calcTot();
		return totScore;
	}
	
	private void calcTot(){
		
		totScore = 0;
		if(scoreList.size()>0){
			
			for(int i = 0;i<scoreList.size();i++){
				
				if(isValidScore(scoreList.get(i)) == true){
					
					totScore+=scoreList.get(i);
				}
			}
		}
		
		int listSizeGTOne = 7; //list of grades greater than 6 by 1
		int listSizeGTTwo = 8; //list of grades greater than 6 by 2
		//Only use 6 largest scores to calculate for average
		if(scoreList.size() == listSizeGTOne){
			detectMins();
			totScore = totScore - minScore;
		}
		else if(scoreList.size()==listSizeGTTwo){
			detectMins();
			//System.out.println("Min scores are: " + minScore + " " + secMin);
			totScore = totScore - minScore - secMin;
			//System.out.println("Total score is " + totScore);
		}
	}
	
	//detects minimum scores
	private void detectMins(){
		
		minScore = scoreList.get(0);
		secMin = scoreList.get(1);
		
		if(minScore>secMin){
				
			int temp = minScore;
			minScore = secMin;
			secMin = temp;
		}
		
		for(int i = 2; i<scoreList.size();i++){
				
			if(secMin>scoreList.get(i)){
				
				secMin = scoreList.get(i);
				
				if(secMin<minScore){
					
					int temp = minScore;
					minScore = secMin;
					secMin = temp;
				}
			}
		}
	}
	
	private void calcAvg(){
		
		//might change below, dont calculate average if greater than 0 but less than 6? what to do then?
		if(scoreList.size()<6 || isValidScoreList() == false){
			
			avgScore = 0.0;
		}
		else{
		
			int denom = 6;//only calculate average of 6 highest scores
			avgScore = (double)getTot()/(denom);//counter;
		}
	}
	
	private String setGrade(){
		
		double score = getAvg();
		//might change the first if statement to getNumScores() ==0
		if(scoreList.size() < 6 || isValidScoreList() == false){
		
			return "I";
		}
		else if(score >=90 && score <= 100){
			
			return "A";
		}
		else if(score >= 80 && score < 90){
			
			return "B";
		}
		else if(score >= 70 && score < 80){
			
			return "C";
		}
		else if(score >=60 && score < 70){
			
			return "D";
		}
		else{
			
			return "F";
		}
	}
	
	public boolean isValidScoreList(){
		
		for(int i = 0; i<scoreList.size();i++){
			
			if(scoreList.get(i)< 0 || scoreList.get(i)>100){
				
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isValidScore(int score){
		
		if(score >= 0 && score <= 100){
			
			return true;
		}
		else{
			
			return false;
		}
		
	}
	
	public boolean searchScore(int score){
		
		for(int i = 0; i< scoreList.size(); i++){
			
			if(score == scoreList.get(i)){
				
				return true;
			}
		}
		
		return false;
	}
	
	public String toString(){
		
		String stuInfo = super.toString() + "\t\t\t" + format(getAvg()) + "\t\t\t" + setGrade(); 
		
		return stuInfo;
	}
	
	public void print(){
		
		System.out.println(toString());
	}
	
	public void printScores(){
		
		System.out.println(toString() + "\nList of Scores:");
		for(int i = 0; i<scoreList.size();i++){
			
			System.out.println(scoreList.get(i));
		}
	}
	
	public boolean equals(Object otherObject){
		
		if(otherObject == null){
			
			return false;
		}
		else if(!super.equals(otherObject)){
			
			return false;
		}
		else if(getClass() != otherObject.getClass()){
			
			return false;
		}
		else{
			
			Student newStudent = (Student)otherObject;
			return getScoreList().equals(newStudent.getScoreList()) && getGrade() == newStudent.getGrade();
		}
	}
	
	private String format(double value){
		
		NumberFormat gradeRep = new DecimalFormat();
		gradeRep = new DecimalFormat("0.00");
		String newFormat = gradeRep.format(value);
		
		return newFormat;
	}
	
	public void changeFirstName(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("What first name would you like to change it to?");
		String oldFirst = getFirstName();
		String newFirst = in.next();
		setFirst(newFirst);
		System.out.println(oldFirst + " changed to " + newFirst + "!");
	}
	
	public void changeLastName(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("What last name would you like to change it to?");
		String oldLast = getLastName();
		String newLast = in.next();
		setLast(newLast);
		System.out.println(oldLast + " changed to " + newLast + "!");
	}
	
	public void addGradeToList(){
		
		Scanner in = new Scanner(System.in);
		if(scoreList.size() >= 8){
			
			System.out.println("Cannot add anymore grades, " + getFirstName() + " " + getLastName() + "'s score list is at its maximum allowance of 8 scores.");
		}
		else if(scoreList.size() < 8){
			
			System.out.println("What score would you like to add?");
			int nextScore = in.nextInt();
			if(isValidScore(nextScore) == true){
				
				addScore(nextScore);
				calcAvg();
				System.out.println("Score: " + nextScore + " added!");
			}
			else{
				
				System.out.println("Score entered is not valid, score not added.");
			}
		}
	}
	
	public void removeGradeFromList(){
		
		Scanner in = new Scanner(System.in);
		int score = in.nextInt();
		if(searchScore(score) == true){
			
			for(int j = 0; j < scoreList.size(); j++){
				
				if(scoreList.get(j) == score){
				
					scoreList.remove(scoreList.get(j));
					System.out.println("Score removed!");
					break;
				}
			}
		}
		else{
			
			System.out.println("Score is not on " + getFirstName() + getLastName() + "'s list of scores.");
		}
	}
}
