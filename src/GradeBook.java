//GradeBook class using an array to store test grades
public class GradeBook {

	private String courseName; // name of course this GradeBook represents

	private int[] grades; // array of student grades

	// constructor
	public GradeBook(String courseName, int[] grades) {
		this.courseName = courseName;
		this.grades = grades;
	}

	// method to set the course name
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	// method to retrieve the course name
	public String getCourseName() {
		return courseName;
	}

	// perform various operations on the data
	public void processGrades() {
		// output grades array
		outputGrades();

		// call method getAverage to calculate the average grade
		System.out.printf("%nClass average is %.2fn", getAverage());

		// call methods getMinimum and getMaximum
		System.out.printf("Lowest grade is %d%nHighest grade is %d%n%n", getMinimum(), getMaximum());

		// call outputBarChart to print grade distribute chart
		outputBarChart();
	}

	// find minimum grade
	public int getMinimum() {
		int lowGrade = grades[0]; // assume grades[0] is smallest

		// loop through grades array
		for (int grade : grades) {
			// if grade lower than lowGrade, assign it to lowGrade
			if (grade < lowGrade) {
				lowGrade = grade; // new lowest grade
			}
		}

		return lowGrade;
	}

	// find maximum grade
	public int getMaximum() {
		int highGrade = grades[0]; // assume grades [0] is largest

		// loop through grades array
		for (int grade : grades) {
			// if grade greater than highGrade, assign it to highGrade
			if (grade > highGrade) {
				highGrade = grade; // new highest grade
			}
		}
		return highGrade;
	}

	// determine average grade for test
	public double getAverage() {
		int total = 0;

		// sum grades for one student
		for (int grade : grades) {
			total += grade;
		}
		// return average of grades
		return (double) total / grades.length;
	}

	// output bar chart displaying grade distribution

}
