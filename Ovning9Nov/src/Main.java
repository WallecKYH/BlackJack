public class Main {

    public static void main(String[] args){
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(4);
        stack.push(8);
        stack.push(9);
        stack.push(7);

        for (int i:Stack.stacklist){
            System.out.println(i);
        }
        System.out.println(Stack.pop());

        for(int i:Stack.stacklist){
            System.out.println(i);
        }
    }
}

