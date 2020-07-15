package com.exercises.week6;

import java.util.NoSuchElementException;

public class IntLinkedQueue implements IntQueueInterface{
	
	private IntNode front;
	private IntNode rear;
	private int manyNodes;
	
	public IntLinkedQueue(){
		this.manyNodes = 0;
		this.front = null;
		this.rear = null;
	}
	
	
	@Override
	public void add(int item) {
		if (isEmpty()){
			//insert first item
			front = new IntNode(item,null);
			rear = front;
		}else{
			rear.addNodeAfter(item);
			rear = rear.getLink();
		}
		manyNodes++;	
	}

	@Override
	public int remove() {
		int answer;
		
		if (manyNodes == 0){
			System.out.println("Queue is Empty");
			throw new NoSuchElementException();
		}
		answer = front.getData();
		front = front.getLink();
		manyNodes--;
		if (manyNodes == 0)
			rear = null;
		return answer;
	}

	public int size() {
		return this.manyNodes;
	}
	@Override
	public boolean isEmpty() {
		return (this.manyNodes == 0);
	}
	
	public String toString(){
		
		String output  = "[\t";
		
		IntNode cursor = front;
		
		while (cursor != null){
			output += cursor.getData()+"\t";
			cursor = cursor.getLink();
		}
		
		output +="]";
		return output;
	}

	public double average() {
		IntNode cursor = front;
		int total = 0;
		while(cursor != null) {
			total += cursor.getData();
			cursor = cursor.getLink();
		}

		return (total/this.size());
	}
	
	

}
