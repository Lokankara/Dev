package com.luxoft.jva008.module02;

import static org.junit.Assert.assertEquals;

import java.io.*;

import org.junit.Before;
import org.junit.Test;

public class DataStreamTutor {
    private static final String FILES_TEST_PATH = "files/test.txt";
    private static final String TEST_LINE = "test line";

    /**
     * Writes a string TEST_LINE to the file FILES_TEST_PATH, using
     * method writeUTF of class DataOutputStream.
     * Also use BufferedOutputStream for buffering.
     * Then close the stream.
     */
    public void writeToFile() {


        try (FileOutputStream outputStream = new FileOutputStream(FILES_TEST_PATH)) {

            BufferedOutputStream buffered = new BufferedOutputStream(outputStream);

            DataOutputStream dataOutput = new DataOutputStream(buffered);

            dataOutput.writeUTF(TEST_LINE);

            dataOutput.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads a line from a file using the method readUTF and returns it.
     *
     * @return
     */
    public String readFromFile() {

        try (FileInputStream inputStream = new FileInputStream(FILES_TEST_PATH)) {

            BufferedInputStream buffered = new BufferedInputStream(inputStream);

            DataInputStream dataInput = new DataInputStream(buffered);

            dataInput.close();

            return dataInput.readUTF();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testStream() {
        writeToFile();
        String s = readFromFile();
        assertEquals(TEST_LINE, s);
    }

    @Before
    public void createFile() {
        File f = new File(FILES_TEST_PATH);
        try {
            f.delete();
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
