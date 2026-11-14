import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents a generic health professional.
 * This abstract base class holds the information and behaviour shared by every
 * health professional, regardless of their specialty. It cannot be instantiated
 * directly; specific professional types must extend it.
 */
public abstract class HealthProfessional {

    /** Numeric-only identifier, e.g. "1001". */
    private final String id;
    private final String name;
    /** Fixed set of working days for this professional. */
    private final List<Day> workingDays;

    /**
     * Full constructor.
     *
     * @param id          numeric-only identifier
     * @param name        professional name, cannot be blank
     * @param workingDays fixed non-empty set of working days
     */
    protected HealthProfessional(String id, String name, List<Day> workingDays) {
        if (id == null || !id.matches("\\d+")) {
            throw new IllegalArgumentException("ID must contain digits only.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (workingDays == null || workingDays.isEmpty()) {
            throw new IllegalArgumentException("Working days cannot be empty.");
        }
        this.id = id;
        this.name = name;
        this.workingDays = new ArrayList<>(workingDays);
    }

    /**
     * Convenience constructor using a default working week (Mon / Wed / Fri).
     *
     * @param id   numeric-only identifier
     * @param name professional name
     */
    protected HealthProfessional(String id, String name) {
        this(id, name, List.of(Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY));
    }

    /**
     * Returns the professional's role label, supplied by each subclass.
     *
     * @return role description
     */
    public abstract String getRole();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns an unmodifiable view of the working days so external code cannot
     * alter the internal state of this object.
     *
     * @return unmodifiable list of working days
     */
    public List<Day> getWorkingDays() {
        return Collections.unmodifiableList(workingDays);
    }

    /**
     * Two professionals are considered equal when they share the same ID.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HealthProfessional other)) {
            return false;
        }
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Name: " + name
                + " | Role: " + getRole()
                + " | Working days: " + workingDays;
    }
}
