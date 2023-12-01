package java.util.jar;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.jar.JarVerifier;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/util/jar/JarFile.class */
public class JarFile extends ZipFile {
    public static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    static final String META_DIR = "META-INF/";
    private boolean closed;
    private Manifest manifest;
    private byte[] manifestBytes;
    JarVerifier verifier;

    /* loaded from: source-2895416-dex2jar.jar:java/util/jar/JarFile$JarFileEnumerator.class */
    static final class JarFileEnumerator implements Enumeration<JarEntry> {
        final JarFile jf;
        final Enumeration<? extends ZipEntry> ze;

        JarFileEnumerator(Enumeration<? extends ZipEntry> enumeration, JarFile jarFile) {
            this.ze = enumeration;
            this.jf = jarFile;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.ze.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public JarEntry nextElement() {
            return new JarEntry(this.ze.nextElement(), this.jf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/jar/JarFile$JarFileInputStream.class */
    public static final class JarFileInputStream extends FilterInputStream {
        private long count;
        private boolean done;
        private final JarVerifier.VerifierEntry entry;

        /* JADX INFO: Access modifiers changed from: package-private */
        public JarFileInputStream(InputStream inputStream, long j, JarVerifier.VerifierEntry verifierEntry) {
            super(inputStream);
            this.done = false;
            this.entry = verifierEntry;
            this.count = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            if (this.done) {
                return 0;
            }
            return super.available();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i;
            if (this.done) {
                i = -1;
            } else if (this.count <= 0) {
                this.done = true;
                this.entry.verify();
                return -1;
            } else {
                int read = super.read();
                if (read != -1) {
                    this.entry.write(read);
                    this.count--;
                } else {
                    this.count = 0L;
                }
                i = read;
                if (this.count == 0) {
                    this.done = true;
                    this.entry.verify();
                    return read;
                }
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (this.done) {
                i3 = -1;
            } else if (this.count <= 0) {
                this.done = true;
                this.entry.verify();
                return -1;
            } else {
                int read = super.read(bArr, i, i2);
                if (read != -1) {
                    int i4 = read;
                    if (this.count < read) {
                        i4 = (int) this.count;
                    }
                    this.entry.write(bArr, i, i4);
                    this.count -= i4;
                } else {
                    this.count = 0L;
                }
                i3 = read;
                if (this.count == 0) {
                    this.done = true;
                    this.entry.verify();
                    return read;
                }
            }
            return i3;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            return Streams.skipByReading(this, j);
        }
    }

    public JarFile(File file) throws IOException {
        this(file, true);
    }

    public JarFile(File file, boolean z) throws IOException {
        this(file, z, 1);
    }

    public JarFile(File file, boolean z, int i) throws IOException {
        super(file, i);
        this.closed = false;
        HashMap<String, byte[]> readMetaEntries = readMetaEntries(this, z);
        if (z && readMetaEntries.containsKey(MANIFEST_NAME) && readMetaEntries.size() > 1) {
            this.manifest = new Manifest(readMetaEntries.get(MANIFEST_NAME), true);
            this.verifier = new JarVerifier(getName(), this.manifest, readMetaEntries);
            return;
        }
        this.verifier = null;
        this.manifestBytes = readMetaEntries.get(MANIFEST_NAME);
    }

    public JarFile(String str) throws IOException {
        this(str, true);
    }

    public JarFile(String str, boolean z) throws IOException {
        this(new File(str), z, 1);
    }

    private static boolean endsWithIgnoreCase(String str, String str2) {
        return str.regionMatches(true, str.length() - str2.length(), str2, 0, str2.length());
    }

    private static List<ZipEntry> getMetaEntries(ZipFile zipFile) {
        ArrayList arrayList = new ArrayList(8);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (nextElement.getName().startsWith(META_DIR) && nextElement.getName().length() > META_DIR.length()) {
                arrayList.add(nextElement);
            }
        }
        return arrayList;
    }

    static HashMap<String, byte[]> readMetaEntries(ZipFile zipFile, boolean z) throws IOException {
        List<ZipEntry> metaEntries = getMetaEntries(zipFile);
        HashMap<String, byte[]> hashMap = new HashMap<>();
        for (ZipEntry zipEntry : metaEntries) {
            String name = zipEntry.getName();
            if (name.equalsIgnoreCase(MANIFEST_NAME) && !hashMap.containsKey(MANIFEST_NAME)) {
                hashMap.put(MANIFEST_NAME, Streams.readFully(zipFile.getInputStream(zipEntry)));
                if (!z) {
                    break;
                }
            } else if (z && (endsWithIgnoreCase(name, ".SF") || endsWithIgnoreCase(name, ".DSA") || endsWithIgnoreCase(name, ".RSA") || endsWithIgnoreCase(name, ".EC"))) {
                hashMap.put(name.toUpperCase(Locale.US), Streams.readFully(zipFile.getInputStream(zipEntry)));
            }
        }
        return hashMap;
    }

    @Override // java.util.zip.ZipFile, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.closed = true;
    }

    @Override // java.util.zip.ZipFile
    public Enumeration<JarEntry> entries() {
        return new JarFileEnumerator(super.entries(), this);
    }

    @Override // java.util.zip.ZipFile
    public ZipEntry getEntry(String str) {
        ZipEntry entry = super.getEntry(str);
        return entry == null ? entry : new JarEntry(entry, this);
    }

    @Override // java.util.zip.ZipFile
    public InputStream getInputStream(ZipEntry zipEntry) throws IOException {
        InputStream inputStream;
        if (this.manifestBytes != null) {
            getManifest();
        }
        if (this.verifier != null && this.verifier.readCertificates()) {
            this.verifier.removeMetaEntries();
            this.manifest.removeChunks();
            if (!this.verifier.isSignedJar()) {
                this.verifier = null;
            }
        }
        InputStream inputStream2 = super.getInputStream(zipEntry);
        if (inputStream2 == null) {
            inputStream = null;
        } else {
            inputStream = inputStream2;
            if (this.verifier != null) {
                inputStream = inputStream2;
                if (zipEntry.getSize() != -1) {
                    JarVerifier.VerifierEntry initEntry = this.verifier.initEntry(zipEntry.getName());
                    inputStream = inputStream2;
                    if (initEntry != null) {
                        return new JarFileInputStream(inputStream2, zipEntry.getSize(), initEntry);
                    }
                }
            }
        }
        return inputStream;
    }

    public JarEntry getJarEntry(String str) {
        return (JarEntry) getEntry(str);
    }

    public Manifest getManifest() throws IOException {
        Manifest manifest = null;
        if (this.closed) {
            throw new IllegalStateException("JarFile has been closed");
        }
        if (this.manifest != null) {
            manifest = this.manifest;
        } else if (this.manifestBytes != null) {
            this.manifest = new Manifest(this.manifestBytes, false);
            this.manifestBytes = null;
            return this.manifest;
        }
        return manifest;
    }
}
