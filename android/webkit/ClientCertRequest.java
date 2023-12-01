package android.webkit;

import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/ClientCertRequest.class */
public abstract class ClientCertRequest {
    public abstract void cancel();

    public abstract String getHost();

    public abstract String[] getKeyTypes();

    public abstract int getPort();

    public abstract Principal[] getPrincipals();

    public abstract void ignore();

    public abstract void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr);
}