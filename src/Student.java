import javax.security.auth.Subject;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Student {
    private String id = null;
    private String name = null;
    private String lastName = null;
    private static List<Student> extent = new LinkedList<>();

    private List<String> subjectIds = new LinkedList<>();
    private List<SchoolSubject> subjects = new LinkedList<>();

    public Student() {}

    public Student(String id, String name, String lastName, List<String> subjectIds) {
        extent.add(this);

        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.subjectIds = subjectIds;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSubjectIds(List<String> subjectIds) throws Exception{
        this.subjectIds = subjectIds;
        if(id != null && name != null && lastName != null && subjectIds != null)
            extent.add(this);
        else
            throw new Exception("Can't add this student, not all information were provided");
    }

    public static Student findStudentByPredicate(Predicate<Student> predicate) throws Throwable {
        return extent.stream().filter(predicate).findFirst()
                .orElseThrow((Supplier<Throwable>) ()
                        -> new Exception("Unable to find student by this predicate"));
    }

    public void addSubjectId(String id) {
        subjectIds.add(id);
    }

    public void addSubject(SchoolSubject subject) {
        if(!subjects.contains(subject)) {
            subjects.add(subject);
            subject.addStudent(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getSubjectIds() {
        return subjectIds;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subjectIds=" + subjectIds +
                '}';
    }
}
