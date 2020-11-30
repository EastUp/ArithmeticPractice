package practice2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void push(int num) {
            stackPush.push(num);
        }

        public int poll(){
            if(stackPush.isEmpty() && stackPop.isEmpty()){
                return 0;
            }
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
            return stackPop.pop();
        }

        public int peek(){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
            return stackPop.peek();
        }
    }

    public static class TwoQueuesStack {
        Queue<Integer> queue;
        Queue<Integer> help;
        public TwoQueuesStack(){
            queue = new LinkedList<Integer>();
            help = new LinkedList<>();
        }

        public void push(int num){
            queue.offer(num);
        }

        public int peek(){
            if(queue.isEmpty())
                throw new RuntimeException("queue is Empty");
            while (queue.size()!=1){
                help.offer(queue.poll());
            }
            int res = queue.poll();
            help.offer(res);
            swap();
            return res;
        }

        public int pop(){
            if(queue.isEmpty())
                throw new RuntimeException("queue is Empty");
            while (queue.size()!=1){
                help.offer(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> temp;
            temp = help;
            help = queue;
            queue = temp;
        }

    }

}
