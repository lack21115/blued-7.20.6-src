package com.android.org.conscrypt;

import java.security.PublicKey;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/TrustedCertificateIndex.class */
public final class TrustedCertificateIndex {
    private final Map<X500Principal, List<TrustAnchor>> subjectToTrustAnchors = new HashMap();

    public TrustedCertificateIndex() {
    }

    public TrustedCertificateIndex(Set<TrustAnchor> set) {
        index(set);
    }

    private static TrustAnchor findBySubjectAndPublicKey(X509Certificate x509Certificate, Collection<TrustAnchor> collection) {
        X509Certificate trustedCert;
        PublicKey publicKey = x509Certificate.getPublicKey();
        for (TrustAnchor trustAnchor : collection) {
            try {
                trustedCert = trustAnchor.getTrustedCert();
            } catch (Exception e) {
            }
            if ((trustedCert != null ? trustedCert.getPublicKey() : trustAnchor.getCAPublicKey()).equals(publicKey)) {
                return trustAnchor;
            }
        }
        return null;
    }

    private void index(Set<TrustAnchor> set) {
        for (TrustAnchor trustAnchor : set) {
            index(trustAnchor);
        }
    }

    public TrustAnchor findByIssuerAndSignature(X509Certificate x509Certificate) {
        X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
        synchronized (this.subjectToTrustAnchors) {
            List<TrustAnchor> list = this.subjectToTrustAnchors.get(issuerX500Principal);
            if (list == null) {
                return null;
            }
            for (TrustAnchor trustAnchor : list) {
                try {
                    X509Certificate trustedCert = trustAnchor.getTrustedCert();
                    x509Certificate.verify(trustedCert != null ? trustedCert.getPublicKey() : trustAnchor.getCAPublicKey());
                    return trustAnchor;
                } catch (Exception e) {
                }
            }
            return null;
        }
    }

    public TrustAnchor findBySubjectAndPublicKey(X509Certificate x509Certificate) {
        X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
        synchronized (this.subjectToTrustAnchors) {
            List<TrustAnchor> list = this.subjectToTrustAnchors.get(subjectX500Principal);
            if (list == null) {
                return null;
            }
            return findBySubjectAndPublicKey(x509Certificate, list);
        }
    }

    public TrustAnchor index(X509Certificate x509Certificate) {
        TrustAnchor trustAnchor = new TrustAnchor(x509Certificate, null);
        index(trustAnchor);
        return trustAnchor;
    }

    public void index(TrustAnchor trustAnchor) {
        ArrayList arrayList;
        X509Certificate trustedCert = trustAnchor.getTrustedCert();
        X500Principal subjectX500Principal = trustedCert != null ? trustedCert.getSubjectX500Principal() : trustAnchor.getCA();
        synchronized (this.subjectToTrustAnchors) {
            List<TrustAnchor> list = this.subjectToTrustAnchors.get(subjectX500Principal);
            if (list == null) {
                ArrayList arrayList2 = new ArrayList(1);
                this.subjectToTrustAnchors.put(subjectX500Principal, arrayList2);
                arrayList = arrayList2;
            } else {
                arrayList = list;
                if (trustedCert != null) {
                    Iterator<TrustAnchor> it = list.iterator();
                    do {
                        arrayList = list;
                        if (it.hasNext()) {
                        }
                    } while (!trustedCert.equals(it.next().getTrustedCert()));
                    return;
                }
            }
            arrayList.add(trustAnchor);
        }
    }

    public void reset() {
        synchronized (this.subjectToTrustAnchors) {
            this.subjectToTrustAnchors.clear();
        }
    }

    public void reset(Set<TrustAnchor> set) {
        synchronized (this.subjectToTrustAnchors) {
            reset();
            index(set);
        }
    }
}
