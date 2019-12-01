package com.Queue.LinkedList;



public class Queue {
	Qnode front;
	Qnode rear;
	static class Qnode{
		Object data;
		Qnode next;		
		public Qnode(Object data) {
			this.data=data;
		}
	}
	
	public void enQueue(Object data) {
		Qnode qnode=new Qnode(data);
		if(front==null) {
			front =qnode;
			rear=qnode;			
		}else {
			rear.next=qnode;
			rear=qnode;
		}
	}
	public Object deQueue() {	
		if(front==null) {
			System.out.println("Queue is empty");
			return null;
		}else {
			Qnode temp= front;
			//System.out.println("Deque refrence and data is=>"+temp+", "+temp.data);
			front=front.next;
			return temp.data;
		}
	}
	public Qnode peek() {
		return front;
	}
	public boolean isEmpty() {
		if(front==null) {
			return true;
		}else {
			return false;
		}
	}
}
