import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Manages the whole collection of appointments: adding, viewing, filtering,
 * sorting and cancelling. A professional can never be double-booked into the
 * same time slot.
 */
public class AppointmentManager {

    private final List<Appointment> appointments = new ArrayList<>();

    /**
     * Adds an appointment. Rejects the booking if the professional is
     * already booked for the same slot.
     *
     * @param appointment appointment to add
     * @return status message (success or warning)
     */
    public String addAppointment(Appointment appointment) {
        for (Appointment existing : appointments) {
            if (existing.getProfessional().equals(appointment.getProfessional())
                    && existing.getSlot() == appointment.getSlot()) {
                return "WARNING: " + appointment.getProfessional().getName()
                        + " is already booked at " + appointment.getSlot().getLabel() + ".";
            }
        }
        appointments.add(appointment);
        return "OK: Appointment added for " + appointment.getPatientName()
                + " with " + appointment.getProfessional().getName()
                + " at " + appointment.getSlot().getLabel() + ".";
    }

    /**
     * Returns a copy of all current appointments.
     *
     * @return list of all appointments
     */
    public List<Appointment> getAll() {
        return new ArrayList<>(appointments);
    }

    /**
     * Filters appointments by professional ID.
     *
     * @param professionalId numeric professional ID
     * @return matching appointments
     */
    public List<Appointment> filterByProfessionalId(String professionalId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getProfessional().getId().equals(professionalId)) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Filters appointments by patient phone number.
     *
     * @param phone patient phone number
     * @return matching appointments
     */
    public List<Appointment> filterByPhone(String phone) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getPatientPhone().equals(phone)) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Returns all appointments sorted from earliest to latest.
     *
     * @return sorted copy of appointments
     */
    public List<Appointment> sortedByTime() {
        List<Appointment> sorted = new ArrayList<>(appointments);
        Collections.sort(sorted);
        return sorted;
    }

    /**
     * Cancels the appointment matching a professional ID and time slot.
     *
     * @param professionalId numeric professional ID
     * @param slot           time slot
     * @return status message (success or warning)
     */
    public String cancelByProfessionalAndSlot(String professionalId, TimeSlot slot) {
        Iterator<Appointment> it = appointments.iterator();
        while (it.hasNext()) {
            Appointment a = it.next();
            if (a.getProfessional().getId().equals(professionalId) && a.getSlot() == slot) {
                it.remove();
                return "OK: Cancelled " + slot.getLabel() + " appointment for professional "
                        + professionalId + ".";
            }
        }
        return "WARNING: No appointment found for professional " + professionalId
                + " at " + slot.getLabel() + ".";
    }

    /**
     * Cancels every appointment booked under the given patient phone number.
     *
     * @param phone patient phone number
     * @return status message (success or warning)
     */
    public String cancelByPhone(String phone) {
        List<Appointment> removed = new ArrayList<>();
        Iterator<Appointment> it = appointments.iterator();
        while (it.hasNext()) {
            Appointment a = it.next();
            if (a.getPatientPhone().equals(phone)) {
                removed.add(a);
                it.remove();
            }
        }
        if (removed.isEmpty()) {
            return "WARNING: No appointment found for phone " + phone + ".";
        }
        return "OK: Cancelled " + removed.size() + " appointment(s) for phone " + phone + ".";
    }
}
