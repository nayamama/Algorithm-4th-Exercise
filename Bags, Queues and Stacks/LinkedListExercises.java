import edu.princeton.cs.algs4.StdOut;

public class LinkedListExercises <Item>{
    private static Node first;  // header
    private static Node last;   // tail
    private static int n = 0;   // number of nodes

    public static class Node<Item>{
        private Item val;
        private Node next = null;

        public Node(Item e){val = e;}

        public boolean equals(Node that) { return this.val == that.val; }
    }

    public boolean isEmpty(){return n == 0;}

    public int size(){return n;}

    public Object getFirst(){return first.val;}

    public Object getLast() {return last.val;}

    public void add(Node a){
        if(isEmpty()) first = last = a;
        else{
            last.next = a;
            last = a;
        }
        n++;
    }

    // removes the last node in a linked list
    public void removeLast(){
        if(last == null) throw new NullPointerException("The last node is null.");
        else{
            if(first == last){
                first = null;
                last = null;
            }else{
                Node current = first;
                while(current.next != last) current = current.next;
                last = current;
                current.next = null;
            }
            n--;
        }
    }

    // deletes the kth element in a linked list, if it exists.
    public void delete(int k){
        if(k > n) throw new IllegalArgumentException("K exceeds the size of list.");
        if(k == 1){ first = first.next; }
       else{
            Node cur = first;
            int count = 1;
            while(count < k - 1) {
                cur = cur.next;
                count++;
            }
            if(cur.next == last){
                last = cur;
                last.next = null;
            }else{
                cur.next = cur.next.next;
            }
        }
        n--;
    }

    // takes a linked list and a string key as arguments and returns true if some node in the list has key as its item field,
    // false otherwise.
    public boolean find(String key){
        Node cur = first;
        while(cur != null){
            if(cur.val == key) return true;
            cur = cur.next;
        }
        return false;
    }

    // takes a linked-list Node as argument and removes the node following the given one (and does nothing
    // if the argument or the next field in the argument node is null).
    public void removeAfter(Node c){
        if(size() == 0 || c.equals(last)) return;
        Node cur = first;
        while(cur.next!= null){
            if(cur.equals(c)){
                if(cur.next.equals(last)){
                    last = cur;
                    last.next = null;
                }
                else{
                    cur.next = cur.next.next;
                }
                n--;
                break;
            }
            cur = cur.next;
        }
    }

    public String toString(){
        Node current = first;
        String res = "";
        while(current != null){
            res += current.val + " ";
            current = current.next;
        }
        return res;
    }

    public static void main(String[] args){
        LinkedListExercises<String> link = new LinkedListExercises<>();
        link.add(new Node("meng"));
        link.add(new Node("qi"));
        link.add(new Node("naya"));
        link.add(new Node("charm"));

        StdOut.println(link);
        Node node = new Node("meng");
        //link.removeLast();
        //link.delete(4);
        //StdOut.println(link.find("at"));
        link.removeAfter(node);
        StdOut.println(link);
        StdOut.printf("The head of link is %s, the tail of link is %s, the size is %d.\n", link.getFirst(), link.getLast(), link.size());
    }
}
