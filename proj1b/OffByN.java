public class OffByN implements CharacterComparator{
    int num = 0;

    OffByN(int N) {
        num = N;

    }
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (Math.abs(diff) == num) {
            return true;
        } else {
            return false;
        }

    }
}
