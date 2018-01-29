package _5_labs._3_copy_dir;

import java.io.*;

public class CopyDirectory {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        File dst = new File("c:/users/user/desktop/tmp2");
        copy(new File("c:/users/user/desktop/tmp"), dst);
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(elapsedTime);
}

    private static void copy(File src, File dst) throws IOException {
        if (src.isDirectory()) {
            if (!dst.exists()) {
                dst.mkdir();
            }
            for (File srcSubDir : src.listFiles()) {
                String subDirName = srcSubDir.getName();
                copy(srcSubDir, new File(dst, subDirName));
            }
        } else {
            copy(new FileInputStream(src), new FileOutputStream(dst));
        }
    }

    private static void copy(InputStream is, OutputStream os) throws IOException {
        int count;
        byte[] buffer = new byte[1024 * 1024];
        while ((count = is.read(buffer)) != -1) {
            os.write(buffer, 0, count);
        }
    }
}
