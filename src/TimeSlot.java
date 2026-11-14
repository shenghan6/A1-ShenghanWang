/**
 * Represents a fixed daily clinic time slot.
 * The clinic runs from 08:00 to 16:00 in 30-minute intervals.
 * The order field records the chronological position so slots can be sorted correctly.
 */
public enum TimeSlot {
    T0800("08:00", 0),
    T0830("08:30", 1),
    T0900("09:00", 2),
    T0930("09:30", 3),
    T1000("10:00", 4),
    T1030("10:30", 5),
    T1100("11:00", 6),
    T1130("11:30", 7),
    T1200("12:00", 8),
    T1230("12:30", 9),
    T1300("13:00", 10),
    T1330("13:30", 11),
    T1400("14:00", 12),
    T1430("14:30", 13),
    T1500("15:00", 14),
    T1530("15:30", 15);

    private final String label;
    private final int order;

    TimeSlot(String label, int order) {
        this.label = label;
        this.order = order;
    }

    public String getLabel() {
        return label;
    }

    public int getOrder() {
        return order;
    }
}
