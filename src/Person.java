//Christopher Cano CS455 PA4 Extra Credit


/*
--------Person---------------
- firstName: String
- lastName: String
- id: long
------------------------------
+ Person()
+ Person(String, String, long)
+ Person(Person)
+ getFirstName(): String
+ getLastName(): String
+ getId(): long
- formatId(): String
+ setFirst(String): String
+ setLast(String): String
+ setId(long): long
+ equals(Object): boolean
+ toString(): String
+ print(): void
-------------------------------
 */
public class Person {

	private String firstName;
	private String lastName;
	private long id;
	
	public Person(){
		
		firstName = "";
		lastName = "";
		id =0;
	}
	
	public Person(String first, String last, long ident){
		
		firstName = first;
		lastName = last;
		id = ident;
	}
	
	public Person(Person person){
		
		firstName = person.firstName;
		lastName = person.lastName;
		id = person.id;
	}
	
	public String getFirstName(){
		
		return firstName;
	}
	
	public String getLastName(){
		
		return lastName;
	}
	
	public long getId(){
		
		return id;
	}
	
	private String formatId(long id){
		
		String idNum = Long.toString(id);
		String idSub = idNum.substring(5,idNum.length());
		String idFormat = "***_**_" + idSub;
				
		return idFormat;
	}
	
	public void setFirst(String fName){
		
		firstName = fName;
	}
	
	public void setLast(String lName){
		
		lastName = lName;
	}
	
	public void setId(long ident){
		
		id = ident;
	}
	
	public boolean equals(Object otherObject){
		
		if(otherObject == null){
			return false;
		}
		else if(getClass() != otherObject.getClass()){
			
			return false;
		}
		else{
			
			Person otherPerson = (Person)otherObject;
			return getFirstName().equalsIgnoreCase(otherPerson.getFirstName()) && getLastName().equalsIgnoreCase(otherPerson.getLastName()) && getId() == otherPerson.getId();
		}
	}
	
	public String toString(){
		
		String info = getLastName() + ", " + getFirstName() + "\t\t" + formatId(getId());
				
		return info;
	}
	
	public void print(){
	
		System.out.println(toString());
	}
}
