package com.amap.api.col.p0003sl;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.amap.api.col.3sl.jn  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jn.class */
public abstract class jn {
    jn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jn() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public jn(jn jnVar) {
        this.a = jnVar;
    }

    protected abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        jn jnVar = this.a;
        byte[] bArr2 = bArr;
        if (jnVar != null) {
            bArr2 = jnVar.b(bArr);
        }
        return a(bArr2);
    }
}
