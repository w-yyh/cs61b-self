import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testPalindrome() {
        String word1 = "qwer";
        String word2 = "qwq";
        assertTrue(palindrome.isPalindrome(word2));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome(word1));
        assertTrue(palindrome.isPalindrome("&%&"));
        assertTrue(palindrome.isPalindrome("QaQ"));

    }
}
