public class LinkedListDeque<T> {
    private class Tnode {
        private T item;
        private Tnode prev;
        private Tnode next;
        public Tnode(T item, Tnode pre, Tnode nex) {
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
    public void addFirst(T item) {
        Tnode newone = new Tnode(item, sentinel, sentinel.next);
        sentinel.next.prev = newone;
        sentinel.next = newone;
        size += 1;

    }
    public void addLast(T item) {
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

    public T removeFirst() {
        //先检测是否真的存在可以被移除的值
        if (sentinel.next == sentinel) {
            return null;
        }
        T temp = sentinel.next.item;
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

    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        T temp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        if (size == 1) {
            sentinel.next = sentinel;
        }
        size -= 1;
        return temp;
    }

    public T get(int index) {
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

    public T getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }
        Tnode needle = sentinel.next;
        return helperget(index, needle);

    }
    private T helperget(int index, Tnode temp) {
        if (index == 0) {
            return temp.item;
        }
        return helperget(index - 1, temp.next);
    }


}
