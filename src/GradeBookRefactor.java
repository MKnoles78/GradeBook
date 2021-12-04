
public class GradeBookRefactor {
	private String courseName; // name of course this GradeBook represents

	private int[] grades; // array of student grades

	// constructor
	public class GradeBookRefactor {
		private String courseName; // name of course this grade book represents
		private int[][] grades; // two-dimensional array of student grades

		// two-argument constructor initializes courseName and grades array
		public GradeBookRefactor(String courseName, int[][] grades) {
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

			// call methods getMinimum and getMaximum
			System.out.printf("%n%s %d%n%s %d%n%n", "Lowest grade in the grade book is", getMinimum(),
					"Highest grade in the grade book is", getMaximum());

			// call outputBarChart to print grade distribute chart
			outputBarChart();
		}

		// find minimum grade
		public int getMinimum() {
			// assume first element of grades array is smallest
			int lowGrade = grades[0][0];
			// loop through rows of grades array
			for (int[] studentGrades : grades) {
				// loop through columns of current row
				for (int grade : studentGrades) {
					// if grade less than lowGrade, assign it to lowGrade
					if (grade < lowGrade) {
						lowGrade = grade;
					}
				}
			}
			return lowGrade;
		}

		int lowGrade = grades[0]; // assume grades[0] is smallest

		// loop through grades array
		for(
		int grade:grades)
		{
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
	public void outputBarChart() {
		System.out.println("Grade distribution:");

		// stores frequency of grades in each range of 10 grades
		int[] frequency = new int[11];

		// for each grade, increment the appropriate frequency
		for (int grade : grades) {
			++frequency[grade / 10];
		}

		// for each grade frequency, print bar in chart
		for (int count = 0; count < frequency.length; count++) {
			// output bar label ("00-09: ", ..., "90-99: ", "100: ")
			if (count == 10) {
				System.out.printf("%5d: ", 100);
			} else {
				System.out.printf("%02d-%02d: ", count * 10, count * 10 + 9);
			}

			// print bar of asterisks
			for (int stars = 0; stars < frequency[count]; stars++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}

	// output the contents of the grades array
	public void outputGrades() {
		System.out.printf("The grades are: %n%n");

		// output each student's grade
		for (int student = 0; student < grades.length; student++)
			System.out.printf("Student %2d: %3d%n", student + 1, grades[student]);
	}

}
