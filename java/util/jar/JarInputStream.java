package java.util.jar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.jar.JarVerifier;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/util/jar/JarInputStream.class */
public class JarInputStream extends ZipInputStream {
    private JarEntry currentJarEntry;
    private boolean isMeta;
    private Manifest manifest;
    private JarEntry pendingJarEntry;
    private OutputStream verStream;
    private boolean verified;
    private JarVerifier verifier;

    public JarInputStream(InputStream inputStream) throws IOException {
        this(inputStream, true);
    }

    public JarInputStream(InputStream inputStream, boolean z) throws IOException {
        super(inputStream);
        this.verified = false;
        this.verifier = null;
        this.pendingJarEntry = null;
        this.currentJarEntry = null;
        if (getNextJarEntry() == null) {
            return;
        }
        if (this.currentJarEntry.getName().equalsIgnoreCase("META-INF/")) {
            closeEntry();
            getNextJarEntry();
        }
        if (this.currentJarEntry.getName().equalsIgnoreCase(JarFile.MANIFEST_NAME)) {
            byte[] readFullyNoClose = Streams.readFullyNoClose(this);
            this.manifest = new Manifest(readFullyNoClose, z);
            closeEntry();
            if (z) {
                HashMap hashMap = new HashMap();
                hashMap.put(JarFile.MANIFEST_NAME, readFullyNoClose);
                this.verifier = new JarVerifier("JarInputStream", this.manifest, hashMap);
            }
        }
        this.pendingJarEntry = this.currentJarEntry;
        this.currentJarEntry = null;
    }

    @Override // java.util.zip.ZipInputStream
    public void closeEntry() throws IOException {
        if (this.pendingJarEntry != null) {
            return;
        }
        super.closeEntry();
        this.currentJarEntry = null;
    }

    @Override // java.util.zip.ZipInputStream
    protected ZipEntry createZipEntry(String str) {
        JarEntry jarEntry = new JarEntry(str);
        if (this.manifest != null) {
            jarEntry.setAttributes(this.manifest.getAttributes(str));
        }
        return jarEntry;
    }

    public Manifest getManifest() {
        return this.manifest;
    }

    @Override // java.util.zip.ZipInputStream
    public ZipEntry getNextEntry() throws IOException {
        if (this.pendingJarEntry != null) {
            JarEntry jarEntry = this.pendingJarEntry;
            this.pendingJarEntry = null;
            this.currentJarEntry = jarEntry;
            return jarEntry;
        }
        this.currentJarEntry = (JarEntry) super.getNextEntry();
        if (this.currentJarEntry == null) {
            return null;
        }
        if (this.verifier != null) {
            this.isMeta = this.currentJarEntry.getName().toUpperCase(Locale.US).startsWith("META-INF/");
            if (this.isMeta) {
                int size = (int) this.currentJarEntry.getSize();
                if (size <= 0) {
                    size = 8192;
                }
                this.verStream = new ByteArrayOutputStream(size);
            } else {
                this.verStream = this.verifier.initEntry(this.currentJarEntry.getName());
            }
        }
        this.verified = false;
        return this.currentJarEntry;
    }

    public JarEntry getNextJarEntry() throws IOException {
        return (JarEntry) getNextEntry();
    }

    @Override // java.util.zip.ZipInputStream, java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.currentJarEntry == null) {
            i3 = -1;
        } else {
            int read = super.read(bArr, i, i2);
            i3 = read;
            if (this.verifier != null) {
                i3 = read;
                if (this.verStream != null) {
                    i3 = read;
                    if (!this.verified) {
                        if (read != -1) {
                            this.verStream.write(bArr, i, read);
                            return read;
                        }
                        this.verified = true;
                        if (!this.isMeta) {
                            ((JarVerifier.VerifierEntry) this.verStream).verify();
                            return read;
                        }
                        this.verifier.addMetaEntry(this.currentJarEntry.getName(), ((ByteArrayOutputStream) this.verStream).toByteArray());
                        try {
                            this.verifier.readCertificates();
                            return read;
                        } catch (SecurityException e) {
                            this.verifier = null;
                            throw e;
                        }
                    }
                }
            }
        }
        return i3;
    }
}
