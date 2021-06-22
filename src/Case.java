import java.util.LinkedList;
import java.util.List;

public class Case {
    private Integer caseId;
    private List<Integer> detectivesIds = new LinkedList<>();

    private static List<Case> cases = new LinkedList<>();

    private DetectiveCase detectiveCase;

    public Case() {}

    public Case(Integer caseId, List<Integer> detectivesIds, DetectiveCase detectiveCase) {
        cases.add(this);

        this.caseId = caseId;
        this.detectivesIds = detectivesIds;
        this.detectiveCase = detectiveCase;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public void setDetectivesIds(List<Integer> detectivesIds) throws Exception{
        this.detectivesIds = detectivesIds;
        if(caseId != null && detectivesIds.size() != 0)
            cases.add(this);
        else
            throw new Exception("can't add this to extent, not all information were provided");
    }

    public void setDetectiveCase(DetectiveCase detectiveCase) {
        this.detectiveCase = detectiveCase;
    }

    public void addDetective(Integer id) {
        this.detectivesIds.add(id);
    }

    public Integer getCaseId() {
        return caseId;
    }

    public DetectiveCase getDetectiveCase() {
        return detectiveCase;
    }

    public List<Integer> getDetectivesIds() {
        return detectivesIds;
    }

    @Override
    public String toString() {
        return "Case{" +
                "caseId=" + caseId +
                ", detectivesIds=" + detectivesIds +
                '}';
    }
}
