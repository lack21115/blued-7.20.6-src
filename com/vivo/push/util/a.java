package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/a.class */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f27438c;

    /* renamed from: a  reason: collision with root package name */
    private byte[] f27439a;
    private byte[] b;

    private a(Context context) {
        w.b().a(ContextDelegate.getContext(context));
        w b = w.b();
        this.f27439a = b.c();
        this.b = b.d();
    }

    public static a a(Context context) {
        if (f27438c == null) {
            synchronized (a.class) {
                try {
                    if (f27438c == null) {
                        f27438c = new a(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27438c;
    }

    private byte[] a() {
        byte[] bArr = this.f27439a;
        return (bArr == null || bArr.length <= 0) ? w.b().c() : bArr;
    }

    private byte[] b() {
        byte[] bArr = this.b;
        return (bArr == null || bArr.length <= 0) ? w.b().d() : bArr;
    }

    public final String a(String str) {
        String a2 = f.a(a());
        String a3 = f.a(b());
        byte[] bytes = str.getBytes("utf-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(a3.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
        cipher.init(1, secretKeySpec, new IvParameterSpec(a2.getBytes("utf-8")));
        return Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    public final String b(String str) {
        return new String(f.a(f.a(a()), f.a(b()), Base64.decode(str, 2)), "utf-8");
    }
}
