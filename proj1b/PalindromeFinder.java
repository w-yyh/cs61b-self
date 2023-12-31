/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    static Palindrome palindrome = new Palindrome();

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome1 = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            CharacterComparator offbyn = new OffByN(0);
            if (palindrome1.isPalindrome(word, offbyn)) {
                System.out.println(word);
            }
        }
    }
}
