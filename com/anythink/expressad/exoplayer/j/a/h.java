package com.anythink.expressad.exoplayer.j.a;

import android.util.SparseArray;
import com.anythink.expressad.exoplayer.j.a.a;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7564a = "cached_content_index.exi";
    private static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final int f7565c = 1;
    private final HashMap<String, g> d;
    private final SparseArray<String> e;
    private final com.anythink.expressad.exoplayer.k.b f;
    private final Cipher g;
    private final SecretKeySpec h;
    private final boolean i;
    private boolean j;
    private x k;

    private h(File file) {
        this(file, null);
    }

    private h(File file, byte[] bArr) {
        this(file, bArr, bArr != null);
    }

    public h(File file, byte[] bArr, boolean z) {
        this.i = z;
        if (bArr != null) {
            com.anythink.expressad.exoplayer.k.a.a(bArr.length == 16);
            try {
                this.g = h();
                this.h = new SecretKeySpec(bArr, "AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new IllegalStateException(e);
            }
        } else {
            com.anythink.expressad.exoplayer.k.a.b(!z);
            this.g = null;
            this.h = null;
        }
        this.d = new HashMap<>();
        this.e = new SparseArray<>();
        this.f = new com.anythink.expressad.exoplayer.k.b(new File(file, f7564a));
    }

    private static int a(SparseArray<String> sparseArray) {
        int i;
        int size = sparseArray.size();
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        int i2 = keyAt;
        if (keyAt < 0) {
            int i3 = 0;
            while (true) {
                i = i3;
                if (i >= size || i != sparseArray.keyAt(i)) {
                    break;
                }
                i3 = i + 1;
            }
            i2 = i;
        }
        return i2;
    }

    private void a(g gVar) {
        this.d.put(gVar.b, gVar);
        this.e.put(gVar.f7563a, gVar.b);
    }

    private g f(String str) {
        int i;
        SparseArray<String> sparseArray = this.e;
        int size = sparseArray.size();
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        int i2 = keyAt;
        if (keyAt < 0) {
            int i3 = 0;
            while (true) {
                i = i3;
                if (i >= size || i != sparseArray.keyAt(i)) {
                    break;
                }
                i3 = i + 1;
            }
            i2 = i;
        }
        g gVar = new g(i2, str);
        a(gVar);
        this.j = true;
        return gVar;
    }

    private boolean f() {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        DataInputStream dataInputStream3 = null;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f.c());
            DataInputStream dataInputStream4 = new DataInputStream(bufferedInputStream);
            dataInputStream3 = dataInputStream4;
            dataInputStream2 = dataInputStream4;
            try {
                int readInt = dataInputStream4.readInt();
                if (readInt < 0 || readInt > 2) {
                    af.a((Closeable) dataInputStream4);
                    return false;
                }
                if ((dataInputStream4.readInt() & 1) == 0) {
                    dataInputStream = dataInputStream4;
                    if (this.i) {
                        this.j = true;
                        dataInputStream = dataInputStream4;
                    }
                } else if (this.g == null) {
                    af.a((Closeable) dataInputStream4);
                    return false;
                } else {
                    byte[] bArr = new byte[16];
                    dataInputStream4.readFully(bArr);
                    try {
                        this.g.init(2, this.h, new IvParameterSpec(bArr));
                        dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.g));
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                        throw new IllegalStateException(e);
                    }
                }
                int readInt2 = dataInputStream.readInt();
                int i = 0;
                for (int i2 = 0; i2 < readInt2; i2++) {
                    g a2 = g.a(readInt, dataInputStream);
                    DataInputStream dataInputStream5 = dataInputStream;
                    a(a2);
                    DataInputStream dataInputStream6 = dataInputStream;
                    i += a2.a(readInt);
                }
                int readInt3 = dataInputStream.readInt();
                DataInputStream dataInputStream7 = dataInputStream;
                boolean z = dataInputStream.read() == -1;
                if (readInt3 == i && z) {
                    af.a((Closeable) dataInputStream);
                    return true;
                }
                af.a((Closeable) dataInputStream);
                return false;
            } catch (IOException e2) {
                if (dataInputStream2 != null) {
                    af.a((Closeable) dataInputStream2);
                    return false;
                }
                return false;
            } catch (Throwable th) {
                th = th;
                if (dataInputStream3 != null) {
                    af.a((Closeable) dataInputStream3);
                }
                throw th;
            }
        } catch (IOException e3) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void g() {
        DataOutputStream dataOutputStream;
        Throwable th;
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                OutputStream b2 = this.f.b();
                if (this.k == null) {
                    this.k = new x(b2);
                } else {
                    this.k.a(b2);
                }
                DataOutputStream dataOutputStream3 = new DataOutputStream(this.k);
                dataOutputStream = dataOutputStream3;
                try {
                    dataOutputStream3.writeInt(2);
                    dataOutputStream3.writeInt(this.i ? 1 : 0);
                    DataOutputStream dataOutputStream4 = dataOutputStream3;
                    if (this.i) {
                        byte[] bArr = new byte[16];
                        new Random().nextBytes(bArr);
                        dataOutputStream3.write(bArr);
                        try {
                            this.g.init(1, this.h, new IvParameterSpec(bArr));
                            dataOutputStream3.flush();
                            dataOutputStream4 = new DataOutputStream(new CipherOutputStream(this.k, this.g));
                        } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                    DataOutputStream dataOutputStream5 = dataOutputStream4;
                    dataOutputStream4.writeInt(this.d.size());
                    DataOutputStream dataOutputStream6 = dataOutputStream4;
                    int i = 0;
                    for (g gVar : this.d.values()) {
                        DataOutputStream dataOutputStream7 = dataOutputStream4;
                        DataOutputStream dataOutputStream8 = dataOutputStream4;
                        gVar.a(dataOutputStream4);
                        DataOutputStream dataOutputStream9 = dataOutputStream4;
                        i += gVar.a(2);
                    }
                    dataOutputStream4.writeInt(i);
                    DataOutputStream dataOutputStream10 = dataOutputStream4;
                    this.f.a(dataOutputStream4);
                    af.a((Closeable) null);
                } catch (IOException e2) {
                    e = e2;
                    dataOutputStream2 = dataOutputStream3;
                    throw new a.C0138a(e);
                } catch (Throwable th2) {
                    th = th2;
                    af.a(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                dataOutputStream = dataOutputStream2;
                th = th3;
            }
        } catch (IOException e3) {
            e = e3;
            dataOutputStream2 = null;
        }
    }

    private static Cipher h() {
        if (af.f7632a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable th) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public final g a(String str) {
        int i;
        g gVar = this.d.get(str);
        g gVar2 = gVar;
        if (gVar == null) {
            SparseArray<String> sparseArray = this.e;
            int size = sparseArray.size();
            int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
            int i2 = keyAt;
            if (keyAt < 0) {
                int i3 = 0;
                while (true) {
                    i = i3;
                    if (i >= size || i != sparseArray.keyAt(i)) {
                        break;
                    }
                    i3 = i + 1;
                }
                i2 = i;
            }
            gVar2 = new g(i2, str);
            a(gVar2);
            this.j = true;
        }
        return gVar2;
    }

    public final String a(int i) {
        return this.e.get(i);
    }

    public final void a() {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        if (f()) {
            return;
        }
        this.f.a();
        this.d.clear();
        this.e.clear();
    }

    public final void a(String str, k kVar) {
        if (a(str).a(kVar)) {
            this.j = true;
        }
    }

    public final g b(String str) {
        return this.d.get(str);
    }

    public final void b() {
        DataOutputStream dataOutputStream;
        Throwable th;
        if (!this.j) {
            return;
        }
        try {
            try {
                OutputStream b2 = this.f.b();
                if (this.k == null) {
                    this.k = new x(b2);
                } else {
                    this.k.a(b2);
                }
                DataOutputStream dataOutputStream2 = new DataOutputStream(this.k);
                dataOutputStream = dataOutputStream2;
                try {
                    dataOutputStream2.writeInt(2);
                    dataOutputStream2.writeInt(this.i ? 1 : 0);
                    DataOutputStream dataOutputStream3 = dataOutputStream2;
                    if (this.i) {
                        byte[] bArr = new byte[16];
                        new Random().nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            this.g.init(1, this.h, new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream3 = new DataOutputStream(new CipherOutputStream(this.k, this.g));
                        } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                    DataOutputStream dataOutputStream4 = dataOutputStream3;
                    dataOutputStream3.writeInt(this.d.size());
                    DataOutputStream dataOutputStream5 = dataOutputStream3;
                    int i = 0;
                    for (g gVar : this.d.values()) {
                        DataOutputStream dataOutputStream6 = dataOutputStream3;
                        DataOutputStream dataOutputStream7 = dataOutputStream3;
                        gVar.a(dataOutputStream3);
                        DataOutputStream dataOutputStream8 = dataOutputStream3;
                        i += gVar.a(2);
                    }
                    dataOutputStream3.writeInt(i);
                    DataOutputStream dataOutputStream9 = dataOutputStream3;
                    this.f.a(dataOutputStream3);
                    af.a((Closeable) null);
                    this.j = false;
                } catch (IOException e2) {
                    e = e2;
                    throw new a.C0138a(e);
                } catch (Throwable th2) {
                    th = th2;
                    af.a(dataOutputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th3) {
            dataOutputStream = null;
            th = th3;
        }
    }

    public final int c(String str) {
        return a(str).f7563a;
    }

    public final Collection<g> c() {
        return this.d.values();
    }

    public final void d() {
        int size = this.d.size();
        String[] strArr = new String[size];
        this.d.keySet().toArray(strArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            d(strArr[i2]);
            i = i2 + 1;
        }
    }

    public final void d(String str) {
        g gVar = this.d.get(str);
        if (gVar == null || !gVar.d() || gVar.b()) {
            return;
        }
        this.d.remove(str);
        this.e.remove(gVar.f7563a);
        this.j = true;
    }

    public final i e(String str) {
        g b2 = b(str);
        return b2 != null ? b2.a() : l.b;
    }

    public final Set<String> e() {
        return this.d.keySet();
    }
}
