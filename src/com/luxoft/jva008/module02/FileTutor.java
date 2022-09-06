package com.luxoft.jva008.module02;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileTutor {
    private final String FILE_NAME = "test.txt";
    private final String PATH = "test";

    /**
     * The method must create a folder "test" and a file "test.txt" inside it
     * Also, output in the full path to the log file you have created
     */
    public void createFile() {

        File dir = new File(PATH);

        boolean newDir = dir.mkdir();

        System.out.println(newDir);

        File file = new File(PATH + "/" + FILE_NAME);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method should remove the "test" folder and the "test/test.txt" file
     */
    public void deleteFile() {
    }

    @Test
    public void testCreateFile() {
        createFile();
        File f = new File("test/test.txt");
        assertTrue(f.exists());
    }

    @Test
    public void testDeleteFile() {
        deleteFile();
        File f = new File("test/test.txt");
        assertFalse(f.exists());
        assertFalse(new File("test").exists());
    }
}
//TODO FileTutor