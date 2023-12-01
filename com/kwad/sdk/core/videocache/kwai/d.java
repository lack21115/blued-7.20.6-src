package com.kwad.sdk.core.videocache.kwai;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/kwai/d.class */
final class d {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/kwai/d$a.class */
    static final class a implements Comparator<File> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return compareLong(file.lastModified(), file2.lastModified());
        }

        private static int compareLong(long j, long j2) {
            int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            if (i < 0) {
                return -1;
            }
            return i == 0 ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void p(File file) {
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
            }
        } else if (file.isDirectory()) {
        } else {
            throw new IOException("File " + file + " is not directory!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List] */
    public static List<File> q(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        LinkedList linkedList2 = linkedList;
        if (listFiles != null) {
            linkedList2 = Arrays.asList(listFiles);
            Collections.sort(linkedList2, new a((byte) 0));
        }
        return linkedList2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void r(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            s(file);
            if (file.lastModified() < currentTimeMillis) {
                com.kwad.sdk.core.d.b.w("Files", String.format("Last modified date %s is not set for file %s", new Date(file.lastModified()), file.getAbsolutePath()));
            }
        }
    }

    private static void s(File file) {
        RandomAccessFile randomAccessFile;
        long length = file.length();
        if (length == 0) {
            t(file);
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rwd");
                long j = length - 1;
                try {
                    randomAccessFile.seek(j);
                    byte readByte = randomAccessFile.readByte();
                    randomAccessFile.seek(j);
                    randomAccessFile.write(readByte);
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                } catch (IOException e) {
                    e = e;
                    randomAccessFile2 = randomAccessFile;
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                } catch (Throwable th) {
                    randomAccessFile2 = randomAccessFile;
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
            randomAccessFile = null;
        }
    }

    private static void t(File file) {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }
}
