package com.bytedance.pangle.g;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/p.class */
final class p extends r {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f7820a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.b = -1;
        this.f7820a = bArr;
    }

    @Override // java.security.cert.Certificate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            try {
                return Arrays.equals(getEncoded(), ((p) obj).getEncoded());
            } catch (CertificateEncodingException e) {
                return false;
            }
        }
        return false;
    }

    @Override // com.bytedance.pangle.g.r, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.f7820a;
    }

    @Override // java.security.cert.Certificate
    public final int hashCode() {
        if (this.b == -1) {
            try {
                this.b = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException e) {
                this.b = 0;
            }
        }
        return this.b;
    }
}
