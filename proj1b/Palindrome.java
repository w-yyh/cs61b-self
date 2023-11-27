public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> container = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            container.addLast(word.charAt(i));
        }
        return container;
    }

    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        } else {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == word.charAt(word.length() -1 - i)) {
                    count += 1;
                }
            }
            return count == word.length();
        }

    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() <= 1) {
            return true;
        } else {
            if (word.length() % 2 == 1) { //当情况为奇数的时候
                int temp = 0;
                while (temp < (word.length() - 1) / 2) {
                    if (!cc.equalChars(word.charAt(temp),word.charAt(word.length() - 1 - temp))) {
                        return false;
                    }
                    temp += 1;
                }
                return true;
            } else {
                int temp = 0;
                while (temp < word.length() / 2) {
                    if (!cc.equalChars(word.charAt(temp),word.charAt(word.length() - 1 - temp))) {
                        return false;
                    }
                    temp += 1;
                }
                return true;
            }
        }
    }
}
