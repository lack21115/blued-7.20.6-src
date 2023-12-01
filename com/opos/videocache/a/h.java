package com.opos.videocache.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/a/h.class */
class h {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/a/h$a.class */
    static final class a implements Comparator<File> {
        private a() {
        }

        private int a(long j, long j2) {
            int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            if (i < 0) {
                return -1;
            }
            return i == 0 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return a(file.lastModified(), file2.lastModified());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file) {
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
    public static List<File> b(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        LinkedList linkedList2 = linkedList;
        if (listFiles != null) {
            linkedList2 = Arrays.asList(listFiles);
            Collections.sort(linkedList2, new a());
        }
        return linkedList2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            d(file);
            if (file.lastModified() < currentTimeMillis) {
                com.opos.cmn.an.f.a.a("Files", "Last modified date {} is not set for file {}" + new Date(file.lastModified()) + file.getAbsolutePath());
            }
        }
    }

    static void d(File file) {
        long length = file.length();
        if (length == 0) {
            e(file);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
                long j = length - 1;
                try {
                    randomAccessFile2.seek(j);
                    byte readByte = randomAccessFile2.readByte();
                    randomAccessFile2.seek(j);
                    randomAccessFile2.write(readByte);
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e) {
                        throw e;
                    } catch (Exception e2) {
                    }
                } catch (IOException e3) {
                    e = e3;
                    throw e;
                } catch (Throwable th) {
                    randomAccessFile = randomAccessFile2;
                    th = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                            throw e4;
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void e(File file) {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }
}
