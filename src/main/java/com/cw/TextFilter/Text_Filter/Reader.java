package com.cw.TextFilter.Text_Filter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Reader implements Runnable {
	static int o = 0 ;
	private InputStream fileReader;

	public Reader(InputStream fileReader2) {
		// TODO Auto-generated constructor stub
		this.fileReader = fileReader2;
	}

	public void run() {
		while(true) {
			read();
		}
	}

	private void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void read() {
		try {
			System.out.println((char)fileReader.read() + " " + o);
			o++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
