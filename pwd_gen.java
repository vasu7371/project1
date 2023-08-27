public class PasswordGenerator {
    public static void main(String[] args) {
        int length = 12; // Set the desired password length
        
        String upperC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerC = "abcdefghijklmnopqrstuvwxyz";
        String digitC = "0123456789";
        String specialC = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        String password = generatePassword(length, upperC, lowerC, digitC, specialC);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, String upperC, String lowerC, String digitC, String specialC) {
        String allCharacters = upperC + lowerC + digitC + specialC;
        StringBuilder password = new StringBuilder();

        long k = System.nanoTime();
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (k % allCharacters.length());
            k = (k * 31 + 17) % 1000000007; // A simple pseudo-random number generator
            password.append(allCharacters.charAt(randomIndex));
        }

        return password.toString();
    }
}

