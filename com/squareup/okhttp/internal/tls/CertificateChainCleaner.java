package com.squareup.okhttp.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/internal/tls/CertificateChainCleaner.class */
public final class CertificateChainCleaner {
    private final TrustRootIndex trustRootIndex;

    public CertificateChainCleaner(TrustRootIndex trustRootIndex) {
        this.trustRootIndex = trustRootIndex;
    }

    private boolean verifySignature(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException e) {
            return false;
        }
    }

    public List<Certificate> clean(List<Certificate> list) throws SSLPeerUnverifiedException {
        Iterator<E> it;
        X509Certificate x509Certificate;
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        while (true) {
            X509Certificate x509Certificate2 = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate findByIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature(x509Certificate2);
            if (findByIssuerAndSignature != null) {
                if (arrayList.size() > 1 || !x509Certificate2.equals(findByIssuerAndSignature)) {
                    arrayList.add(findByIssuerAndSignature);
                }
                return arrayList;
            }
            it = arrayDeque.iterator();
            while (it.hasNext()) {
                x509Certificate = (X509Certificate) it.next();
                if (!x509Certificate2.getIssuerDN().equals(x509Certificate.getSubjectDN()) || !verifySignature(x509Certificate2, x509Certificate)) {
                }
            }
            throw new SSLPeerUnverifiedException("Failed to find a cert that signed " + x509Certificate2);
            it.remove();
            arrayList.add(x509Certificate);
        }
    }
}
