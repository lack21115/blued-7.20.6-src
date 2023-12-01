package com.igexin.push.core.d;

import android.text.TextUtils;
import com.getui.gtc.base.util.io.IOUtils;
import com.igexin.push.core.ServiceManager;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/d/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23484a = "grp.prop";
    public static final String b = "c";

    /* renamed from: c  reason: collision with root package name */
    public static final String f23485c = "i";
    public static final String d = "p";
    public static final String e = "s";
    public static final String f = "t145gt";
    public static final String g = "t145main";
    private static final String h = "RpConfig";
    private static final d i = new d();
    private long k;
    private final Map<String, String> l = new HashMap();
    private final String j = ServiceManager.b.getFilesDir().getAbsolutePath() + "/grp.prop";

    /* renamed from: com.igexin.push.core.d.d$3  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/d/d$3.class */
    public final class AnonymousClass3 extends com.igexin.push.core.g.a<RandomAccessFile> {
        public AnonymousClass3() {
        }

        private void a() {
            d.this.b();
        }

        @Override // com.igexin.push.core.g.a
        public final /* bridge */ /* synthetic */ void a(RandomAccessFile randomAccessFile) {
            d.this.b();
        }
    }

    /* renamed from: com.igexin.push.core.d.d$4  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/d/d$4.class */
    public final class AnonymousClass4 extends com.igexin.push.core.g.a<RandomAccessFile> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23490a;

        public AnonymousClass4(String str) {
            this.f23490a = str;
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        private void a2(RandomAccessFile randomAccessFile) {
            if (d.this.b()) {
                d.this.a(randomAccessFile);
            }
            d.this.l.remove(this.f23490a);
            try {
                randomAccessFile.setLength(0L);
                for (Map.Entry entry : d.this.l.entrySet()) {
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
            if (d.this.b()) {
                d.this.a(randomAccessFile2);
            }
            d.this.l.remove(this.f23490a);
            try {
                randomAccessFile2.setLength(0L);
                for (Map.Entry entry : d.this.l.entrySet()) {
                    randomAccessFile2.writeBytes(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
                    randomAccessFile2.writeBytes("\n");
                }
            } catch (IOException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    private d() {
        try {
            File file = new File(this.j);
            if (file.exists()) {
                return;
            }
            file.createNewFile();
        } catch (IOException e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private int a(String str, int... iArr) {
        try {
            return Integer.parseInt(a(str));
        } catch (NumberFormatException e2) {
            com.igexin.c.a.c.a.a(e2);
            if (iArr == null || iArr.length != 1) {
                return -1;
            }
            return iArr[0];
        }
    }

    public static d a() {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RandomAccessFile randomAccessFile) {
        try {
            this.l.clear();
            while (true) {
                String readLine = randomAccessFile.readLine();
                if (readLine == null) {
                    return true;
                }
                int indexOf = readLine.indexOf("=");
                if (indexOf >= 0) {
                    int i2 = indexOf + 1;
                    if (i2 != readLine.length()) {
                        this.l.put(readLine.substring(0, indexOf), readLine.substring(i2));
                    }
                }
            }
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        long lastModified = new File(this.j).lastModified();
        boolean z = this.k != lastModified;
        this.k = lastModified;
        return z;
    }

    private void d(String str) {
        a(new AnonymousClass4(str).a((com.igexin.push.core.g.a) new AnonymousClass3()));
    }

    public final String a(String str) {
        if (b()) {
            a(new com.igexin.push.core.g.a<RandomAccessFile>() { // from class: com.igexin.push.core.d.d.5
                /* renamed from: a  reason: avoid collision after fix types in other method */
                private void a2(RandomAccessFile randomAccessFile) {
                    d.this.a(randomAccessFile);
                }

                @Override // com.igexin.push.core.g.a
                public final /* bridge */ /* synthetic */ void a(RandomAccessFile randomAccessFile) {
                    d.this.a(randomAccessFile);
                }
            });
        }
        return this.l.get(str);
    }

    public final ArrayList<String> a(String str, ArrayList<String> arrayList) {
        String a2 = a(str);
        try {
            if (TextUtils.isEmpty(a2)) {
                return arrayList;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            JSONArray jSONArray = new JSONArray(a2);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= jSONArray.length()) {
                    return arrayList2;
                }
                String optString = jSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList2.add(optString);
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return arrayList;
        }
    }

    public final void a(com.igexin.push.core.g.a<RandomAccessFile> aVar) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        FileLock fileLock = null;
        Closeable closeable = null;
        FileLock fileLock2 = null;
        try {
            try {
                randomAccessFile2 = new RandomAccessFile(new File(this.j), "rw");
                fileLock = null;
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                closeable = null;
                if (0 != 0) {
                    try {
                        fileLock2.release();
                    } catch (IOException e3) {
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
                    } catch (IOException e4) {
                    }
                }
                IOUtils.safeClose(randomAccessFile2);
            } catch (Exception e5) {
                randomAccessFile = randomAccessFile2;
                e = e5;
                com.igexin.c.a.c.a.a(e);
                FileLock fileLock3 = fileLock;
                StringBuilder sb = new StringBuilder("RpConfig| getProcessLock err：");
                FileLock fileLock4 = fileLock;
                sb.append(e.toString());
                FileLock fileLock5 = fileLock;
                com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e6) {
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

    public final void a(final String str, final Object obj) {
        a(new com.igexin.push.core.g.a<RandomAccessFile>() { // from class: com.igexin.push.core.d.d.2
            /* renamed from: a  reason: avoid collision after fix types in other method */
            private void a2(RandomAccessFile randomAccessFile) {
                String jSONArray;
                if (d.this.b()) {
                    d.this.a(randomAccessFile);
                }
                Object obj2 = obj;
                if (obj2 instanceof List) {
                    try {
                        jSONArray = new JSONArray((Collection) ((ArrayList) obj)).toString();
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                        return;
                    }
                } else {
                    jSONArray = String.valueOf(obj2);
                }
                d.this.l.put(str, jSONArray);
                try {
                    randomAccessFile.setLength(0L);
                    for (Map.Entry entry : d.this.l.entrySet()) {
                        randomAccessFile.writeBytes(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
                        randomAccessFile.writeBytes("\n");
                    }
                } catch (IOException e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
            }

            @Override // com.igexin.push.core.g.a
            public final /* synthetic */ void a(RandomAccessFile randomAccessFile) {
                String jSONArray;
                RandomAccessFile randomAccessFile2 = randomAccessFile;
                if (d.this.b()) {
                    d.this.a(randomAccessFile2);
                }
                Object obj2 = obj;
                if (obj2 instanceof List) {
                    try {
                        jSONArray = new JSONArray((Collection) ((ArrayList) obj)).toString();
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                        return;
                    }
                } else {
                    jSONArray = String.valueOf(obj2);
                }
                d.this.l.put(str, jSONArray);
                try {
                    randomAccessFile2.setLength(0L);
                    for (Map.Entry entry : d.this.l.entrySet()) {
                        randomAccessFile2.writeBytes(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
                        randomAccessFile2.writeBytes("\n");
                    }
                } catch (IOException e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
            }
        }.a(new com.igexin.push.core.g.a<RandomAccessFile>() { // from class: com.igexin.push.core.d.d.1
            private void a() {
                d.this.b();
            }

            @Override // com.igexin.push.core.g.a
            public final /* bridge */ /* synthetic */ void a(RandomAccessFile randomAccessFile) {
                d.this.b();
            }
        }));
    }

    public final boolean b(String str) {
        return Boolean.parseBoolean(a(str));
    }

    public final long c(String str) {
        try {
            return Long.parseLong(a(str));
        } catch (NumberFormatException e2) {
            com.igexin.c.a.c.a.a(e2);
            return 0L;
        }
    }
}
