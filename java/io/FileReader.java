package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/FileReader.class */
public class FileReader extends InputStreamReader {
    public FileReader(File file) throws FileNotFoundException {
        super(new FileInputStream(file));
    }

    public FileReader(FileDescriptor fileDescriptor) {
        super(new FileInputStream(fileDescriptor));
    }

    public FileReader(String str) throws FileNotFoundException {
        super(new FileInputStream(str));
    }
}
