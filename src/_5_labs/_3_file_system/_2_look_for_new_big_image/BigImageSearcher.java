package _5_labs._3_file_system._2_look_for_new_big_image;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BigImageSearcher {
    private static List<File> files = new ArrayList<>();

    public static void main(String[] args) {
        lookForBigImage(new File("C:/Users/User/Desktop/tmp"));
        files.forEach(System.out::println);
    }

    private static void lookForBigImage(File root) {
        if (root.isFile()) {
            files.add(root);
        } else {
            File[] fileArray = root.listFiles(file -> file.isDirectory() ||
                    file.length() > 1024 * 1024 && isImage(file));
            if (fileArray != null) {
                for (File file : fileArray) {
                    lookForBigImage(file);
                }
            }
        }
    }

    private static boolean isImage(File file) {
        String fileName = file.getName();
        return fileName.endsWith(".jpg") || fileName.endsWith(".png") ||
                fileName.endsWith(".bmp") || fileName.endsWith(".gif");
    }
}
