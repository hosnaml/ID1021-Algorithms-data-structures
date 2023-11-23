public class PriorityQueue {

    QNode head;

    QNode last;
    int size;

    private class QNode{
        QNode next;

        Integer value;

        private QNode(QNode list, Integer value){
            this.next = list;
            this.value = value;
        }
    }

    public PriorityQueue(){
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    //The constant time O(n) add function.
    public void add(Integer value){

        QNode newNode = new QNode(null,value);

    //If the queue is empty
        if(head == null){
            head = last = newNode;
            newNode.next = null;
            size++;
            return;
        }

        if(head.next == null){
            //It is added before head.
            if(value <= head.value ){
                newNode.next = head;
                head = newNode;
            }
            //It is added after head.
            else{
                newNode = head.next;
            }
        return;
        }
    //If the head is larger the new head is saved as head.

        if(value < head.value){
            newNode.next = head;
            head = newNode;
        }


    //If the queue is not empty the value is compared to the one in the queue.
    //It goes through the array to find the smallest one larger than the value.
        QNode curr = head.next;
        while (curr.next != null){
            if(curr.value > value){
                newNode.next = curr;
                break;
            }
            curr = curr.next;
        }
    //If the value is larger than any of them.
        if(value > last.value){
            last.next = newNode;
            last = newNode;
        }



    }

    //The constant time O(1) remove.
    public Integer remove() {

        if(head == null){
            return null;
        }

        QNode element = head;
        head = head.next;
        size--;
        return element.value;
    }

    //The linear time remove O(n).
    /*public QNode remove(){

        QNode min = head;
        QNode curr = head;
        QNode prev = null;

        if(head == null){
            return null;
        }

        //We want to find the min.
        while(curr != null){

            if(curr.value < min.value){
                min = curr;
            }
            curr = curr.next;

        }

        //Now we found min and we want to remove it.
        prev = null;
        curr = head;
        while (curr != null){
            if(head == min){
                head = head.next;
                prev = head;
                return head;
            }
            if(curr == min){
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;

        }

        return min;
    }

    //The constant time add O(1).
    public void add(Integer value){

        QNode newNode = new QNode(null,value);

        //If the queue is empty
        if(head == null){
            head = last = newNode;
            newNode.next = null;
            size++;
            return;
        }

        //Add the new item to the end of the queue, and change the last node.
        last.next = newNode;
        last = newNode;

        size++;

    }*/
    public int size(){
        return size;
    }



    }















