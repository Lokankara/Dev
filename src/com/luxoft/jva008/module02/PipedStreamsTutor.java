package com.luxoft.jva008.module02;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamsTutor {

	public static void main(String[] args) {

		try (PipedOutputStream out = new PipedOutputStream(); PipedInputStream in = new PipedInputStream(out)) {
			out.write('L');
			out.write('U');
			out.write('X');
			out.write('O');
			out.write('F');
			out.write('T');

			for (int i = 0; i < 6; i++) {
				System.out.println((char) in.read());
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
