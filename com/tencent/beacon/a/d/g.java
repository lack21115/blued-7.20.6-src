package com.tencent.beacon.a.d;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/d/g.class */
public class g {
    private FileChannel b;
    private MappedByteBuffer d;
    private long e;
    private Runnable f;
    private boolean g;
    private boolean h;

    /* renamed from: a  reason: collision with root package name */
    private final Object f21266a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f21267c = new JSONObject();

    private g(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.b = randomAccessFile.getChannel();
        this.e = randomAccessFile.length();
        com.tencent.beacon.base.util.c.a("[properties]", "file size: " + this.e, new Object[0]);
        e();
    }

    public static g a(Context context, String str) throws IOException {
        File file = new File(context.getFilesDir(), "beacon");
        if (!(!file.exists() ? file.mkdirs() : true)) {
            com.tencent.beacon.base.util.e.a("mkdir " + file.getName() + " exception!");
        }
        return new g(new File(file, str + com.igexin.push.core.g.e));
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
        com.tencent.beacon.a.b.a.a().a(new f(this, runnable));
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
        return com.tencent.beacon.base.net.b.c.b(3, "BEACONDEFAULTAES", bArr);
    }

    private static byte[] a(byte[] bArr, String str) {
        try {
            return com.tencent.beacon.base.net.b.c.a(3, str, bArr);
        } catch (Throwable th) {
            com.tencent.beacon.base.util.c.a(th);
            com.tencent.beacon.a.b.g e = com.tencent.beacon.a.b.g.e();
            e.a("513", "unEncrypt error: key=" + str, th);
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        byte[] a2 = a(bArr, "BEACONDEFAULTAES");
        if (a2 != null) {
            return a2;
        }
        com.tencent.beacon.a.b.g.e().a("517", "default aesKey unEncryption failed");
        byte[] a3 = a(bArr, com.tencent.beacon.a.c.f.e().a());
        return a3 != null ? a3 : a(bArr, "");
    }

    private Object c(String str) {
        Object obj;
        Object obj2 = null;
        try {
            synchronized (this.f21266a) {
                obj = this.f21267c.get(str);
                obj2 = obj;
            }
            return obj;
        } catch (Exception e) {
            com.tencent.beacon.base.util.c.a("[properties]", "current jsonObject not exist key: " + str, new Object[0]);
            return obj2;
        }
    }

    private boolean c() {
        if (this.g) {
            com.tencent.beacon.base.util.c.a("[properties]", "File is close!", new Object[0]);
            return true;
        }
        return false;
    }

    private Runnable d() {
        if (this.f == null) {
            this.f = new e(this);
        }
        return this.f;
    }

    private void e() throws IOException {
        if (this.e <= 10) {
            this.h = true;
            this.e = 4L;
        }
        MappedByteBuffer map = this.b.map(FileChannel.MapMode.READ_WRITE, 0L, this.e);
        this.d = map;
        map.rewind();
        if (this.h) {
            this.d.putInt(0, 1);
            a(d());
            return;
        }
        byte[] a2 = a(this.d);
        if (a2 == null) {
            return;
        }
        try {
            this.f21267c = new JSONObject(new String(b(a2), "ISO8859-1"));
        } catch (Exception e) {
            com.tencent.beacon.base.util.c.a("[properties]", "init error" + e.getMessage(), new Object[0]);
            com.tencent.beacon.a.b.g e2 = com.tencent.beacon.a.b.g.e();
            e2.a("504", "[properties] init error! msg: " + e.getMessage() + ". file size: " + this.e, e);
        }
        com.tencent.beacon.base.util.c.a("[properties]", "init json: " + this.f21267c.toString(), new Object[0]);
    }

    public <T> T a(String str, T t) {
        synchronized (this) {
            if (c()) {
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
            if (c()) {
                return set;
            }
            try {
                HashSet hashSet2 = new HashSet();
                synchronized (this.f21266a) {
                    jSONObject = this.f21267c.getJSONObject(str);
                }
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        hashSet2.add(jSONObject.get(keys.next()));
                    }
                }
                hashSet = hashSet2.isEmpty() ? set : hashSet2;
            } catch (JSONException e) {
                com.tencent.beacon.a.b.g.e().a("504", "[properties] JSON getSet error!", e);
                com.tencent.beacon.base.util.c.b("[properties] JSON get error!" + e.getMessage(), new Object[0]);
                hashSet = set;
            }
            return hashSet;
        }
    }

    public void a() {
        synchronized (this) {
            this.f21267c = new JSONObject();
            a(d());
        }
    }

    public boolean a(String str) {
        synchronized (this.f21266a) {
            Iterator<String> keys = this.f21267c.keys();
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
        synchronized (this.f21266a) {
            if (this.f21267c != null) {
                Iterator<String> keys = this.f21267c.keys();
                HashMap hashMap = new HashMap();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        hashMap.put(next, this.f21267c.get(next));
                    } catch (JSONException e) {
                        com.tencent.beacon.base.util.c.a(e);
                    }
                }
                return hashMap;
            }
            return null;
        }
    }

    public void b(String str) {
        synchronized (this) {
            synchronized (this.f21266a) {
                this.f21267c.remove(str);
            }
            a(d());
        }
    }

    public void b(String str, Object obj) {
        Object c2;
        synchronized (this) {
            if (c()) {
                return;
            }
            try {
                c2 = c(str);
            } catch (Exception e) {
                com.tencent.beacon.a.b.g.e().a("504", "[properties] JSON put error!", e);
                com.tencent.beacon.base.util.c.b("[properties] JSON put error!" + e.getMessage(), new Object[0]);
            }
            if (c2 == null || !c2.equals(obj)) {
                if (obj instanceof String) {
                    if (TextUtils.isEmpty((String) obj)) {
                        return;
                    }
                    if (!com.tencent.beacon.base.util.f.a((String) obj)) {
                        com.tencent.beacon.base.util.c.b("[properties] JSON put value not english ! !", new Object[0]);
                        return;
                    }
                }
                synchronized (this.f21266a) {
                    this.f21267c.put(str, obj);
                }
                a(d());
            }
        }
    }

    public <T> void b(String str, Set<T> set) {
        synchronized (this) {
            if (c()) {
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
                com.tencent.beacon.base.util.c.a(e);
                com.tencent.beacon.a.b.g.e().a("504", "[properties] JSON put set error!", e);
            }
        }
    }
}
