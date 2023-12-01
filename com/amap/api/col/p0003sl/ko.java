package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.amap.api.col.3sl.ko  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ko.class */
public final class ko extends ks {

    /* renamed from: a  reason: collision with root package name */
    private Context f5284a;
    private String b;
    private jn e;
    private Object[] f;

    public ko(Context context, ks ksVar, jn jnVar, String str, Object... objArr) {
        super(ksVar);
        this.f5284a = context;
        this.b = str;
        this.e = jnVar;
        this.f = objArr;
    }

    private String b() {
        try {
            return String.format(ib.c(this.b), this.f);
        } catch (Throwable th) {
            th.printStackTrace();
            iw.c(th, "ofm", "gpj");
            return "";
        }
    }

    @Override // com.amap.api.col.p0003sl.ks
    protected final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String a2 = ib.a(bArr);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String a3 = ib.a(this.e.b(ib.a(b())));
        return ib.a("{\"pinfo\":\"" + a3 + "\",\"els\":[" + a2 + "]}");
    }
}
