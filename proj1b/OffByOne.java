public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        //实现off by one的效果
        int diff = x - y;
        return Math.abs(diff) == 1;


    }
}
