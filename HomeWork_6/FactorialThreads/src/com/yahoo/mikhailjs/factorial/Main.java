package com.yahoo.mikhailjs.factorial;

public class Main {

	public static void main(String[] args) {
		Thread[] threads = new Thread[100];

		for(int i = 0; i < threads.length; i++) {
			threads[i] = newTask(i+1);
			threads[i].start();
		}
		
		for(Thread i: threads) {
			try {
				i.join();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static Thread newTask(int id) {
		return new Thread(new CalculateFactorial(id));
	}
	
}
