package practice3;

import basic_class_03.Code_04_DogCatQueue;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static class DogCount extends Dog {
        int count;

        public DogCount(int count) {
            super();
            this.count = count;
        }
    }

    public static class CatCount extends Cat {
        int count;

        public CatCount(int count) {
            super();
            this.count = count;
        }
    }

    public static class DogCatQue {
        Queue<DogCount> dogCounts = new LinkedList<>();
        Queue<CatCount> catCounts = new LinkedList<>();
        int count = 0;

        public void offer(Pet pet) {
            if (pet.type.equals("dog")) {
                dogCounts.offer(new DogCount(count++));
            } else if (pet.type.equals("cat")) {
                catCounts.offer(new CatCount(count++));
            }else{
                throw new RuntimeException("err not dog or cat");
            }
        }

        public Pet pollAll(){
            if (!isDogEmpty() && !isCatEmpty()){
                if(dogCounts.peek().count>catCounts.peek().count){
                    return dogCounts.poll();
                }else{
                    return catCounts.poll();
                }
            }else{
                if (!isDogEmpty())
                    return dogCounts.poll();
                else if(!isCatEmpty())
                    return catCounts.poll();
                else
                    throw new RuntimeException("queue is empty");
            }
        }

        public Dog pollDog(){
            if(!dogCounts.isEmpty())
                return dogCounts.poll();
            else
                throw new RuntimeException("dog queue is empty");
        }

        public Cat pollCat(){
            if(!catCounts.isEmpty())
                return catCounts.poll();
            else
                throw new RuntimeException("cat queue is empty");
        }

        public boolean isEmpty(){
            return dogCounts.isEmpty() && catCounts.isEmpty();
        }

        public boolean isDogEmpty(){
            return dogCounts.isEmpty();
        }

        public boolean isCatEmpty(){
            return catCounts.isEmpty();
        }
    }

    public static void main(String[] args) {
        DogCatQue test = new DogCatQue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.offer(dog1);
        test.offer(cat1);
        test.offer(dog2);
        test.offer(cat2);
        test.offer(dog3);
        test.offer(cat3);

        test.offer(dog1);
        test.offer(cat1);
        test.offer(dog2);
        test.offer(cat2);
        test.offer(dog3);
        test.offer(cat3);

        test.offer(dog1);
        test.offer(cat1);
        test.offer(dog2);
        test.offer(cat2);
        test.offer(dog3);
        test.offer(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }
}
