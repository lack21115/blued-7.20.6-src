package com.amap.api.col.p0003sl;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.amap.api.col.3sl.kn  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kn.class */
public final class kn extends ks {

    /* renamed from: a  reason: collision with root package name */
    private jn f5283a;

    public kn() {
        this.f5283a = new jp();
    }

    public kn(ks ksVar) {
        super(ksVar);
        this.f5283a = new jp();
    }

    @Override // com.amap.api.col.p0003sl.ks
    protected final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f5283a.b(bArr);
    }
}
