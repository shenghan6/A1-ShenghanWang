import java.util.Objects;

/**
 * Represents a single appointment linking a patient to a chosen health
 * professional at a specific time slot.
 * Implements Comparable so a collection of appointments can be sorted
 * from earliest to latest.
 */
public class Appointment implements Comparable<Appointment> {

    private final String patientName;
    private final String patientPhone;
    private final HealthProfessional professional;
    private final TimeSlot slot;

    /**
     * Creates an appointment. Required details are validated here so an
     * appointment can never be created in an incomplete or invalid state.
     *
     * @param patientName  patient full name, cannot be blank
     * @param patientPhone patient mobile number, 7-15 digits
     * @param professional chosen health professional, cannot be null
     * @param slot         chosen time slot, cannot be null
     */
    public Appointment(String patientName, String patientPhone,
                       HealthProfessional professional, TimeSlot slot) {
        if (patientName == null || patientName.isBlank()) {
            throw new IllegalArgumentException("Patient name cannot be blank.");
        }
        if (patientPhone == null || !patientPhone.matches("\\d{7,15}")) {
            throw new IllegalArgumentException("Patient phone must be 7-15 digits.");
        }
        if (professional == null) {
            throw new IllegalArgumentException("Professional cannot be null.");
        }
        if (slot == null) {
            throw new IllegalArgumentException("Time slot cannot be null.");
        }
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.professional = professional;
        this.slot = slot;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public HealthProfessional getProfessional() {
        return professional;
    }

    public TimeSlot getSlot() {
        return slot;
    }

    /**
     * Orders appointments chronologically by their time slot.
     */
    @Override
    public int compareTo(Appointment other) {
        return Integer.compare(this.slot.getOrder(), other.slot.getOrder());
    }

    @Override
    public String toString() {
        return "[" + slot.getLabel() + "] Patient: " + patientName
                + " | Phone: " + patientPhone
                + " | Professional: " + professional.getName()
                + " (" + professional.getRole() + ", ID " + professional.getId() + ")";
    }

    /**
     * Two appointments are equal when they book the same professional
     * into the same time slot.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Appointment other)) {
            return false;
        }
        return Objects.equals(professional, other.professional) && slot == other.slot;
    }

    @Override
    public int hashCode() {
        return Objects.hash(professional, slot);
    }
}
