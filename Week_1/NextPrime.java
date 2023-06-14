// Question: Given a number, return the next smallest prime number
// Note: A prime number is greater than one and has no other factors other than 1 and itself.
public class NextPrime {
    public static void main(String[] args) {
        int num = 90;
        System.out.println(nextSmallestPrime(num));

    }
    public static int nextSmallestPrime(int num) {
        if (num < 2) {
            return 2;
        }
        boolean isFound = false;
        while (!isFound) {
            num++;
            if (isPrime(num)) {
                isFound = true;
            }
        }
        return num;

    }
    public static boolean isPrime(int num) {
        for(int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
