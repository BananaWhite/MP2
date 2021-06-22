import org.jetbrains.annotations.Contract;

public class Worker {
    private String name;
    private String lastName;
    private Double payment;
    private Office office;

    private Worker(Office office, String name, String lastName, Double payment) {
        this.office = office;
        this.name = name;
        this.lastName = lastName;
        this.payment = payment;
    }

    @Contract("null, _, _, _ -> fail")
    public static Worker createWorker(Office office, String name, String lastName, Double payment) throws Exception {
        if(office == null)
            throw new Exception("office can't be null");

        Worker worker = new Worker(office, name, lastName, payment);
        office.addWorker(worker);

        return worker;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", payment=" + payment +
                '}';
    }
}
