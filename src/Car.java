import java.util.LinkedList;
import java.util.List;

public class Car {
    private String carModel;
    private String serialModel;
    private Integer plate;
    private List<Mechanic> mechanicList = new LinkedList<>();

    public Car() {}

    public Car(String carModel, String serialModel, Integer plate) {
        this.carModel = carModel;
        this.serialModel = serialModel;
        this.plate = plate;
    }

    public void addMechanic(Mechanic mechanic) {
        mechanicList.add(mechanic);
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setSerialModel(String serialModel) {
        this.serialModel = serialModel;
    }

    public void setPlates(Integer plates) {
        this.plate = plates;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getSerialModel() {
        return serialModel;
    }

    public Integer getPlates() {
        return plate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", serialModel='" + serialModel + '\'' +
                ", plate=" + plate +
                '}';
    }
}
