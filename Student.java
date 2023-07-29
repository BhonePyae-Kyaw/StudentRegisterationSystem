package studentRegisteration;
import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradYear;
	private int currentYear;
	private static int id = 1000;
	private String studentId;
	private String courses;
	private int paidBalance = 0;
	private int remainingBalance;
	private int tuitionFees = 0;
	private int costOfCourse = 600;
	private boolean paidStatus = false;
	
	public Student () {
		Scanner inp = new Scanner(System.in);
		
		System.out.println("Enter the first name of the student: ");
		this.firstName = inp.nextLine();
		
		System.out.println("Enter the last name of the student: ");
		this.lastName = inp.nextLine();

		System.out.println("Enter the expected graduation year of the student: ");
		this.gradYear = inp.nextInt();
		
		System.out.println("Enter the current year of the student (1 for freshman, 2 for sophomore, 3 for junior, 4 for senior): ");
		this.currentYear = inp.nextInt();
		setStudnetId();
		enroll();
		payTuition();
		inp.close();
	}
	
	private void setStudnetId () {
		id++;
		this.studentId = this.currentYear + "" + id;
	}
	
	public void enroll () {
		do {
			System.out.println("Enter the courses to enroll. (Enter Q to end the process.))");
			Scanner courseIn = new Scanner(System.in);
			String course = courseIn.nextLine();
			if (!course.equals("Q")) {
				courses += "\n" + course;
				tuitionFees += costOfCourse;
			}
			else {
				break;
			}
		} while (true);
		System.out.println("The student is enrolled in \n" + courses + ".");
		System.out.println("The total tuituion fees is " + tuitionFees + ".");
	}
	
	public void payTuition () {
		System.out.println("You have to pay " + this.tuitionFees + ".");
		System.out.println("Enter the amount you want to pay now: ");
		Scanner inPay = new Scanner(System.in);
		this.paidBalance = inPay.nextInt();
		System.out.println("You have paid " + this.paidBalance + ".");
		this.remainingBalance = this.tuitionFees - this.paidBalance;
		if (this.remainingBalance == 0) {
			this.paidStatus = true;
			System.out.println("You have fully paid your tuition fees.");
		}else {
			System.out.println("You still need to pay" + this.remainingBalance + "more.");
		}
		inPay.close();
	}
	
	public String printStudent() {
		return "\nThe student info::::::::" +"\nThe student name is " + this.firstName + " " + this.lastName + 
				" and the student will graduate in the year " + this.gradYear + "." + 
				"\nStudent ID is " + this.studentId + "." + 
				"\nThe student is enrolled in: " + this.courses + "." +
				"\nThe total tuition fees is  " + this.tuitionFees + "." +
				"\nThe student is already paid: " + this.paidStatus + "." +
				"\nThe student ramaining balance is " + this.remainingBalance + ".";
	}

}
 