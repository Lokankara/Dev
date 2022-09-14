package com.luxoft.tutor.module08.defaultmethods;

import java.io.File;

@FunctionalInterface
public interface FileFilter {
    boolean accept(File pathname);
}
