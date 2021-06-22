import java.util.LinkedList;
import java.util.List;

public class Detective {
    private String name;
    private String lastName;
    private Boolean isArmed;
    private Integer badgeId;
    private DetectiveCase detectiveCase;

    private List<Integer> casesId = new LinkedList<>();
    private static List<Detective> detectives = new LinkedList<>();

    public Detective() {}

    public Detective(String name, String lastName, Boolean isArmed,
                     Integer badgeId, List<Integer> casesId, DetectiveCase detectiveCase) {
        detectives.add(this);

        this.name = name;
        this.lastName = lastName;
        this.isArmed = isArmed;
        this.badgeId = badgeId;
        this.casesId = casesId;
        this.detectiveCase = detectiveCase;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBadgeId(Integer badgeId) {
        this.badgeId = badgeId;
    }

    public void setArmed(Boolean armed) throws Exception {
        isArmed = armed;
        if(isArmed != null && getName() != null && getLastName() != null && badgeId != null)
            detectives.add(this);
        else
            throw new Exception("Can't add this to extent, not all information were provided");
    }

    public void setDetectiveCase(DetectiveCase detectiveCase) {
        this.detectiveCase = detectiveCase;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getArmed() {
        return isArmed;
    }

    public Integer getBadgeId() {
        return badgeId;
    }

    public List<Integer> getCasesId() {
        return casesId;
    }

    public DetectiveCase getDetectiveCase() {
        return detectiveCase;
    }

    @Override
    public String toString() {
        return "Detective{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isArmed=" + isArmed +
                ", badgeId=" + badgeId +
                ", casesId=" + casesId +
                '}';
    }
}
