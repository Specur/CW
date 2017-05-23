package com.cw.TextFilter.Text_Filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Writer implements Runnable {
OutputStream fileWriter;
	public Writer(OutputStream fileWriter2) {
		// TODO Auto-generated constructor stub
		this.fileWriter = fileWriter2;
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true){
		write();
		sleep();
		}
	}

	private void sleep() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void write() {
		try {
			fileWriter.write('c');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
