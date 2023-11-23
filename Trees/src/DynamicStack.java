public class DynamicStack extends Stack {

    Node array[];
    int stackPointer;

    public DynamicStack(int size) {
        array = new Node[size];
        stackPointer = -1;
    }

    public boolean isEmpty() {
        return stackPointer < 0;
    }

    @Override
    public void push(Object value) {

        if (stackPointer + 1 == array.length) {

            // TODO: create new array of larger size.
            Node[] arrayn = new Node[array.length * 2];

            // TODO: move all the elements to the new array.
            for (int i = 0; i < array.length; i++) {
                arrayn[i] = array[i];
            }

            // TODO: replace the stack array with the new one.
            array = arrayn;
        }

        stackPointer += 1;
        array[stackPointer] = (Node) value;
    }

    public Node pop()/* throws Exception*/ {
        //throw exception if the stack is empty while popping.
        /*if (stackPointer == -1) {
            throw new Exception("The stack is completely empty");
        }*/
        //TODO: it is more optimal to check if the number of elements is
        // half the old array but 1/4 of the new array.
        if (stackPointer <  array.length / 4) {
            //TODO: create new array of half the size.
            Node[] arrayn = new Node[array.length / 2];
            // TODO: move all the elements to the new array.
            for (int i = 0; i < arrayn.length; i++) {
                arrayn[i] = array[i];
            }
            // TODO: replace the stack array with the new one.
            array = arrayn;
        }
        Node value = array[stackPointer];
        stackPointer -= 1;
        return value;
    }


}

