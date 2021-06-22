import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SchoolSubject {
    private String subjectId;
    private String subjectName;
    private List<String> studentIds;

    private static List<SchoolSubject> extent = new LinkedList<>();
    private List<Student> students = new LinkedList<>();

    public SchoolSubject() {}

    public SchoolSubject(String subjectId, String subjectName, List<String> studentIds) {
        extent.add(this);

        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.studentIds = studentIds;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void addStudent(Student newStudent) {
        if(!students.contains(newStudent)) {
            students.add(newStudent);
            newStudent.addSubject(this);
        }
    }

    public void addStudent(String studentId) {
        studentIds.add(studentId);
    }

    public void setStudentIds(List<String> studentIds) throws Exception{
        this.studentIds = studentIds;
        if(subjectId != null && subjectName != null && studentIds != null)
            extent.add(this);
        else
            throw new Exception("Can't add this subject, not all information were provided");
    }

    public static SchoolSubject findSchoolSubjectByPredicate(Predicate<SchoolSubject> predicate) throws Throwable {
        return extent.stream().filter(predicate).findFirst()
                .orElseThrow((Supplier<Throwable>) ()
                        -> new Exception("Unable to find school subject by this predicate"));
    }

    public List<String> getStudentIds() {
        return studentIds;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public String toString() {
        return "SchoolSubject{" +
                "subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", studentIds=" + studentIds +
                '}';
    }
}
