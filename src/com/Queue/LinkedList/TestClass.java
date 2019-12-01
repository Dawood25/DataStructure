package com.Queue.LinkedList;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue qu1=new Queue();
		Queue qu2=new Queue();
		qu1.enQueue(10);
		qu1.enQueue(20);
		qu1.enQueue(30);
		qu1.enQueue(40);
		qu1.enQueue(50);
		qu1.enQueue(60);
		qu1.enQueue(70);
		qu2.enQueue(100);
		qu2.enQueue(200);
		qu2.enQueue(300);
		qu2.enQueue(400);
		qu2.enQueue(500);
		qu2.enQueue(600);
		while(!qu1.isEmpty()) {
			qu1.deQueue();
		}
		while(!qu2.isEmpty()) {
			qu2.deQueue();
		}
		
	}

}
