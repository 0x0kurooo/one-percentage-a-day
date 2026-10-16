class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int cap;
    Node head;
    Node tail;
    Map<Integer, Node> dict = new HashMap<>();

    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;

        cap = capacity;
    }
    
    public int get(int key) {
        if (!dict.containsKey(key)) {
            return -1;
        }

        Node node = dict.get(key);
        removeNode(node);
        addHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (dict.containsKey(key)) {
            Node node = dict.get(key);
            node.val = value;
            removeNode(node);
            addHead(node);
        } else {
            Node node = new Node(key, value);
            dict.put(key, node);
            addHead(node);
            if (dict.size() > cap) {
                Node tailPrev = tail.prev;
                dict.remove(tailPrev.key);
                removeNode(tailPrev);
            }
        }
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addHead(Node node) {
        Node headNext = head.next;
        node.prev = head;
        node.next = headNext;

        headNext.prev = node;
        head.next = node;
    }
}
