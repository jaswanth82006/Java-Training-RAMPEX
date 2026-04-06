class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class LinkedList{
    Node head;

    // insert Begin
    public void insertAtStart(int data){
        Node newNode= new Node(data);
        newNode.next=head;
        head=newNode;
    }
    // insert End
    public void insertAtEnd(int data){
        Node newNode= new Node(data);
        Node temp=head;
        if(head==null){
            head = newNode;
            return;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    // Delete Start
    public void deleteAtStart(){
        if(head==null) return;
        head=head.next;
    }

    // Delete End
    public void deleteAtEnd(){
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }

    //insert At position
    public void insertAtpos(int pos,int data){
        if(pos==0){
            insertAtStart(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for(int i=0;i<pos-1;i++){
            if(temp==null) return;
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    
    }

    // delete At pos
    public void deleteAtpos(int pos){
        Node temp= head;
        for(int i=0;i<pos-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }


    // Display
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print("null");
    }

}





public class Linked {
    public static void main(String[] args) {
        LinkedList l1= new LinkedList();
        l1.insertAtStart(12);
        l1.insertAtEnd(10);
        l1.insertAtEnd(15);
        l1.insertAtpos(1,30);
        l1.deleteAtEnd();
        l1.deleteAtpos(1);
        l1.display();
    }
}
