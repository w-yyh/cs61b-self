import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    static Palindrome palindrome = new Palindrome();



    // Your tests go here.
    @Test
    public void testequalChars() {
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('c','b'));
        assertFalse(offByOne.equalChars('b','b'));
    }

    @Test
    public void testPalindrome() {


        assertTrue(palindrome.isPalindrome("", offByOne));
    }
}
