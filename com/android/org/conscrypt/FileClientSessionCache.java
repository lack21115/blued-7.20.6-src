package com.android.org.conscrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import javax.net.ssl.SSLSession;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/FileClientSessionCache.class */
public class FileClientSessionCache {
    public static final int MAX_SIZE = 12;
    static final Map<File, Impl> caches = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/FileClientSessionCache$CacheFile.class */
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
            long lastModified = lastModified() - file.lastModified();
            return lastModified == 0 ? super.compareTo(file) : lastModified < 0 ? -1 : 1;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/FileClientSessionCache$Impl.class */
    public static class Impl implements SSLClientSessionCache {
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
                this.initialFiles = file.list();
                if (this.initialFiles == null) {
                    throw new IOException(file + " exists but cannot list contents.");
                }
                Arrays.sort(this.initialFiles);
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
                new IOException("FileClientSessionCache: Failed to delete " + file + ".").printStackTrace();
            }
            this.size--;
        }

        private static String fileName(String str, int i) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            return str + "." + i;
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
            System.err.println("FileClientSessionCache: Error reading session data for " + str + " from " + file + ".");
            th.printStackTrace();
        }

        static void logWriteError(String str, File file, Throwable th) {
            System.err.println("FileClientSessionCache: Error writing session data for " + str + " to " + file + ".");
            th.printStackTrace();
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

        /* JADX WARN: Can't wrap try/catch for region: R(14:3|4|5|(4:7|(1:9)(2:15|(2:17|18)(1:19))|10|11)|20|21|22|23|24|25|26|(3:28|29|30)|10|11) */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0098, code lost:
            r9 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x009a, code lost:
            logReadError(r6, r8, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a2, code lost:
            r6 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a6, code lost:
            r9 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00a8, code lost:
            logReadError(r6, r8, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
            if (r0 != null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00b4, code lost:
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
            r6 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00be, code lost:
            r6 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00c0, code lost:
            throw r6;
         */
        @Override // com.android.org.conscrypt.SSLClientSessionCache
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public byte[] getSessionData(java.lang.String r6, int r7) {
            /*
                Method dump skipped, instructions count: 224
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.org.conscrypt.FileClientSessionCache.Impl.getSessionData(java.lang.String, int):byte[]");
        }

        @Override // com.android.org.conscrypt.SSLClientSessionCache
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
                        try {
                            fileOutputStream.close();
                            if (1 == 0 || 1 == 0) {
                                delete(file);
                            } else {
                                this.accessOrder.put(fileName, file);
                            }
                        } catch (IOException e) {
                            logWriteError(peerHost, file, e);
                            if (1 == 0 || 0 == 0) {
                                delete(file);
                            } else {
                                this.accessOrder.put(fileName, file);
                            }
                        }
                    } catch (IOException e2) {
                        logWriteError(peerHost, file, e2);
                        try {
                            fileOutputStream.close();
                            if (0 == 0 || 1 == 0) {
                                delete(file);
                            } else {
                                this.accessOrder.put(fileName, file);
                            }
                        } catch (IOException e3) {
                            logWriteError(peerHost, file, e3);
                            if (0 == 0 || 0 == 0) {
                                delete(file);
                            } else {
                                this.accessOrder.put(fileName, file);
                            }
                        }
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
