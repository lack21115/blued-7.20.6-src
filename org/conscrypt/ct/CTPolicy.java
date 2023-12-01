package org.conscrypt.ct;

import java.security.cert.X509Certificate;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/ct/CTPolicy.class */
public interface CTPolicy {
    boolean doesResultConformToPolicy(CTVerificationResult cTVerificationResult, String str, X509Certificate[] x509CertificateArr);
}
