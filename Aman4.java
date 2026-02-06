public class Aman4 {

    /**
     * Next Kth Alphabet
     * @param args
     */
    
      public static void main(String[] args) {
        System.out.println(kthAlphabet('a', 3)); // d
        System.out.println(kthAlphabet('x', 5)); // c
        System.out.println(kthAlphabet('z', 1)); // a
    }

    public static char kthAlphabet(char start, int k) {
        int s = start - 'a';        // convert to 0-25
        int target = (s + k) % 26;  // circular move
        return (char)(target + 'a');
    }
}
