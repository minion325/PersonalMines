package me.saif.personalmines.utils;

import java.io.File;

public class Utils {

    public static void deleteFile(File element) {
        if (element == null)
            return;
        if (element.isDirectory() && element.listFiles() != null) {
            for (File sub : element.listFiles()) {
                deleteFile(sub);
            }
        }
        element.delete();
    }
}
