import java.util.List;

/**
 * A nurse assigned to a particular ward, able to take blood samples.
 */
public class Nurse extends HealthProfessional {

    private final String ward;
    private final boolean canTakeBloodSample;

    public Nurse(String id, String name, List<Day> workingDays,
                 String ward, boolean canTakeBloodSample) {
        super(id, name, workingDays);
        if (ward == null || ward.isBlank()) {
            throw new IllegalArgumentException("Ward cannot be blank.");
        }
        this.ward = ward;
        this.canTakeBloodSample = canTakeBloodSample;
    }

    public Nurse(String id, String name, String ward, boolean canTakeBloodSample) {
        super(id, name);
        this.ward = ward;
        this.canTakeBloodSample = canTakeBloodSample;
    }

    @Override
    public String getRole() {
        return "Nurse";
    }

    public String getWard() {
        return ward;
    }

    public boolean canTakeBloodSample() {
        return canTakeBloodSample;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Ward: " + ward
                + " | Can take blood sample: " + canTakeBloodSample;
    }
}
