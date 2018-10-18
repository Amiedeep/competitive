public class ReverseListWithIndexGroups {

    private Node root;

    public ReverseListWithIndexGroups(Node root) {
        this.root = root;
    }

    private void reverseWithKGroups(int groupSize) {

        Node ptr = root;

        this.root = reverseWithKGroups(root, groupSize);
    }

    private Node reverseWithKGroups(Node node, int groupSize) {

        if (node == null)
            return null;
        int k = 0;
        Node currentNode = node;
        Node nextNode;
        Node prevNode = null;
        while (k < groupSize) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            if (nextNode == null) {
                node.next = null;
                return currentNode;
            }
            prevNode = currentNode;
            currentNode = nextNode;
            k++;
        }
        node.next = reverseWithKGroups(currentNode, groupSize);
        return prevNode;
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5; node5.next = node6;
        node6.next = node7; node7.next = node8; node8.next = null;
        ReverseListWithIndexGroups reverseListWithIndexGroups = new ReverseListWithIndexGroups(node1);

        reverseListWithIndexGroups.printList();
        reverseListWithIndexGroups.reverseWithKGroups(4);
        System.out.println();
        reverseListWithIndexGroups.printList();
    }

    private void printList() {
        Node node = root;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}


class Node
{
    int data;
    Node next;
    Node(int value)
    {
        data=value;
    }
}
