package com.squareup.okhttp.internal.tls;

import java.security.cert.X509Certificate;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/internal/tls/TrustRootIndex.class */
public interface TrustRootIndex {
    X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate);
}
