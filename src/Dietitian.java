import java.util.List;

/**
 * A dietitian, holding a professional qualification.
 */
public class Dietitian extends HealthProfessional {

    private final String qualification;

    public Dietitian(String id, String name, List<Day> workingDays, String qualification) {
        super(id, name, workingDays);
        if (qualification == null || qualification.isBlank()) {
            throw new IllegalArgumentException("Qualification cannot be blank.");
        }
        this.qualification = qualification;
    }

    public Dietitian(String id, String name, String qualification) {
        super(id, name);
        this.qualification = qualification;
    }

    @Override
    public String getRole() {
        return "Dietitian";
    }

    public String getQualification() {
        return qualification;
    }

    @Override
    public String toString() {
        return super.toString() + " | Qualification: " + qualification;
    }
}
