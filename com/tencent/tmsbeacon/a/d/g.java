package com.tencent.tmsbeacon.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tmsbeacon.a.c.f;
import com.tencent.tmsbeacon.base.util.e;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/d/g.class */
public class g {
    private FileChannel b;
    private MappedByteBuffer d;
    private long e;
    private Runnable f;
    private boolean g;
    private boolean h;

    /* renamed from: a  reason: collision with root package name */
    private final Object f25795a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f25796c = new JSONObject();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/d/g$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (g.this.f25795a) {
                    byte[] a2 = g.a(g.this.f25796c.toString().getBytes("ISO8859-1"));
                    if (a2 == null) {
                        return;
                    }
                    if (a2.length + 10 > g.this.e) {
                        g.this.e = a2.length + 10;
                        g gVar = g.this;
                        gVar.a(gVar.e);
                    }
                    g.this.d.putInt(0, a2.length);
                    g.this.d.position(10);
                    g.this.d.put(a2);
                    g.this.d.force();
                }
            } catch (Exception e) {
                com.tencent.tmsbeacon.a.b.d.b().a("504", "[properties] write to file error!", e);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/d/g$b.class */
    public class b implements Runnable {
        public final /* synthetic */ Runnable b;

        public b(Runnable runnable) {
            this.b = runnable;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
            if (r7 == null) goto L14;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r6 = this;
                r0 = r6
                com.tencent.tmsbeacon.a.d.g r0 = com.tencent.tmsbeacon.a.d.g.this
                r10 = r0
                r0 = r10
                monitor-enter(r0)
                r0 = 0
                r7 = r0
                r0 = 0
                r8 = r0
                r0 = r6
                com.tencent.tmsbeacon.a.d.g r0 = com.tencent.tmsbeacon.a.d.g.this     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L32
                java.nio.channels.FileChannel r0 = com.tencent.tmsbeacon.a.d.g.e(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L32
                java.nio.channels.FileLock r0 = r0.lock()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L32
                r9 = r0
                r0 = r9
                r8 = r0
                r0 = r9
                r7 = r0
                r0 = r6
                java.lang.Runnable r0 = r0.b     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L32
                r0.run()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L32
                r0 = r9
                if (r0 == 0) goto L82
                r0 = r9
                r7 = r0
                goto L7e
            L2e:
                r7 = move-exception
                goto L86
            L32:
                r9 = move-exception
                r0 = r7
                r8 = r0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
                r1 = r0
                r1.<init>()     // Catch: java.lang.Throwable -> L2e
                r11 = r0
                r0 = r7
                r8 = r0
                r0 = r11
                java.lang.String r1 = "file get lock error:"
                java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L2e
                r0 = r7
                r8 = r0
                r0 = r11
                r1 = r9
                java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L2e
                java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L2e
                r0 = r7
                r8 = r0
                java.lang.String r0 = "[properties]"
                r1 = 1
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L2e
                r2 = r1
                r3 = 0
                r4 = r11
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L2e
                r2[r3] = r4     // Catch: java.lang.Throwable -> L2e
                com.tencent.tmsbeacon.base.util.c.b(r0, r1)     // Catch: java.lang.Throwable -> L2e
                r0 = r7
                r8 = r0
                com.tencent.tmsbeacon.a.b.d r0 = com.tencent.tmsbeacon.a.b.d.b()     // Catch: java.lang.Throwable -> L2e
                r11 = r0
                r0 = r7
                r8 = r0
                r0 = r11
                java.lang.String r1 = "504"
                java.lang.String r2 = "[properties] File get lock error!"
                r3 = r9
                r0.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L2e
                r0 = r7
                if (r0 == 0) goto L82
            L7e:
                r0 = r7
                r0.release()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L96
            L82:
                r0 = r10
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L90
                return
            L86:
                r0 = r8
                if (r0 == 0) goto L8e
                r0 = r8
                r0.release()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L9a
            L8e:
                r0 = r7
                throw r0     // Catch: java.lang.Throwable -> L90
            L90:
                r7 = move-exception
                r0 = r10
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L90
                r0 = r7
                throw r0
            L96:
                r7 = move-exception
                goto L82
            L9a:
                r8 = move-exception
                goto L8e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmsbeacon.a.d.g.b.run():void");
        }
    }

    private g(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.b = randomAccessFile.getChannel();
        this.e = randomAccessFile.length();
        com.tencent.tmsbeacon.base.util.c.a("[properties]", "file size: " + this.e, new Object[0]);
        f();
    }

    public static g a(Context context, String str) throws IOException {
        File file = new File(context.getFilesDir(), "beacon");
        if (!(!file.exists() ? file.mkdirs() : true)) {
            e.a("mkdir " + file.getName() + " exception!");
        }
        return new g(new File(file, str + "tmsbeacon_V1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) throws IOException {
        if (j > 2097152) {
            throw new IllegalArgumentException("file size to reach maximum!");
        }
        this.d.rewind();
        this.d = this.b.map(FileChannel.MapMode.READ_WRITE, 0L, j);
    }

    private void a(Runnable runnable) {
        com.tencent.tmsbeacon.a.b.a.a().a(new b(runnable));
    }

    private byte[] a(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt(0);
        if (i <= 1 || i > 2097152 || byteBuffer.capacity() <= 10) {
            return null;
        }
        byteBuffer.position(10);
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr, 0, i);
        return bArr;
    }

    public static byte[] a(byte[] bArr) throws Exception {
        return com.tencent.tmsbeacon.base.net.b.c.b(3, "BEACONDEFAULTAES", bArr);
    }

    private static byte[] a(byte[] bArr, String str) {
        try {
            return com.tencent.tmsbeacon.base.net.b.c.a(3, str, bArr);
        } catch (Throwable th) {
            com.tencent.tmsbeacon.base.util.c.a(th);
            com.tencent.tmsbeacon.a.b.d b2 = com.tencent.tmsbeacon.a.b.d.b();
            b2.a("513", "unEncrypt error: key=" + str, th);
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        byte[] a2 = a(bArr, "BEACONDEFAULTAES");
        if (a2 != null) {
            return a2;
        }
        com.tencent.tmsbeacon.a.b.d.b().a("517", "default aesKey unEncryption failed");
        byte[] a3 = a(bArr, f.e().a());
        return a3 != null ? a3 : a(bArr, "");
    }

    private Object c(String str) {
        Object obj;
        Object obj2 = null;
        try {
            synchronized (this.f25795a) {
                obj = this.f25796c.get(str);
                obj2 = obj;
            }
            return obj;
        } catch (Exception e) {
            com.tencent.tmsbeacon.base.util.c.a("[properties]", "current jsonObject not exist key: " + str, new Object[0]);
            return obj2;
        }
    }

    private boolean d() {
        if (this.g) {
            com.tencent.tmsbeacon.base.util.c.a("[properties]", "File is close!", new Object[0]);
            return true;
        }
        return false;
    }

    private Runnable e() {
        if (this.f == null) {
            this.f = new a();
        }
        return this.f;
    }

    private void f() throws IOException {
        if (this.e <= 10) {
            this.h = true;
            this.e = 4L;
        }
        MappedByteBuffer map = this.b.map(FileChannel.MapMode.READ_WRITE, 0L, this.e);
        this.d = map;
        map.rewind();
        if (this.h) {
            this.d.putInt(0, 1);
            a(e());
            return;
        }
        byte[] a2 = a(this.d);
        if (a2 == null) {
            return;
        }
        try {
            this.f25796c = new JSONObject(new String(b(a2), "ISO8859-1"));
        } catch (Exception e) {
            com.tencent.tmsbeacon.base.util.c.a("[properties]", "init error" + e.getMessage(), new Object[0]);
            com.tencent.tmsbeacon.a.b.d b2 = com.tencent.tmsbeacon.a.b.d.b();
            b2.a("504", "[properties] init error! msg: " + e.getMessage() + ". file size: " + this.e, e);
        }
        com.tencent.tmsbeacon.base.util.c.a("[properties]", "init json: " + this.f25796c.toString(), new Object[0]);
    }

    public <T> T a(String str, T t) {
        synchronized (this) {
            if (d()) {
                return t;
            }
            T c2 = c(str);
            if (c2 == null) {
                c2 = t;
            }
            return (T) c2;
        }
    }

    public <T> Set<T> a(String str, Set<T> set) {
        HashSet hashSet;
        JSONObject jSONObject;
        synchronized (this) {
            if (d()) {
                return set;
            }
            try {
                HashSet hashSet2 = new HashSet();
                synchronized (this.f25795a) {
                    jSONObject = this.f25796c.getJSONObject(str);
                }
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        hashSet2.add(jSONObject.get(keys.next()));
                    }
                }
                hashSet = hashSet2.isEmpty() ? set : hashSet2;
            } catch (JSONException e) {
                com.tencent.tmsbeacon.a.b.d.b().a("504", "[properties] JSON getSet error!", e);
                com.tencent.tmsbeacon.base.util.c.b("[properties] JSON get error!" + e.getMessage(), new Object[0]);
                hashSet = set;
            }
            return hashSet;
        }
    }

    public void a() {
        synchronized (this) {
            this.f25796c = new JSONObject();
            a(e());
        }
    }

    public boolean a(String str) {
        synchronized (this.f25795a) {
            Iterator<String> keys = this.f25796c.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    if (str.equals(keys.next())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public Map<String, ?> b() {
        synchronized (this.f25795a) {
            JSONObject jSONObject = this.f25796c;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                HashMap hashMap = new HashMap();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        hashMap.put(next, this.f25796c.get(next));
                    } catch (JSONException e) {
                        com.tencent.tmsbeacon.base.util.c.a(e);
                    }
                }
                return hashMap;
            }
            return null;
        }
    }

    public void b(String str) {
        synchronized (this) {
            synchronized (this.f25795a) {
                this.f25796c.remove(str);
            }
            a(e());
        }
    }

    public void b(String str, Object obj) {
        Object c2;
        synchronized (this) {
            if (d()) {
                return;
            }
            try {
                c2 = c(str);
            } catch (Exception e) {
                com.tencent.tmsbeacon.a.b.d.b().a("504", "[properties] JSON put error!", e);
                com.tencent.tmsbeacon.base.util.c.b("[properties] JSON put error!" + e.getMessage(), new Object[0]);
            }
            if (c2 == null || !c2.equals(obj)) {
                if (obj instanceof String) {
                    if (TextUtils.isEmpty((String) obj)) {
                        return;
                    }
                    if (!com.tencent.tmsbeacon.base.util.f.b((String) obj)) {
                        com.tencent.tmsbeacon.base.util.c.b("[properties] JSON put value not english ! !", new Object[0]);
                        return;
                    }
                }
                synchronized (this.f25795a) {
                    this.f25796c.put(str, obj);
                }
                a(e());
            }
        }
    }

    public <T> void b(String str, Set<T> set) {
        synchronized (this) {
            if (d()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                Iterator<T> it = set.iterator();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= set.size()) {
                        break;
                    }
                    if (it.hasNext()) {
                        jSONObject.put(String.valueOf(i2), it.next());
                    }
                    i = i2 + 1;
                }
                b(str, jSONObject);
            } catch (JSONException e) {
                com.tencent.tmsbeacon.base.util.c.a(e);
                com.tencent.tmsbeacon.a.b.d.b().a("504", "[properties] JSON put set error!", e);
            }
        }
    }

    public void c() {
        FileLock lock;
        synchronized (this.f25795a) {
            FileLock fileLock = null;
            try {
                try {
                    lock = this.b.lock();
                    this.d.clear();
                    FileChannel fileChannel = this.b;
                    MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, fileChannel.size());
                    this.d = map;
                    fileLock = lock;
                    this.f25796c = new JSONObject(new String(b(a(map)), "ISO8859-1"));
                } catch (Exception e) {
                    if (!this.h) {
                        StringBuilder sb = new StringBuilder();
                        FileLock fileLock2 = fileLock;
                        sb.append("loadStoreData error: ");
                        FileLock fileLock3 = fileLock;
                        sb.append(e.getMessage());
                        FileLock fileLock4 = fileLock;
                        com.tencent.tmsbeacon.base.util.c.a("[properties]", sb.toString(), new Object[0]);
                    }
                    if (fileLock != null) {
                        fileLock.release();
                    }
                }
                if (lock != null) {
                    lock.release();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
