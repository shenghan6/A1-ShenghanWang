# PROG2004 Assessment 1 — Appointment System

A simple health service appointment system written in Java. Patients can book
appointments with different types of health professionals. The system supports
adding, filtering, sorting and cancelling appointments, and prevents the same
professional from being double-booked into the same time slot.

## How to run

1. Open the project in an IDE (IntelliJ IDEA, Eclipse or VS Code) and mark the
   `src` directory as the source root.
2. Run the `main` method in `AssignmentOne.java`.
3. The demonstration prints the professionals and appointment results to the
   console.

Alternatively, from the command line:

```
javac -d out src/*.java
java -cp out AssignmentOne
```

## Project structure

| File | Responsibility |
|---|---|
| `AssignmentOne.java` | Main method that demonstrates the whole system. |
| `HealthProfessional.java` | Abstract base class holding the shared professional details. |
| `GeneralPractitioner.java` | GP subclass with years of experience. |
| `Specialist.java` | Specialist subclass with a sub-specialty. |
| `Nurse.java` | Nurse subclass with ward and blood sample capability. |
| `Dietitian.java` | Dietitian subclass with qualification. |
| `Appointment.java` | Links a patient, a professional and a time slot; comparable by time. |
| `AppointmentManager.java` | Manages the appointment collection: add, filter, sort, cancel and conflict check. |
| `Day.java` | Enum for working days. |
| `TimeSlot.java` | Enum for the fixed daily clinic slots (08:00–15:30, 30-minute intervals). |

## Object-oriented concepts

- **Encapsulation:** professional fields are private and accessed through getters;
  data is validated in the constructors.
- **Inheritance:** the four professional types extend `HealthProfessional`.
- **Polymorphism:** professionals are stored and processed through the common
  `HealthProfessional` type.
- **Abstraction:** `HealthProfessional` is abstract and defines the shared role
  behaviour that each subclass must provide.
