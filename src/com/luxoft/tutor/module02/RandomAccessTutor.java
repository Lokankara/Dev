package com.luxoft.tutor.module02;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class RandomAccessTutor {

    private static final String FILES_TEST_PATH = "files/test.txt";

    /**
     * The method should open the file RandomAccessFile on path FILES_TEST_PATH
     * and write there the number 10 (type Integer), and then the string "test line"
     */
    public void randomAccessWrite() {
        try (RandomAccessFile raf = access("rw")) {

            raf.writeInt(10);

            raf.writeChars("test line");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method should open the file RandomAccessFile on path FILES_TEST_PATH,
     * skip the number 10 and the word "test" (without reading them),
     * jump to the fifth letter, read and return the string "line"
     */
    public String randomAccessRead() {
        try (RandomAccessFile raf = access("r")) {

            raf.seek(14);

            return raf.readLine();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    protected static RandomAccessFile access(String key) throws FileNotFoundException {
        return new RandomAccessFile(FILES_TEST_PATH, key);
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

    @Test
    public void testRandomAccess() throws UnsupportedEncodingException {
        randomAccessWrite();
        String s = null;
        int i = -1;
        try {
            RandomAccessFile f = new RandomAccessFile(FILES_TEST_PATH, "r");
            i = f.readInt();
            s = f.readLine();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(10, i);
        s = new String(s.getBytes("UTF-8"), "Unicode");
        assertEquals("test line", s);
        String read = randomAccessRead();
        read = new String(read.getBytes("UTF-8"), "Unicode");
        assertEquals("line", read);
    }
}
