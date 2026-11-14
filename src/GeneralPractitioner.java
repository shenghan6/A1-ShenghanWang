import java.util.List;

/**
 * A general practitioner (GP).
 * Adds years of experience on top of the shared professional details.
 */
public class GeneralPractitioner extends HealthProfessional {

    private final int yearsExperience;

    public GeneralPractitioner(String id, String name, List<Day> workingDays, int yearsExperience) {
        super(id, name, workingDays);
        if (yearsExperience < 0) {
            throw new IllegalArgumentException("Years of experience cannot be negative.");
        }
        this.yearsExperience = yearsExperience;
    }

    public GeneralPractitioner(String id, String name, int yearsExperience) {
        super(id, name);
        this.yearsExperience = yearsExperience;
    }

    @Override
    public String getRole() {
        return "General Practitioner";
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    @Override
    public String toString() {
        return super.toString() + " | Experience: " + yearsExperience + " years";
    }
}
