import java.util.ArrayList;

public class Paginators {
    public static Department getDepartment(ArrayList<Department> data) {
        int page = 0;

        while (true) {
            int optionCount = Math.min(5, data.size() - (5 * page));
            boolean hasNext = data.size() > (5 * (page + 1));

            System.out.println("Select a department:");
            if (page > 0) {
                System.out.println("0. Previous");
            }
            for (int i = 0; i < optionCount; i++) {
                System.out.println((i + 1) + ". " + data.get(i + (5 * page)).name);
            }
            if (hasNext) {
                System.out.println("6. Next");
            }

            int input = App.getInput(page == 0 ? 1 : 0, hasNext ? 6 : optionCount);

            if (input == 0) {
                page--;
                continue;
            }

            if (input == 6) {
                page++;
                continue;
            }

            return data.get(input - 1 + (5 * page));
        }
    }

    public static Faculty getFaculty(ArrayList<Faculty> data) {
        int page = 0;
        while (true) {
            int optionCount = Math.min(5, data.size() - (5 * page));
            boolean hasNext = data.size() > (5 * (page + 1));

            System.out.println("Select a faculty:");
            if (page > 0) {
                System.out.println("0. Previous");
            }
            for (int i = 0; i < optionCount; i++) {
                Faculty faculty = data.get(i + (5 * page));
                System.out.println(
                        (i + 1) + ". " + faculty.lastName + ", " + faculty.firstName + " (" + faculty.department + ")");
            }
            if (hasNext) {
                System.out.println("6. Next");
            }

            int input = App.getInput(page == 0 ? 1 : 0, hasNext ? 6 : optionCount);

            if (input == 0) {
                page--;
                continue;
            }

            if (input == 6) {
                page++;
                continue;
            }

            return data.get(input - 1 + (5 * page));
        }
    }

    public static Course getCourse(ArrayList<Course> data) {
        int page = 0;
        while (true) {
            int optionCount = Math.min(5, data.size() - (5 * page));
            boolean hasNext = data.size() > (5 * (page + 1));

            System.out.println("Select a course:");
            if (page > 0) {
                System.out.println("0. Previous");
            }
            for (int i = 0; i < optionCount; i++) {
                Course course = data.get(i + (5 * page));
                System.out.println((i + 1) + ". " + course.code + " (" + course.name + ")");
            }
            if (hasNext) {
                System.out.println("6. Next");
            }

            int input = App.getInput(page == 0 ? 1 : 0, hasNext ? 6 : optionCount);

            if (input == 0) {
                page--;
                continue;
            }

            if (input == 6) {
                page++;
                continue;
            }

            return data.get(input - 1 + (5 * page));
        }
    }

    public static Section getSection(ArrayList<Section> data) {
        int page = 0;
        while (true) {
            int optionCount = Math.min(5, data.size() - (5 * page));
            boolean hasNext = data.size() > (5 * (page + 1));

            System.out.println("Select a section:");
            if (page > 0) {
                System.out.println("0. Previous");
            }
            for (int i = 0; i < optionCount; i++) {
                Section section = data.get(i + (5 * page));
                System.out.println((i + 1) + ". " + section.sectionCode);
            }
            if (hasNext) {
                System.out.println("6. Next");
            }

            int input = App.getInput(page == 0 ? 1 : 0, hasNext ? 6 : optionCount);

            if (input == 0) {
                page--;
                continue;
            }

            if (input == 6) {
                page++;
                continue;
            }

            return data.get(input - 1 + (5 * page));
        }
    }
}
