package hello.Services;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class PackageService {


    public byte[] GeneratePackage() throws IOException {
        File temp = createTempDirectory();
        createTextFile("test","com.anton", "image128.png", null, temp);
        return new byte[0];
    }

    private static void createTextFile(String name, String packageName, String image128, String image512, File pathToFolder) throws FileNotFoundException, UnsupportedEncodingException {
        String pathToFile = pathToFolder + File.separator + "the-file-name.txt";
        System.out.println(pathToFile);
        PrintWriter writer = new PrintWriter(pathToFile, "UTF-8");
        writer.println(String.format("Name: %s", name));
        writer.println(String.format("Package: %s", packageName));
        if (image128 != null && !image128.isEmpty()) {
            writer.println(String.format("picture_128: %s", image128));
        }
        if (image512 != null && !image512.isEmpty()) {
            writer.println(String.format("picture_512: %s", image512));
        }

        writer.close();
    }

    private static File createTempDirectory() throws IOException {
        File temp = File.createTempFile("temp", Long.toString(System.nanoTime()));
        if (!(temp.delete())) {
            throw new IOException("Could not delete temp file: " + temp.getAbsolutePath());
        }

        if (!(temp.mkdir())) {
            throw new IOException("Could not create temp directory: " + temp.getAbsolutePath());
        }

        return temp;
    }
}
