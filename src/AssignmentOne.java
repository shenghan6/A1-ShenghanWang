import java.util.ArrayList;
import java.util.List;

/**
 * Main demonstration class for Assessment 1.
 * Creates health professionals, builds and manages appointments, and
 * exercises both normal and error cases, printing results to the console.
 */
public class AssignmentOne {

    public static void main(String[] args) {

        // ---------- Part 3: create and display health professionals ----------
        System.out.println("===== Part 3: Health Professionals =====");

        List<HealthProfessional> professionals = new ArrayList<>();
        professionals.add(new GeneralPractitioner("1001", "Alice Chen",
                List.of(Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY), 8));
        professionals.add(new GeneralPractitioner("1002", "Ben Wang",
                List.of(Day.TUESDAY, Day.THURSDAY), 5));
        professionals.add(new GeneralPractitioner("1003", "Cara Li",
                List.of(Day.MONDAY, Day.WEDNESDAY), 12));
        professionals.add(new Specialist("2001", "David Wu",
                List.of(Day.MONDAY, Day.THURSDAY), "Paediatrician"));
        professionals.add(new Nurse("3001", "Emma Zhao",
                List.of(Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY), "Ward A", true));
        professionals.add(new Dietitian("4001", "Fiona Sun",
                List.of(Day.TUESDAY, Day.FRIDAY), "BHSc Nutrition"));

        for (HealthProfessional p : professionals) {
            System.out.println(p);
        }

        HealthProfessional alice = professionals.get(0);
        HealthProfessional ben = professionals.get(1);
        HealthProfessional cara = professionals.get(2);
        HealthProfessional david = professionals.get(3);
        HealthProfessional emma = professionals.get(4);
        HealthProfessional fiona = professionals.get(5);

        // ---------- Part 5 & 6: appointment management ----------
        AppointmentManager manager = new AppointmentManager();

        System.out.println("\n===== Part 6: Adding Appointments =====");
        System.out.println(manager.addAppointment(
                new Appointment("Noah", "0400111222", alice, TimeSlot.T0900)));
        System.out.println(manager.addAppointment(
                new Appointment("Olivia", "0400222333", ben, TimeSlot.T0930)));
        System.out.println(manager.addAppointment(
                new Appointment("Ethan", "0400333444", david, TimeSlot.T1000)));
        System.out.println(manager.addAppointment(
                new Appointment("Mia", "0400444555", emma, TimeSlot.T1030)));
        System.out.println(manager.addAppointment(
                new Appointment("Liam", "0400555666", fiona, TimeSlot.T1100)));
        System.out.println(manager.addAppointment(
                new Appointment("Ava", "0400666777", cara, TimeSlot.T0900)));

        printAppointments("All appointments", manager.getAll());

        // ---------- Filtering ----------
        printAppointments("Filter by professional ID 1001",
                manager.filterByProfessionalId("1001"));
        printAppointments("Filter by patient phone 0400333444",
                manager.filterByPhone("0400333444"));

        // ---------- Sorting ----------
        printAppointments("Appointments sorted by time", manager.sortedByTime());

        // ---------- Error cases ----------
        System.out.println("\n===== Error Cases =====");
        // Double-booking the same professional into the same slot
        System.out.println(manager.addAppointment(
                new Appointment("Ruby", "0400777888", alice, TimeSlot.T0900)));
        // Cancelling a non-existent appointment
        System.out.println(manager.cancelByProfessionalAndSlot("9999", TimeSlot.T0800));
        // Invalid appointment (blank patient name) should be rejected at construction
        try {
            new Appointment("", "0400000000", alice, TimeSlot.T0800);
        } catch (IllegalArgumentException ex) {
            System.out.println("WARNING: Invalid appointment rejected - " + ex.getMessage());
        }

        // ---------- Cancelling ----------
        System.out.println("\n===== Cancelling Appointments =====");
        System.out.println(manager.cancelByProfessionalAndSlot("2001", TimeSlot.T1000));
        printAppointments("After cancelling David Wu at 10:00", manager.getAll());

        System.out.println(manager.cancelByPhone("0400222333"));
        printAppointments("After cancelling Olivia by phone", manager.getAll());
    }

    /**
     * Prints a titled list of appointments, or an empty message when none exist.
     *
     * @param title    section title
     * @param appointments list to print
     */
    private static void printAppointments(String title, List<Appointment> appointments) {
        System.out.println("\n----- " + title + " -----");
        if (appointments.isEmpty()) {
            System.out.println("(no appointments)");
            return;
        }
        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }
}
