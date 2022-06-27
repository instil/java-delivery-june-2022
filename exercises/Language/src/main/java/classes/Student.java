package classes;

import java.util.Arrays;
import java.util.StringJoiner;

class Resource {
    String id;

    public Resource(String id) {
        this.id = id;
    }
}

public class Student extends Resource {

    private final String name;
    private final String subject;
    private final int yearOfStudy;
    private final double[] marks;

    public Student(String id, String name, String subject, int yearOfStudy, double[] marks) {
        super(id);
        this.name = name;
        this.subject = subject;
        this.yearOfStudy = yearOfStudy;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("subject='" + subject + "'")
                .add("yearOfStudy=" + yearOfStudy)
                .add("marks=" + Arrays.toString(marks))
                .toString();
    }

    public double average() {
        return Arrays
                .stream(marks)
                .average()
                .orElse(0);
    }
}
