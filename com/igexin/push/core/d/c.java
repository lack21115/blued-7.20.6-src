package com.igexin.push.core.d;

import android.text.TextUtils;
import com.getui.gtc.base.util.io.IOUtils;
import com.igexin.push.f.j;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/d/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23478a = "guard.me";
    public static final String b = "guard.others";

    /* renamed from: c  reason: collision with root package name */
    private static final String f23479c = "GuardConfig";
    private static final c d = new c();
    private long e;
    private final Map<String, String> f = new HashMap();

    private c() {
        try {
            if (TextUtils.isEmpty(j.g)) {
                j.a();
            }
            File file = new File(j.g);
            if (file.exists()) {
                return;
            }
            file.createNewFile();
        } catch (IOException e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private int a(String str, int... iArr) {
        try {
            return Integer.parseInt(b(str));
        } catch (NumberFormatException e) {
            com.igexin.c.a.c.a.a(e);
            if (iArr == null || iArr.length != 1) {
                return -1;
            }
            return iArr[0];
        }
    }

    private long a(String str, long... jArr) {
        try {
            return Long.parseLong(b(str));
        } catch (NumberFormatException e) {
            com.igexin.c.a.c.a.a(e);
            if (jArr == null || jArr.length != 1) {
                return 0L;
            }
            return jArr[0];
        }
    }

    public static c a() {
        return d;
    }

    private static void a(com.igexin.push.core.g.a<RandomAccessFile> aVar) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        FileLock fileLock = null;
        Closeable closeable = null;
        FileLock fileLock2 = null;
        try {
            try {
                randomAccessFile2 = new RandomAccessFile(new File(j.g), "rw");
                fileLock = null;
            } catch (Exception e) {
                e = e;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                closeable = null;
                if (0 != 0) {
                    try {
                        fileLock2.release();
                    } catch (IOException e2) {
                    }
                }
                IOUtils.safeClose(closeable);
                throw th;
            }
            try {
                FileLock lock = randomAccessFile2.getChannel().lock();
                if (lock.isValid()) {
                    fileLock = lock;
                    aVar.a((com.igexin.push.core.g.a<RandomAccessFile>) randomAccessFile2);
                }
                if (lock != null && lock.isValid()) {
                    try {
                        lock.release();
                    } catch (IOException e3) {
                    }
                }
                IOUtils.safeClose(randomAccessFile2);
            } catch (Exception e4) {
                randomAccessFile = randomAccessFile2;
                e = e4;
                com.igexin.c.a.c.a.a(e);
                FileLock fileLock3 = fileLock;
                StringBuilder sb = new StringBuilder("GuardConfig| getProcessLock err：");
                FileLock fileLock4 = fileLock;
                sb.append(e.toString());
                FileLock fileLock5 = fileLock;
                com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e5) {
                    }
                }
                IOUtils.safeClose(randomAccessFile);
            }
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0 && fileLock2.isValid()) {
                fileLock2.release();
            }
            IOUtils.safeClose(closeable);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RandomAccessFile randomAccessFile) {
        try {
            this.f.clear();
            while (true) {
                String readLine = randomAccessFile.readLine();
                if (readLine == null) {
                    return true;
                }
                int indexOf = readLine.indexOf("=");
                if (indexOf >= 0) {
                    int i = indexOf + 1;
                    if (i != readLine.length()) {
                        this.f.put(readLine.substring(0, indexOf), readLine.substring(i));
                    }
                }
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }

    private String b(String str) {
        if (b()) {
            a(new com.igexin.push.core.g.a<RandomAccessFile>() { // from class: com.igexin.push.core.d.c.3
                /* renamed from: a  reason: avoid collision after fix types in other method */
                private void a2(RandomAccessFile randomAccessFile) {
                    c.this.a(randomAccessFile);
                }

                @Override // com.igexin.push.core.g.a
                public final /* bridge */ /* synthetic */ void a(RandomAccessFile randomAccessFile) {
                    c.this.a(randomAccessFile);
                }
            });
        }
        return this.f.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        long lastModified = new File(j.g).lastModified();
        boolean z = this.e != lastModified;
        this.e = lastModified;
        return z;
    }

    private static Boolean c(String str) {
        if (str == null) {
            return null;
        }
        if (str.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (str.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final Boolean a(String str) {
        String b2 = b(str);
        if (b2 == null) {
            return null;
        }
        return c(b2);
    }

    public final void a(final String str, final Object obj) {
        a(new com.igexin.push.core.g.a<RandomAccessFile>() { // from class: com.igexin.push.core.d.c.2
            /* renamed from: a  reason: avoid collision after fix types in other method */
            private void a2(RandomAccessFile randomAccessFile) {
                if (c.this.b()) {
                    c.this.a(randomAccessFile);
                }
                c.this.f.put(str, String.valueOf(obj));
                try {
                    randomAccessFile.setLength(0L);
                    for (Map.Entry entry : c.this.f.entrySet()) {
                        randomAccessFile.writeBytes(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
                        randomAccessFile.writeBytes("\n");
                    }
                } catch (IOException e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }

            @Override // com.igexin.push.core.g.a
            public final /* synthetic */ void a(RandomAccessFile randomAccessFile) {
                RandomAccessFile randomAccessFile2 = randomAccessFile;
                if (c.this.b()) {
                    c.this.a(randomAccessFile2);
                }
                c.this.f.put(str, String.valueOf(obj));
                try {
                    randomAccessFile2.setLength(0L);
                    for (Map.Entry entry : c.this.f.entrySet()) {
                        randomAccessFile2.writeBytes(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
                        randomAccessFile2.writeBytes("\n");
                    }
                } catch (IOException e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }
        }.a(new com.igexin.push.core.g.a<RandomAccessFile>() { // from class: com.igexin.push.core.d.c.1
            private void a() {
                c.this.b();
            }

            @Override // com.igexin.push.core.g.a
            public final /* bridge */ /* synthetic */ void a(RandomAccessFile randomAccessFile) {
                c.this.b();
            }
        }));
    }
}
