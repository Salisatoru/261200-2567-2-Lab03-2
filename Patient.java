public class Patient {
    private final int id;
    private final String name;
    private final int birthYear;
    private final double height;  // height in centimeters
    private final double weight;  // weight in kilograms
    private final String bloodGroup;
    private final String phoneNumber;

    // Default constructor
    public Patient() {
        this.id = 0;
        this.name = "Unknown";
        this.birthYear = 2000;
        this.height = 170.0;  // Default height in cm
        this.weight = 70.0;   // Default weight in kg
        this.bloodGroup = "Unknown";
        this.phoneNumber = "Unknown";
    }

    // Parameterized constructor
    public Patient(int id, String name, int birthYear, double height, double weight, String bloodGroup, String phoneNumber) {
        this.id = id;
        this.name = name;

        // Validate birthYear
        if (birthYear > 0) {
            this.birthYear = birthYear;
        } else {
            System.out.println("Invalid birth year. Setting to 2000.");
            this.birthYear = 2000;
        }

        // Validate height
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Invalid height. Setting to 170.0 cm.");
            this.height = 170.0;
        }

        // Validate weight
        if (weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("Invalid weight. Setting to 70.0 kg.");
            this.weight = 70.0;
        }

        // Validate bloodGroup
        this.bloodGroup = (bloodGroup != null && !bloodGroup.isEmpty()) ? bloodGroup : "Unknown";

        // Validate phoneNumber
        this.phoneNumber = (phoneNumber != null && !phoneNumber.isEmpty()) ? phoneNumber : "Unknown";
    }

    // Getter methods for each field
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Method to calculate age based on current year
    public int getAge(int currentYear) {
        if (currentYear > birthYear) {
            return currentYear - birthYear;
        } else {
            System.out.println("Invalid current year. Returning age as 0.");
            return 0;
        }
    }

    // Method to calculate BMI
    public double getBMI() {
        // Validate height and weight before calculation
        if (height <= 0 || weight <= 0) {
            return 0.0;  // Invalid height or weight, return 0.0
        }

        // Convert height from cm to meters
        double heightInMeters = height / 100.0;

        // Calculate BMI
        return weight / (heightInMeters * heightInMeters);
    }

    // Method to display patient's details
    public void displayDetails(int currentYear) {
        System.out.println("Patient ID: " + id);
        System.out.println("Patient Name: " + name);
        System.out.println("Patient Age: " + getAge(currentYear));
        System.out.println("Patient Height (cm): " + height);
        System.out.println("Patient Weight (kg): " + weight);
        System.out.println("Patient Blood Group: " + bloodGroup);
        System.out.println("Patient Phone Number: " + phoneNumber);
        System.out.println("Patient BMI: " + getBMI());
    }

    public static void main(String[] args) {
        int currentYear = 2024;

        // Create a valid Patient object using the parameterized constructor
        Patient patient1 = new Patient(1001, "John Doe", 1978, 175.5, 78.0, "O+", "123-456-7890");
        patient1.displayDetails(currentYear);

        // Create a Patient object with invalid height and weight
        Patient invalidPatient = new Patient(1002, "Joe Dohn", 1990, -160.0, -65.0, "A-", "");
        invalidPatient.displayDetails(currentYear);
    }
}
