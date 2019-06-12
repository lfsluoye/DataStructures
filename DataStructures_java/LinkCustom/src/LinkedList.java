public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

//    private Node head;
    private Node dummyHead;
    private int size;

    public LinkedList(){
//        head = null;
        dummyHead = new Node();
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }



    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        prev.next = new Node(e, prev.next);
        size++;
//        if (index == 0)
//            addFirst(e);
//        else{
//            Node prev = head;
//            for (int i = 0; i < index-1; i++) {
//                prev = prev.next;
//                //  Node node = new Node(e);
//                //  node.next = prev.next;
//                //  prev.next = node;
//                prev.next = new Node(e, prev.next);
//            }
//        }
    }
    // 在链表投添加新的元素e
    public void addFirst(E e){
        //        Node node = new Node(e);
        //        node.next = head;
        //        head = node;
//        head = new Node(e, head);
//        size ++;
        add(0, e);
    }
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的第index(0-based)个位置的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size-1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i ++)
            cur = cur.next;
        cur.e = e;
    }

    //查询链表中是否有元素e
    public boolean contails(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    public E remove(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    //从链表中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    //从链表中删除元素e
    public  void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");
        return res.toString();
    }

}
