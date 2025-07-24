package vitals;

public class Main {

    static boolean checkRange(String parameter, float value, float min, float max) {
        if (value < min || value > max) {
            System.out.println(parameter + " is out of range!");
            return false;
        }
        return true;
    }

    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return checkRange("Temperature", temperature, 0, 45) &&
               checkRange("State of Charge", soc, 20, 80) &&
               checkRange("Charge Rate", chargeRate, 0, 0.8f);
    }

    public static void main(String[] args) {
        // ✅ Valid case
        assert(batteryIsOk(25, 70, 0.7f));

        // ✅ Temperature out of range
        assert(!batteryIsOk(-1, 50, 0.7f)); // below min
        assert(!batteryIsOk(46, 50, 0.7f)); // above max

        // ✅ SOC out of range
        assert(!batteryIsOk(25, 10, 0.7f)); // below min
        assert(!batteryIsOk(25, 81, 0.7f)); // above max

        // ✅ Charge rate out of range
        assert(!batteryIsOk(25, 50, 0.9f)); // above max

        // ✅ Edge cases (should pass)
        assert(batteryIsOk(0, 20, 0.0f));    // all at lower limit
        assert(batteryIsOk(45, 80, 0.8f));   // all at upper limit

        System.out.println("All test cases passed!");
    }
}
