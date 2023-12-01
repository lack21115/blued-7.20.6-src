package com.ishumei.l111l11111Il.l111l11111lIl;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l11111lIl/l111l11111Il.class */
final class l111l11111Il extends l111l1111l1Il {
    private final byte[] l1111l111111Il;
    private int l111l11111lIl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l111l11111Il(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.l111l11111lIl = -1;
        this.l1111l111111Il = bArr;
    }

    @Override // java.security.cert.Certificate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l111l11111Il) {
            try {
                return Arrays.equals(getEncoded(), ((l111l11111Il) obj).getEncoded());
            } catch (CertificateEncodingException e) {
                return false;
            }
        }
        return false;
    }

    @Override // com.ishumei.l111l11111Il.l111l11111lIl.l111l1111l1Il, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.l1111l111111Il;
    }

    @Override // java.security.cert.Certificate
    public final int hashCode() {
        if (this.l111l11111lIl == -1) {
            try {
                this.l111l11111lIl = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException e) {
                this.l111l11111lIl = 0;
            }
        }
        return this.l111l11111lIl;
    }
}
