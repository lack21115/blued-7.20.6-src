package com.tencent.qimei.i;

import android.content.Context;
import com.igexin.push.core.g;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/i/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public RandomAccessFile f24645a;
    public FileChannel b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f24646c;
    public MappedByteBuffer d;
    public long e;
    public Runnable f;
    public final Object g = new Object();
    public boolean h;
    public boolean i;

    public e(File file) throws IOException {
        byte[] bArr;
        byte[] a2;
        this.f24646c = new JSONObject();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.f24645a = randomAccessFile;
        this.b = randomAccessFile.getChannel();
        long length = this.f24645a.length();
        this.e = length;
        if (length <= 10) {
            this.i = true;
            this.e = 4L;
        }
        MappedByteBuffer map = this.b.map(FileChannel.MapMode.READ_WRITE, 0L, this.e);
        this.d = map;
        map.rewind();
        if (this.i) {
            this.d.putInt(0, 1);
            if (this.f == null) {
                this.f = new c(this);
            }
            com.tencent.qimei.b.a.a().a(new d(this, this.f));
            return;
        }
        MappedByteBuffer mappedByteBuffer = this.d;
        int i = mappedByteBuffer.getInt(0);
        if (i <= 1 || i > 2097152 || mappedByteBuffer.capacity() <= 10 || mappedByteBuffer.capacity() < i + 10) {
            bArr = null;
        } else {
            mappedByteBuffer.position(10);
            bArr = new byte[i];
            mappedByteBuffer.get(bArr, 0, i);
        }
        if (bArr == null) {
            return;
        }
        try {
            byte[] a3 = a(bArr, "BEACONDEFAULTAES");
            if (a3 != null) {
                a2 = a3;
            } else {
                byte[] a4 = a(bArr, com.tencent.qimei.c.c.j().b());
                a2 = a4 != null ? a4 : a(bArr, "");
            }
            this.f24646c = new JSONObject(new String(a2, "ISO8859-1"));
        } catch (Exception e) {
            e.getMessage();
        }
        this.f24646c.toString();
    }

    public static e a(Context context, String str) throws IOException {
        File file = new File(context.getFilesDir(), "beacon");
        if (!(!file.exists() ? file.mkdirs() : true)) {
            com.tencent.qimei.j.e.a("mkdir " + file.getName() + " exception!");
        }
        File file2 = new File(file, str + g.e);
        if (file2.exists()) {
            return new e(file2);
        }
        return null;
    }

    public final Object a(String str) {
        Object obj;
        Object obj2 = null;
        try {
            synchronized (this.g) {
                obj = this.f24646c.get(str);
                obj2 = obj;
            }
            return obj;
        } catch (Exception e) {
            return obj2;
        }
    }

    public <T> T a(String str, T t) {
        synchronized (this) {
            if (this.h) {
                return t;
            }
            T a2 = a(str);
            if (a2 == null) {
                a2 = t;
            }
            return (T) a2;
        }
    }

    public void a() {
        synchronized (this) {
            try {
                this.f24646c = null;
                this.h = true;
                this.d.clear();
                this.f24645a.close();
            } catch (Exception e) {
            }
        }
    }

    public final void a(long j) throws IOException {
        if (j > 2097152) {
            throw new IllegalArgumentException("file size to reach maximum!");
        }
        this.d.rewind();
        this.d = this.b.map(FileChannel.MapMode.READ_WRITE, 0L, j);
    }

    public final byte[] a(byte[] bArr) throws Exception {
        return com.tencent.qimei.a.a.a(bArr, com.tencent.qimei.a.a.a("BEACONDEFAULTAES").getBytes(), 1);
    }

    public final byte[] a(byte[] bArr, String str) {
        try {
            return com.tencent.qimei.a.a.a(bArr, com.tencent.qimei.a.a.a(str).getBytes(), 2);
        } catch (Throwable th) {
            com.tencent.qimei.k.a.a(th);
            return null;
        }
    }
}
