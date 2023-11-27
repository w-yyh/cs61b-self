public class OffByN implements CharacterComparator {
    private int num = 0;

    public OffByN(int N) {
        num = N;

    }
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return  Math.abs(diff) == num;


    }
}
