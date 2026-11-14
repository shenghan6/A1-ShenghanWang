import java.util.List;

/**
 * A specialist doctor, e.g. paediatrician, radiologist or cardiologist.
 * Adds a sub-specialty field on top of the shared professional details.
 */
public class Specialist extends HealthProfessional {

    private final String subSpecialty;

    public Specialist(String id, String name, List<Day> workingDays, String subSpecialty) {
        super(id, name, workingDays);
        if (subSpecialty == null || subSpecialty.isBlank()) {
            throw new IllegalArgumentException("Sub-specialty cannot be blank.");
        }
        this.subSpecialty = subSpecialty;
    }

    public Specialist(String id, String name, String subSpecialty) {
        super(id, name);
        this.subSpecialty = subSpecialty;
    }

    @Override
    public String getRole() {
        return "Specialist (" + subSpecialty + ")";
    }

    public String getSubSpecialty() {
        return subSpecialty;
    }

    @Override
    public String toString() {
        return super.toString() + " | Sub-specialty: " + subSpecialty;
    }
}
