public class Main {
    public static void listWithoutClass() {
        // Create the first node in the list, and set head to point it out
        Node head = new Node(1);
        // Let tail point at the only node in the list
        Node tail = head;

        // Insert more nodes
        for(int i = 10; i < 100; i += 10) {
            // Create a new node
            Node newNode = new Node(i);
            // Let the previous tail node point at the new node
            tail.setNext(newNode);
            // Make the new node the new tail node
            tail = newNode;
        }

        // Print the list
        // Create tmp, so we have something that we can move through the list
        // Let tmp start from the head of the list
        Node tmp = head;
        // As long as tmp still points at a node
        while(tmp != null) {
            // Print the data in that node
            System.out.print(tmp.getData());
            // and move tmp to the next node
            // When we are at the tail node and move to the next, tmp will become null
            tmp = tmp.getNext();
            // If we have a next node, print an arrow
            if(tmp != null) {
                System.out.print(" -> ");
            }
            else { // If not, print something to indicate the end of the list
                System.out.println(" -|");
            }
        }

    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();

        ll.insertHead(1);
        ll.insertHead(2);
        ll.insertHead(3);
        ll.printList(); // 3 -> 2 -> 1 -|

        ll.insertTail(4);
        ll.insertTail(5);
        ll.insertTail(6);
        ll.printList(); // 3 -> 2 -> 1 -> 4 -> 5 -> 6 -|

        ll.removeTail();
        ll.removeTail();
        ll.printList(); // 3 -> 2 -> 1 -> 4 -|

        ll.removeHead();
        ll.removeHead();
        ll.printList(); // 1 -> 4 -|
    }
}