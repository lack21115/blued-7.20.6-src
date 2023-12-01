package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/FileWriter.class */
public class FileWriter extends OutputStreamWriter {
    public FileWriter(File file) throws IOException {
        super(new FileOutputStream(file));
    }

    public FileWriter(File file, boolean z) throws IOException {
        super(new FileOutputStream(file, z));
    }

    public FileWriter(FileDescriptor fileDescriptor) {
        super(new FileOutputStream(fileDescriptor));
    }

    public FileWriter(String str) throws IOException {
        super(new FileOutputStream(new File(str)));
    }

    public FileWriter(String str, boolean z) throws IOException {
        super(new FileOutputStream(str, z));
    }
}
