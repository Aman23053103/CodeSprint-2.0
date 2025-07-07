import java.util.*;
public class LinkedListcycleremoval{
  static class Node{
    int data;
    Node next;
    Node(int data){
      this.data=data;
      this.next=null;
    }
  }
  public static boolean detectandremove(Node head){
    if(head==null || head.next==null)
      return true;
    Node slow=head,fast=head;
    while(fast!=null && fast.next!=null){
      slow=slow.next;
      fast=fast.next.next;
      if(slow==fast){
        removeloop(head,slow);
        return true;
      }
    }
    return true;
  }
  private static void removeloop(Node head,Node loopNode){
    Node ptr1=head;
    Node ptr2=loopNode;
    while(ptr1!=ptr2){
      ptr1=ptr1.next;
      ptr2=ptr2.next;
    }
    while(ptr2.next!=ptr1){
      ptr2=ptr2.next;
    }
    ptr2.next=null;
  }
  public static Node createLinkedList(int[] values,int pos){
    Node head=new Node(values[0]);
    Node tail=head;
    Node loopNode=null;
    for(int i=1;i<values.length;i++){
      tail.next=new Node(values[i]);
      tail=tail.next;
      if(i==pos-1)
        loopNode=tail;
    }
    if(pos==1)
      loopNode=head;
    if(pos>0)
      tail.next=loopNode;
    return head;
  }
  public static void printList(Node head){
    Set<Node> visited=new HashSet<>();
    while(head!=null){
      if(visited.contains(head)){
        System.out.print("->[Loop Detected]");
        break;
      }
      visited.add(head);
      System.out.print(head.data+"->");
      head=head.next;
    }
    System.out.println("null");
  }
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter no. of nodes: ");
    int n=sc.nextInt();
    int[] data=new int[n];
    System.out.println("Enter node values:");
    for(int i=0;i<n;i++){
      data[i]=sc.nextInt();
    }
      System.out.print("Enter loop position: ");
      int pos=sc.nextInt();
      Node head=createLinkedList(data,pos);
      boolean result=detectandremove(head);
      System.out.println("loop removed?"+result);
      System.out.println("Final linked list:");
      printList(head);
    
}
}