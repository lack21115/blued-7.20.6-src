package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.util.ArraySet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/o.class */
final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f7818a = new o(null, 0, null, null, null);
    public final Signature[] b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7819c;
    public final ArraySet<PublicKey> d;
    public final Signature[] e;
    public final int[] f;

    public o(Signature[] signatureArr) {
        this(signatureArr, 2, null, null);
    }

    public o(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.b = signatureArr;
        this.f7819c = i;
        this.d = arraySet;
        this.e = signatureArr2;
        this.f = iArr;
    }

    public o(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i, a(signatureArr), signatureArr2, iArr);
    }

    private static ArraySet<PublicKey> a(Signature[] signatureArr) {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= signatureArr.length) {
                return arraySet;
            }
            Method a2 = com.bytedance.pangle.b.a.a.a(Signature.class, "getPublicKey", new Class[0]);
            if (a2 != null && a2.isAccessible()) {
                try {
                    arraySet.add((PublicKey) a2.invoke(signatureArr[i2], new Object[0]));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            i = i2 + 1;
        }
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.d.a((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.d.a((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f7819c == oVar.f7819c && a(this.b, oVar.b)) {
                ArraySet<PublicKey> arraySet = this.d;
                if (arraySet != null) {
                    if (!arraySet.equals(oVar.d)) {
                        return false;
                    }
                } else if (oVar.d != null) {
                    return false;
                }
                return Arrays.equals(this.e, oVar.e) && Arrays.equals(this.f, oVar.f);
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.b);
        int i = this.f7819c;
        ArraySet<PublicKey> arraySet = this.d;
        return (((((((hashCode * 31) + i) * 31) + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.e)) * 31) + Arrays.hashCode(this.f);
    }
}
