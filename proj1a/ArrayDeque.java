public class ArrayDeque<T> {
    public static final int MINARRAYLENGTH = 16;
    private int size = 0;
    private T[] arr;
    private int capacity = 8;
    private int front;
    private int rear;
    //数组回绕的实现方法是，在每一次涉及到改变数组中元素数量的操作时，对数组的元素进行检查
    private void check() {
        if (front < 0 || front > capacity - 1) {
            front = (capacity + front) % capacity;
        }
        if (rear < 0 || rear > capacity - 1) {
            rear = (capacity + rear) % capacity;
        }

    }

    public ArrayDeque() {
        arr = (T[]) new Object[8];
        front = 7; //初始化时分别位于尾部和头部
        rear = 0;
    }
    private void resize(String n) {
        if (n.equals("up")) {
            //新数组的初始化
            int newCapacity = capacity * 2;
            resizeHelper(newCapacity);
        } else if (n.equals("down")) {
            int newCapacity = capacity / 2;
            resizeHelper(newCapacity);
        }


    }
    private void resizeHelper(int newCapacity) {
        T[] newarrary = (T[]) new Object[newCapacity];
        if (front > rear) {
            int diff = capacity - front;
            //在将原数组复制到新的数组中
            System.arraycopy(arr, front + 1, newarrary, 0, diff - 1);
            System.arraycopy(arr, 0, newarrary, diff - 1, capacity - diff + 1);
        } else {
            System.arraycopy(arr, front + 1, newarrary, 0, size);
        }
        //对齐rear与front
        rear = size - 1;
        front = newCapacity - 1;
        //更新数据
        capacity = newCapacity;
        arr = newarrary;

    }

    public void addFirst(T item) {
        size += 1;
        if (size > capacity) {
            resize("up");
        }
        arr[front] = item;
        front -= 1;
        check();
    }

    public void addLast(T item) {
        size += 1;
        if (size > capacity) {
            resize("up");
        }
        arr[rear] = item;
        rear += 1;
        check();
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public T get(int index) {
        return arr[(front + 1 + index) % capacity];
    }
    private void checkR() {
        double R = (double) size / capacity;
        check();
        if (R < 0.25 && capacity > MINARRAYLENGTH) {
            resize("down");
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T temp = arr[(front + 1)%capacity];
        front += 1;
        checkR();
        return temp;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        if (rear - 1 < 0) {
            rear = capacity - 1;
        }
        T temp = arr[rear - 1];
        rear -= 1;
        checkR();
        return temp;

    }
    public void printDeque() {
        if (front > rear) {
            int temp = capacity + rear;
            for (int i = front + 1; i < temp; i++) {
                System.out.println(arr[i % capacity]);
            }
        } else {
            for (int i = front + 1; i < rear; i++) { //+1是因为现在front指向了有数字的项的前一项，如果打印的话会打印出来null
                System.out.println(arr[i]);

            }

        }

    }

}
