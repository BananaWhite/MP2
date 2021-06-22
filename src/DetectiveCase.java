import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DetectiveCase {
    private LocalDate startDate;
    private LocalDate endDate;
    private String criminalName;
    private Boolean isCriminalDead;

    private List<Integer> detectiveIds = new LinkedList<>();
    private List<Integer> casesId = new LinkedList<>();

    private static List<DetectiveCase> detectiveCases = new LinkedList<>();

    public DetectiveCase() {}

    public DetectiveCase(LocalDate startDate, LocalDate endDate, String criminalName,
                         Boolean isCriminalDead, List<Integer> detectiveIds, List<Integer> casesId) {
        detectiveCases.add(this);

        this.startDate = startDate;
        this.endDate = endDate;
        this.criminalName = criminalName;
        this.isCriminalDead = isCriminalDead;
        this.detectiveIds = detectiveIds;
        this.casesId = casesId;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setCriminalName(String criminalName) {
        this.criminalName = criminalName;
    }

    public void setShooterDead(Boolean criminalDead) {
        isCriminalDead = criminalDead;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Boolean getIsCriminalDead() {
        return isCriminalDead;
    }

    public String getCriminalName() {
        return criminalName;
    }

    public List<Integer> getCasesId() {
        return casesId;
    }

    public List<Integer> getDetectiveIds() {
        return detectiveIds;
    }

    public static DetectiveCase findDetectiveAndCaseByPredicate(Predicate<DetectiveCase> detectiveCasePredicate) throws Throwable{
        return detectiveCases
                .stream()
                .filter(detectiveCasePredicate)
                .findFirst()
                .orElseThrow((Supplier<? extends Throwable>) () -> new Throwable("Unable to find detective and case by this predicate"));
    }

    @Override
    public String toString() {
        return "DetectiveCase{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", criminalName='" + criminalName + '\'' +
                ", isCriminalDead=" + isCriminalDead +
                ", detectiveIds=" + detectiveIds +
                ", casesId=" + casesId +
                '}';
    }
}
