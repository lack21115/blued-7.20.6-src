package com.squareup.okhttp.internal.tls;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/internal/tls/RealTrustRootIndex.class */
public final class RealTrustRootIndex implements TrustRootIndex {
    private final Map<X500Principal, List<X509Certificate>> subjectToCaCerts = new LinkedHashMap();

    public RealTrustRootIndex(X509Certificate... x509CertificateArr) {
        int length = x509CertificateArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            X509Certificate x509Certificate = x509CertificateArr[i2];
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            List<X509Certificate> list = this.subjectToCaCerts.get(subjectX500Principal);
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList(1);
                this.subjectToCaCerts.put(subjectX500Principal, arrayList);
            }
            arrayList.add(x509Certificate);
            i = i2 + 1;
        }
    }

    @Override // com.squareup.okhttp.internal.tls.TrustRootIndex
    public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
        List<X509Certificate> list = this.subjectToCaCerts.get(x509Certificate.getIssuerX500Principal());
        if (list == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : list) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception e) {
            }
        }
        return null;
    }
}
