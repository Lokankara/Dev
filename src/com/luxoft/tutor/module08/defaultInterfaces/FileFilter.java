package com.luxoft.tutor.module08.defaultInterfaces;

import java.io.File;

@FunctionalInterface
public interface FileFilter {
    boolean accept(File pathname);
}
