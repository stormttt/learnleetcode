
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */


 //单链表
class ListNode {
    public int val;
    public ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val=val;
    }
}
class MyLinkedList {
    public int size;
    public ListNode head;
    //初始化链表
    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode();
    }
    
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= this.size) {
            return -1;
        }
        ListNode currentNode = head;
        for(int i = 0; i <= index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }
    
    public void addAtHead(int val) {
         addAtIndex(0,val);
        // ListNode newNode = new ListNode(val);
        // newNode.next = this.head;
        // this.head = newNode;
        // this.size = this.size + 1;
        
    }
    
    public void addAtTail(int val) {
        addAtIndex(this.size,val);
        // if(this.size == 0){
        //     addAtHead(val);
        // }
        // ListNode newNode = new ListNode(val);
        // ListNode tmp = this.head;
        // while(tmp.next != null){
        //     tmp = tmp.next;
        // }
        // tmp.next = newNode;
        // newNode.next = null;
        // this.size = this.size + 1;
        
    }
    
    public void addAtIndex(int index, int val) {
        if(index > this.size){
            return;
        }
        if(index < 0){
            index = 0;
        }
        ListNode pred = this.head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pred.next;
        pred.next = newNode;
        this.size = this.size + 1;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}
