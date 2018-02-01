package _5_labs._2_stream._5_download_from_internet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadFromInternet {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com");
        InputStream in = url.openStream();
        int b;
        while ((b = in.read()) != -1) {
            System.out.println((char) b);
        }
        in.close();
    }
}
