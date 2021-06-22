import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        //Zadanie 1.
        Student student1 = new Student("s11111", "Maciej", "Runo",
                Arrays.asList("3", "10"));
        Student student2 = new Student("s19234", "Ryszard", "Szewczyk",
                Collections.singletonList("3"));

        SchoolSubject math = new SchoolSubject("3", "Maths",
                Arrays.asList("s11111", "s19234"));
        SchoolSubject pe = new SchoolSubject("10", "Physical Education",
                Collections.singletonList("s11111"));

        System.out.println(student1.getName());
        for(int i = 0; i < student1.getSubjectIds().size(); i++) {
            int temp = i;
            try {
                System.out.println("   " + SchoolSubject
                        .findSchoolSubjectByPredicate(schoolSubject -> schoolSubject
                                .getSubjectId()
                                .equals(student1.getSubjectIds().toArray()[temp])).getSubjectName());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        System.out.println();
        System.out.println(math.getSubjectName());
        for(int i = 0; i < math.getStudentIds().size(); i++) {
            int temp = i;
            try {
                System.out.println("    " + Student
                        .findStudentByPredicate(student -> student
                                .getId().equals(math.getStudentIds().toArray()[temp])).getName());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        // Zadanie 2.
        DetectiveCase detectiveCase = new DetectiveCase(LocalDate.now(), LocalDate.now(),
                "Paweł", true, Collections.singletonList(20034), Collections.singletonList(5689));
        Detective d1 = new Detective("Daniel", "Bąk", true, 20034,
                Collections.singletonList(5689), detectiveCase);
        Case c1 = new Case(5689, Collections.singletonList(20034), detectiveCase);

        try {
            System.out.println(DetectiveCase
                    .findDetectiveAndCaseByPredicate(detectiveCase1 -> detectiveCase1.getCasesId()
                            == detectiveCase1.getCasesId()));
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }

        // Zadanie 3.
        Car car1 = new Car("Audi", "s123mj", 8756);
        Car car2 = new Car("BMW", "nf981", 12034);

        Mechanic mechanic1 = new Mechanic("Ryszard", "Szewczyk", "Rybicka 13");

        mechanic1.addCarQualif(car1);
        mechanic1.addCarQualif(car2);

        System.out.println(mechanic1.findCarQualif(car1.getSerialModel()));

        // Zadanie 4.
        Office office = new Office(10, 230);
        try {
            Worker w1 = Worker.createWorker(office, "Ryszard", "Szewczyk", 4500.0);
            Worker w2 = Worker.createWorker(office, "Maciej", "Runo", 4300.0);
            office.addWorker(w1);
            office.addWorker(w2);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println(office);
    }
}
