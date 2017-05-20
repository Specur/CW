package com.cw.TextFilter.Text_Filter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Hello world!
 *
 */
public class App {
	private static OutputStream fileWriter;
	private static InputStream fileReader;
	private static Thread threadWriter;
	private static Thread threadReader;
	static PipedInputStream pin;

	public static void main(String[] args) {
		stickInputOutput();
		startThread();
		closeFile(threadWriter, threadReader);

	}

	private static void stickInputOutput() {
		PipedOutputStream pout = new PipedOutputStream();
		try {
			pin = new PipedInputStream(pout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		fileReader = pin;
		fileWriter = pout;
	}

	private static void startThread() {
		Writer writer = new Writer(fileWriter);
		Reader reader = new Reader(fileReader);
		threadReader = new Thread(reader);
		threadWriter = new Thread(writer);

		threadReader.start();
		threadWriter.start();
	}

	private static void closeFile(Thread threadWriter, Thread threadReader) {
		try {
			threadWriter.join();
			threadReader.join();
			try {
				fileWriter.close();
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}