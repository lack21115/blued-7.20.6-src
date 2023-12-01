package java.util.jar;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: source-2895416-dex2jar.jar:java/util/jar/JarOutputStream.class */
public class JarOutputStream extends ZipOutputStream {
    private Manifest manifest;

    public JarOutputStream(OutputStream outputStream) throws IOException {
        super(outputStream);
    }

    public JarOutputStream(OutputStream outputStream, Manifest manifest) throws IOException {
        super(outputStream);
        if (manifest == null) {
            throw new NullPointerException("manifest == null");
        }
        this.manifest = manifest;
        putNextEntry(new ZipEntry(JarFile.MANIFEST_NAME));
        this.manifest.write(this);
        closeEntry();
    }

    @Override // java.util.zip.ZipOutputStream
    public void putNextEntry(ZipEntry zipEntry) throws IOException {
        super.putNextEntry(zipEntry);
    }
}
