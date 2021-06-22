import java.util.Map;
import java.util.TreeMap;

public class Mechanic {
    private String name;
    private String lastName;
    private String address;

    private Map<String, Car> carQualif = new TreeMap<>();

    public Mechanic() {}

    public Mechanic(String name, String lastName, String address) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    public void addCarQualif(Car newCar) {
        if(!carQualif.containsKey(newCar.getSerialModel())) {
            carQualif.put(newCar.getSerialModel(), newCar);
            newCar.addMechanic(this);
        }
    }

    public Car findCarQualif(String serialModel) {
        return carQualif.getOrDefault(serialModel, null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
