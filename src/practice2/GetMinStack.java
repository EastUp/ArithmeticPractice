package practice2;

import java.util.Stack;

public class GetMinStack {
    public static class MyStack1{
        private Stack<Integer> stackData = new Stack<>();
        private Stack<Integer> stackMin = new Stack<>();

        public void push(int t){
            if(stackMin.isEmpty()){
                stackMin.push(t);
            }else if(t <= stackMin.peek()){
                stackMin.push(t);
            }
            stackData.push(t);
        }

        public int pop(){
            Integer value = stackData.pop();
            if(value == stackMin.peek()){
                stackMin.pop();
            }
            return value;
        }

        public int peek(){
            return stackData.peek();
        }

        public int getmin(){
            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getmin());
        stack1.push(4);
        System.out.println(stack1.getmin());
        stack1.push(1);
        System.out.println(stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());

    }

}
