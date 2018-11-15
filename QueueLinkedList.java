public class QueueLinkedList {
    private static class Link {
        public Client data;
        public Link next;

        public Link(Client c){
            data = c;
        }
        public Link (Client c, Link n){
            data = c;
            next = n;
        }


    }
    private Link front;
    private Link back;
    private int size;
    private double average;

    public void SinglyLinkedList(){
        front = null;
        back = null;
        size = 0;
    }

    public void enqueue(Client c){
        Link newLink = new Link(c);
        if (size == 0) {
            front = newLink;
        }
        else{
            back.next = newLink;
        }
        back = newLink;
        size++;
    }

    public Client dequeue(){
        if (front == null) {
            return null;
        }
        Client headData = front.data;
        front = front.next;
        size--;
        return headData;

    }
    public int getNumberInList(){
        return size;
    }

    public Client switchQueue(){

        if (front == null || front.next == null){
            return null;
        }
        Link node = front;
        Link oldNode = null;
        while(node.next.next != null) {
            node = node.next;
            oldNode = node; //penultimate node
        }
        Client s = node.next.data;
        node.next = null;
        back = node;
        size--;
        return s;
    }

    public void increment(){
        Link pointer = front;
        while (pointer != null){
            int oldTime = pointer.data.getWaitTime();
            pointer.data.setWaitTime(oldTime + 1);
            pointer = pointer.next;
        }
    }

    public void setSwitched(String id){
        Link pointer = front;
        while (pointer != null){
            String retId =  pointer.data.getId() + "";
            if (retId.equals(id)){
                pointer.data.setQueueSwitched(true);
            }

            pointer = pointer.next;
        }
    }

    public boolean isInQueue(String id){
        boolean result = false;
        Link pointer = front;
        while (pointer != null){
            if (pointer.data.getId().equals(id)){
                result = true;
            }

            pointer = pointer.next;
        }
        return result;
    }
    public int addWaitTime(String stopId){
        int totalWaitTime = 0;
        Link pointer = front;
        while (pointer != null){
            //search each node in turn for the id passed in
            System.out.println("addWaitTime " + pointer.data.getId() );
            boolean hasMyId = pointer.data.getId().equals(stopId) ? true : false;
            if (hasMyId == false){
                totalWaitTime += pointer.data.getServerTime();
                System.out.println("added preceding server time " + pointer.data.getServerTime());
            }
            else{
                totalWaitTime += pointer.data.getWaitTime();
                System.out.println("added its own wait time " + pointer.data.getWaitTime());
                break;
            }
            pointer = pointer.next;
        }
        System.out.println("TOTAL UP UNTIL " + totalWaitTime);
        return totalWaitTime;
    }
    public void whatWouldItHaveWaited(String idParam, int wouldHaveWaitedTime){
        Link pointer = front;
        while (pointer != null){
            boolean hasMyId = pointer.data.getId().equals(idParam) ? true : false;
            if (hasMyId == true){
                pointer.data.setWouldHaveWaitedTime(wouldHaveWaitedTime);
                System.out.println("after setting wouldHaveWaitedTime to " + wouldHaveWaitedTime + " on " + pointer.data.getId());
                return;
            }
            pointer = pointer.next;
        }
    }
    public String toString() {
        String str = "";
        for (Link p = front; p != null; p = p.next) {
            str += p.data + ", ";
        }
        return str;
    }
}
