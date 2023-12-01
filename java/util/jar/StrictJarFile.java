package java.util.jar;

import dalvik.system.CloseGuard;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.jar.JarFile;
import java.util.jar.JarVerifier;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import libcore.io.IoUtils;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/util/jar/StrictJarFile.class */
public final class StrictJarFile {
    private boolean closed;
    private final CloseGuard guard = CloseGuard.get();
    private final boolean isSigned;
    private final Manifest manifest;
    private final long nativeHandle;
    private final RandomAccessFile raf;
    private final JarVerifier verifier;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/jar/StrictJarFile$EntryIterator.class */
    public static final class EntryIterator implements Iterator<ZipEntry> {
        private final long iterationHandle;
        private ZipEntry nextEntry;

        EntryIterator(long j, String str) throws IOException {
            this.iterationHandle = StrictJarFile.nativeStartIteration(j, str);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextEntry != null) {
                return true;
            }
            ZipEntry nativeNextEntry = StrictJarFile.nativeNextEntry(this.iterationHandle);
            if (nativeNextEntry == null) {
                return false;
            }
            this.nextEntry = nativeNextEntry;
            return true;
        }

        @Override // java.util.Iterator
        public ZipEntry next() {
            if (this.nextEntry != null) {
                ZipEntry zipEntry = this.nextEntry;
                this.nextEntry = null;
                return zipEntry;
            }
            return StrictJarFile.nativeNextEntry(this.iterationHandle);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public StrictJarFile(String str) throws IOException {
        this.nativeHandle = nativeOpenJarFile(str);
        this.raf = new RandomAccessFile(str, "r");
        try {
            HashMap<String, byte[]> metaEntries = getMetaEntries();
            this.manifest = new Manifest(metaEntries.get(JarFile.MANIFEST_NAME), true);
            this.verifier = new JarVerifier(str, this.manifest, metaEntries);
            this.isSigned = this.verifier.readCertificates() && this.verifier.isSignedJar();
            this.guard.open("close");
        } catch (IOException e) {
            nativeClose(this.nativeHandle);
            throw e;
        }
    }

    private HashMap<String, byte[]> getMetaEntries() throws IOException {
        HashMap<String, byte[]> hashMap = new HashMap<>();
        EntryIterator entryIterator = new EntryIterator(this.nativeHandle, "META-INF/");
        while (entryIterator.hasNext()) {
            ZipEntry next = entryIterator.next();
            hashMap.put(next.getName(), Streams.readFully(getInputStream(next)));
        }
        return hashMap;
    }

    private InputStream getZipInputStream(ZipEntry zipEntry) {
        if (zipEntry.getMethod() == 0) {
            return new ZipFile.RAFStream(this.raf, zipEntry.getDataOffset(), zipEntry.getDataOffset() + zipEntry.getSize());
        }
        return new ZipFile.ZipInflaterInputStream(new ZipFile.RAFStream(this.raf, zipEntry.getDataOffset(), zipEntry.getDataOffset() + zipEntry.getCompressedSize()), new Inflater(true), Math.max(1024, (int) Math.min(zipEntry.getSize(), 65535L)), zipEntry);
    }

    private static native void nativeClose(long j);

    private static native ZipEntry nativeFindEntry(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native ZipEntry nativeNextEntry(long j);

    private static native long nativeOpenJarFile(String str) throws IOException;

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeStartIteration(long j, String str);

    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.guard.close();
        nativeClose(this.nativeHandle);
        IoUtils.closeQuietly(this.raf);
        this.closed = true;
    }

    public ZipEntry findEntry(String str) {
        return nativeFindEntry(this.nativeHandle, str);
    }

    public Certificate[][] getCertificateChains(ZipEntry zipEntry) {
        if (this.isSigned) {
            return this.verifier.getCertificateChains(zipEntry.getName());
        }
        return null;
    }

    @Deprecated
    public Certificate[] getCertificates(ZipEntry zipEntry) {
        Certificate[] certificateArr;
        if (this.isSigned) {
            Certificate[][] certificateChains = this.verifier.getCertificateChains(zipEntry.getName());
            int i = 0;
            int length = certificateChains.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                i += certificateChains[i3].length;
                i2 = i3 + 1;
            }
            Certificate[] certificateArr2 = new Certificate[i];
            int i4 = 0;
            int length2 = certificateChains.length;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                certificateArr = certificateArr2;
                if (i6 >= length2) {
                    break;
                }
                Certificate[] certificateArr3 = certificateChains[i6];
                System.arraycopy(certificateArr3, 0, certificateArr2, i4, certificateArr3.length);
                i4 += certificateArr3.length;
                i5 = i6 + 1;
            }
        } else {
            certificateArr = null;
        }
        return certificateArr;
    }

    public InputStream getInputStream(ZipEntry zipEntry) {
        JarVerifier.VerifierEntry initEntry;
        InputStream zipInputStream = getZipInputStream(zipEntry);
        return (!this.isSigned || (initEntry = this.verifier.initEntry(zipEntry.getName())) == null) ? zipInputStream : new JarFile.JarFileInputStream(zipInputStream, zipEntry.getSize(), initEntry);
    }

    public Manifest getManifest() {
        return this.manifest;
    }

    public Iterator<ZipEntry> iterator() throws IOException {
        return new EntryIterator(this.nativeHandle, "");
    }
}
