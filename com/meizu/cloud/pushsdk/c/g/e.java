package com.meizu.cloud.pushsdk.c.g;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/e.class */
public class e implements Serializable, Comparable<e> {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f24062a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final e b = a(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: c  reason: collision with root package name */
    final byte[] f24063c;
    transient int d;
    transient String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(byte[] bArr) {
        this.f24063c = bArr;
    }

    public static e a(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return new e(bArr);
            }
            int read = inputStream.read(bArr, i3, i - i3);
            if (read == -1) {
                throw new EOFException();
            }
            i2 = i3 + read;
        }
    }

    public static e a(String str) {
        if (str != null) {
            e eVar = new e(str.getBytes(o.f24078a));
            eVar.e = str;
            return eVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static e a(byte... bArr) {
        if (bArr != null) {
            return new e((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private e b(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f24063c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        e a2 = a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = e.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, a2.f24063c);
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (NoSuchFieldException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f24063c.length);
        objectOutputStream.write(this.f24063c);
    }

    public byte a(int i) {
        return this.f24063c[i];
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(e eVar) {
        int d = d();
        int d2 = eVar.d();
        int min = Math.min(d, d2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                if (d == d2) {
                    return 0;
                }
                return d < d2 ? -1 : 1;
            }
            int a2 = a(i2) & 255;
            int a3 = eVar.a(i2) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
            i = i2 + 1;
        }
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f24063c, o.f24078a);
        this.e = str2;
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        byte[] bArr = this.f24063c;
        bVar.c(bArr, 0, bArr.length);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.f24063c;
        return i <= bArr2.length - i3 && i2 <= bArr.length - i3 && o.a(bArr2, i, bArr, i2, i3);
    }

    public e b() {
        return b("MD5");
    }

    public String c() {
        byte[] bArr = this.f24063c;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f24062a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public int d() {
        return this.f24063c.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            int d = eVar.d();
            byte[] bArr = this.f24063c;
            return d == bArr.length && eVar.a(0, bArr, 0, bArr.length);
        }
        return false;
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f24063c);
        this.d = hashCode;
        return hashCode;
    }

    public String toString() {
        byte[] bArr = this.f24063c;
        return bArr.length == 0 ? "ByteString[size=0]" : bArr.length <= 16 ? String.format("ByteString[size=%s data=%s]", Integer.valueOf(bArr.length), c()) : String.format("ByteString[size=%s md5=%s]", Integer.valueOf(bArr.length), b().c());
    }
}
