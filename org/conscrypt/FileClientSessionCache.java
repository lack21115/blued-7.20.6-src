package org.conscrypt;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import org.conscrypt.io.IoUtils;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/FileClientSessionCache.class */
public final class FileClientSessionCache {
    public static final int MAX_SIZE = 12;
    private static final Logger logger = Logger.getLogger(FileClientSessionCache.class.getName());
    static final Map<File, Impl> caches = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/FileClientSessionCache$CacheFile.class */
    public static class CacheFile extends File {
        long lastModified;
        final String name;

        CacheFile(File file, String str) {
            super(file, str);
            this.lastModified = -1L;
            this.name = str;
        }

        @Override // java.io.File, java.lang.Comparable
        public int compareTo(File file) {
            int i = ((lastModified() - file.lastModified()) > 0L ? 1 : ((lastModified() - file.lastModified()) == 0L ? 0 : -1));
            return i == 0 ? super.compareTo(file) : i < 0 ? -1 : 1;
        }

        @Override // java.io.File
        public long lastModified() {
            long j = this.lastModified;
            long j2 = j;
            if (j == -1) {
                j2 = super.lastModified();
                this.lastModified = j2;
            }
            return j2;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/FileClientSessionCache$Impl.class */
    static class Impl implements SSLClientSessionCache {
        Map<String, File> accessOrder = newAccessOrder();
        final File directory;
        String[] initialFiles;
        int size;

        Impl(File file) throws IOException {
            boolean exists = file.exists();
            if (exists && !file.isDirectory()) {
                throw new IOException(file + " exists but is not a directory.");
            }
            if (exists) {
                String[] list = file.list();
                this.initialFiles = list;
                if (list == null) {
                    throw new IOException(file + " exists but cannot list contents.");
                }
                Arrays.sort(list);
                this.size = this.initialFiles.length;
            } else if (!file.mkdirs()) {
                throw new IOException("Creation of " + file + " directory failed.");
            } else {
                this.size = 0;
            }
            this.directory = file;
        }

        private void delete(File file) {
            if (!file.delete()) {
                IOException iOException = new IOException("FileClientSessionCache: Failed to delete " + file + ".");
                FileClientSessionCache.logger.log(Level.WARNING, iOException.getMessage(), (Throwable) iOException);
            }
            this.size--;
        }

        private static String fileName(String str, int i) {
            if (str != null) {
                return str + "." + i;
            }
            throw new NullPointerException("host == null");
        }

        private void indexFiles() {
            String[] strArr = this.initialFiles;
            if (strArr != null) {
                this.initialFiles = null;
                TreeSet<CacheFile> treeSet = new TreeSet();
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str = strArr[i2];
                    if (!this.accessOrder.containsKey(str)) {
                        treeSet.add(new CacheFile(this.directory, str));
                    }
                    i = i2 + 1;
                }
                if (treeSet.isEmpty()) {
                    return;
                }
                Map<String, File> newAccessOrder = newAccessOrder();
                for (CacheFile cacheFile : treeSet) {
                    newAccessOrder.put(cacheFile.name, cacheFile);
                }
                newAccessOrder.putAll(this.accessOrder);
                this.accessOrder = newAccessOrder;
            }
        }

        static void logReadError(String str, File file, Throwable th) {
            Logger logger = FileClientSessionCache.logger;
            Level level = Level.WARNING;
            logger.log(level, "FileClientSessionCache: Error reading session data for " + str + " from " + file + ".", th);
        }

        static void logWriteError(String str, File file, Throwable th) {
            Logger logger = FileClientSessionCache.logger;
            Level level = Level.WARNING;
            logger.log(level, "FileClientSessionCache: Error writing session data for " + str + " to " + file + ".", th);
        }

        private void makeRoom() {
            int i;
            if (this.size <= 12) {
                return;
            }
            indexFiles();
            int i2 = this.size - 12;
            Iterator<File> it = this.accessOrder.values().iterator();
            do {
                delete(it.next());
                it.remove();
                i = i2 - 1;
                i2 = i;
            } while (i > 0);
        }

        private static Map<String, File> newAccessOrder() {
            return new LinkedHashMap(12, 0.75f, true);
        }

        @Override // org.conscrypt.SSLClientSessionCache
        public byte[] getSessionData(String str, int i) {
            synchronized (this) {
                String fileName = fileName(str, i);
                File file = this.accessOrder.get(fileName);
                File file2 = file;
                if (file == null) {
                    if (this.initialFiles == null) {
                        return null;
                    }
                    if (Arrays.binarySearch(this.initialFiles, fileName) < 0) {
                        return null;
                    }
                    file2 = new File(this.directory, fileName);
                    this.accessOrder.put(fileName, file2);
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    try {
                        byte[] bArr = new byte[(int) file2.length()];
                        new DataInputStream(fileInputStream).readFully(bArr);
                        IoUtils.closeQuietly(fileInputStream);
                        return bArr;
                    } catch (IOException e) {
                        logReadError(str, file2, e);
                        IoUtils.closeQuietly(fileInputStream);
                        return null;
                    }
                } catch (FileNotFoundException e2) {
                    logReadError(str, file2, e2);
                    return null;
                }
            }
        }

        @Override // org.conscrypt.SSLClientSessionCache
        public void putSessionData(SSLSession sSLSession, byte[] bArr) {
            synchronized (this) {
                String peerHost = sSLSession.getPeerHost();
                if (bArr == null) {
                    throw new NullPointerException("sessionData == null");
                }
                String fileName = fileName(peerHost, sSLSession.getPeerPort());
                File file = new File(this.directory, fileName);
                boolean exists = file.exists();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    if (!exists) {
                        this.size++;
                        makeRoom();
                    }
                    try {
                        fileOutputStream.write(bArr);
                    } catch (IOException e) {
                        logWriteError(peerHost, file, e);
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            logWriteError(peerHost, file, e2);
                        }
                    }
                    try {
                        fileOutputStream.close();
                        this.accessOrder.put(fileName, file);
                    } catch (IOException e3) {
                        logWriteError(peerHost, file, e3);
                        delete(file);
                    }
                } catch (FileNotFoundException e4) {
                    logWriteError(peerHost, file, e4);
                }
            }
        }
    }

    private FileClientSessionCache() {
    }

    static void reset() {
        synchronized (FileClientSessionCache.class) {
            try {
                caches.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static SSLClientSessionCache usingDirectory(File file) throws IOException {
        Impl impl;
        synchronized (FileClientSessionCache.class) {
            try {
                Impl impl2 = caches.get(file);
                impl = impl2;
                if (impl2 == null) {
                    impl = new Impl(file);
                    caches.put(file, impl);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return impl;
    }
}
