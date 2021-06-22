import java.util.LinkedList;
import java.util.List;

public class Office {
    private Integer floor;
    private Integer officeNumber;
    private List<Worker> workers = new LinkedList<>();

    public Office(Integer floor, Integer officeNumber) {
        this.floor = floor;
        this.officeNumber = officeNumber;
    }

    public void addWorker(Worker worker) {
        if(!workers.contains(worker))
            workers.add(worker);
    }

    @Override
    public String toString() {
        return "Office{" +
                "floor=" + floor +
                ", officeNumber=" + officeNumber +
                ", workers=" + workers +
                '}';
    }
}
