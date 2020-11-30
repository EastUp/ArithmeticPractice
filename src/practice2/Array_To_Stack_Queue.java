package practice2;

public class Array_To_Stack_Queue {
    public static class ArrayStack<T extends Object> {
        private T[] arr;
        private int size;
        private int defaultSize = 10;

        public ArrayStack(int initialSize){
            if(initialSize <= 0){
                throw new IllegalArgumentException("The initailSize is less than 0");
            }
            arr = (T[])new Object[initialSize];
        }

        public ArrayStack(){
            arr = (T[])new Object[defaultSize];
        }

        public void push(T t){
            if(size == arr.length){
                growSize();
            }
            arr[size++] = t;
        }

        private void growSize() {
            int newSize = arr.length << 1;
            T[] newArray = (T[])new Object[newSize];
            System.arraycopy(arr,0,newArray,0,arr.length);
            arr = newArray;
        }

        public T pop(){
            if(size>0){
                return arr[--size];
            }
            return null;
        }

        public T peek(){
            if(size>0){
                return arr[size-1];
            }
            return null;
        }
    }

    public static class ArrayQueue<T extends Object>{
        private T[] arr;
        private int head;
        private int tail;
        private int size;
        private int defaultSize = 10;

        public ArrayQueue(int initialSize) {
            if(initialSize <= 0){
                throw new IllegalArgumentException("The initailSize is less than 0");
            }
            arr = (T[])new Object[initialSize];
        }

        public ArrayQueue() {
            arr = (T[])new Object[defaultSize];
        }

        public void offer(T t){
            if(size == arr.length){
                growSize();
            }
            size++;
            if(tail == arr.length){
                tail = 0;
            }
            arr[tail++] = t;
        }

        private void growSize() {
            int newSize = arr.length << 1;
            T[] newArr = (T[])new Object[newSize];
            System.arraycopy(arr,0,newArr,0,arr.length);
            arr = newArr;
        }

        public T pop(){
            if(size > 0){
                size --;
                if(head == arr.length)
                    head = 0;
                return arr[head++];
            }
            return null;
        }

        public T peek(){
            if(size > 0){
                return arr[head];
            }
            return null;
        }

    }


    public static void main(String[] args){
//        ArrayStack<String> stack = new ArrayStack<>(3);
//        stack.push("a");
//        stack.push("b");
//        stack.push("c");
//        stack.push("d");
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        ArrayQueue<String> queue = new ArrayQueue<>(3);
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.offer("d");
        queue.offer("e");
    }

}
