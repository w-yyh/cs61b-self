public class LinkedListDeque<Item> implements Deque<Item> {
    private class Tnode {
        private Item item;
        private Tnode prev;
        private Tnode next;
        public Tnode(Item item, Tnode pre, Tnode nex) {
            this.item = item;
            prev = pre;
            next = nex;
        }
        public Tnode() {
        }
    }

    //变量部分
    private Tnode sentinel = new Tnode();
    private int size = 0;

    //method
    public LinkedListDeque() {
        size = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    public void addFirst(Item item) {
        Tnode newone = new Tnode(item, sentinel, sentinel.next);
        sentinel.next.prev = newone;
        sentinel.next = newone;
        size += 1;

    }
    public void addLast(Item item) {
        Tnode newone = new Tnode(item, sentinel.prev, sentinel);
        sentinel.prev.next = newone;
        sentinel.prev = newone;
        size += 1;
    }

    public void printDeque() {
        Tnode temp = sentinel.next;
        while (temp != sentinel) {
            System.out.println(temp.item);
            temp = temp.next;
        }

    }

    public boolean isEmpty() {
        return sentinel.next == sentinel && sentinel.prev == sentinel;
    }

    public int size() {
        return size;
    }

    public Item removeFirst() {
        //先检测是否真的存在可以被移除的值
        if (sentinel.next == sentinel) {
            return null;
        }
        Item temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;


        //不仅要处理sentinel与node之间的关系，同时还要处理node之间的关系
        //注意，这里有一个点是，如果deque里面只有一个值，那么不仅要改变sentinel的next，同时要改变previous
        if (size == 1) {
            sentinel.prev = sentinel;
        }
        size -= 1;
        return temp;
    }

    public Item removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        Item temp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        if (size == 1) {
            sentinel.next = sentinel;
        }
        size -= 1;
        return temp;
    }

    public Item get(int index) {
        if (index > size - 1) {
            return null;
        }
        Tnode needle = sentinel.next;
        int count = 0;
        while (count != index) {
            needle = needle.next;
            count += 1;
        }
        return needle.item;

    }

    public Item getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }
        Tnode needle = sentinel.next;
        return helperget(index, needle);

    }
    private Item helperget(int index, Tnode temp) {
        if (index == 0) {
            return temp.item;
        }
        return helperget(index - 1, temp.next);
    }


}
