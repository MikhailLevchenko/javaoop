package com.yahoo.mikhailjs.factorial;

import java.math.BigInteger;

public class CalculateFactorial implements Runnable {
	private int threadNumber;

	public CalculateFactorial(int threadNumber) {
		super();
		this.threadNumber = threadNumber;
	}

	@Override
	public void run() {
		BigInteger value = new BigInteger("1");
		
		for (long i = 1; i <= threadNumber; i++) {
			value =  BigInteger.valueOf(i).multiply(value);
		}
		System.out.println(Thread.currentThread().getName().concat(" "+value));
	}

}
