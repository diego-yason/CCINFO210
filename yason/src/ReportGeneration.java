import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.naming.spi.DirStateFactory.Result;

public class ReportGeneration {
    // Note to self:
    // Generation of Teacher Grade Distribution Report per
    // given Term, School Year and/or Course
    public static void run() {

        System.out.println("Would you like to generate a report for a specific term, school year, or course?");
        System.out.println("1. Term");
        System.out.println("2. School Year");
        System.out.println("3. Course");

        ArrayList<GradeReport> data = new ArrayList<>();
        System.out.println("Generating Teacher Grade Distribution Report...");
        int choice = App.getInput(1, 3);
        try {
            Pattern pattern;
            Matcher matcher;
            String query;
            PreparedStatement ps;
            ResultSet rs = null;
            switch (choice) {
                case 1:
                    query = App.readQuery("report/GenerateTerm");
                    ps = App.db.prepareStatement(query);

                    String term = App.getTextInput("Enter term: ");
                    pattern = Pattern.compile("\\d{3}[ABC]");
                    matcher = pattern.matcher(term);

                    if (matcher.matches()) {
                        ps.setString(1, term);
                        rs = ps.executeQuery();
                    } else {
                        System.out.println(
                                "Invalid term format. Please enter a term in the format of three digits followed by A, B, or C.");
                        return;
                    }
                    break;
                case 2:
                    query = App.readQuery("report/GenerateYear");
                    ps = App.db.prepareStatement(query);

                    String year = App.getTextInput("Enter school year ID: ");
                    pattern = Pattern.compile("\\d{3}");
                    matcher = pattern.matcher(year);

                    if (matcher.matches()) {
                        ps.setString(1, year);
                        rs = ps.executeQuery();
                    } else {
                        System.out.println(
                                "Invalid school year format. Please enter a school year in the format of three digits.");
                        return;
                    }
                    break;
                case 3:
                    query = App.readQuery("report/GenerateCourse");
                    ps = App.db.prepareStatement(query);

                    String q2 = App.readQuery("report/GetCourseCodes");
                    ResultSet courseList = App.db.createStatement().executeQuery(q2);
                    ArrayList<Course> courseData = new ArrayList<>();
                    while (courseList.next()) {
                        Course course = new Course();
                        course.code = courseList.getString("code");
                        course.name = courseList.getString("name");
                        courseData.add(course);
                    }

                    Course course = Paginators.getCourse(courseData);
                    ps.setString(1, course.code);
                    rs = ps.executeQuery();
                    break;
            }

            while (rs.next()) {
                GradeReport row = new GradeReport();
                row.id = rs.getInt("facultyId");
                row.name = rs.getString("facultyName");
                row.gradeAverage = rs.getFloat("averageGrade");
                row.count00 = rs.getInt("00");
                row.count10 = rs.getInt("10");
                row.count15 = rs.getInt("15");
                row.count20 = rs.getInt("20");
                row.count25 = rs.getInt("25");
                row.count30 = rs.getInt("30");
                row.count35 = rs.getInt("35");
                row.count40 = rs.getInt("40");
                data.add(row);
            }
        } catch (Exception e) {
            System.out.println("ERR: Failed to generate report.");
            e.printStackTrace();
            return;
        }

        System.out.println("Teacher Grade Distribution Report");
        System.out.printf("Faculty ID\t");
        System.out.printf("%-30s\t", "Name");
        System.out.println("Grade Average\t0.0\t1.0\t1.5\t2.0\t2.5\t3.0\t3.5\t4.0");
        if (data.size() == 0) {
            System.out.println("= = = = No data available. = = = =");
            return;
        }

        for (GradeReport row : data) {
            System.out.printf("%-9d\t%-30s\t%-13.2f\t%-3d\t%-3d\t%-3d\t%-3d\t%-3d\t%-3d\t%-3d\t%-3d\n", row.id,
                    row.name, row.gradeAverage, row.count00, row.count10, row.count15, row.count20, row.count25,
                    row.count30, row.count35, row.count40);
        }

    }

}

class GradeReport {
    public int id;
    public String name;
    public float gradeAverage;

    public int count00;
    public int count10;
    public int count15;
    public int count20;
    public int count25;
    public int count30;
    public int count35;
    public int count40;
}