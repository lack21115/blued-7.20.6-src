package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.tencent.cloud.huiyansdkface.okhttp3.ConnectionSpec;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/connection/ConnectionSpecSelector.class */
public final class ConnectionSpecSelector {

    /* renamed from: a  reason: collision with root package name */
    private final List<ConnectionSpec> f35933a;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35934c;
    private boolean d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f35933a = list;
    }

    private boolean a(SSLSocket sSLSocket) {
        int i = this.b;
        while (true) {
            int i2 = i;
            if (i2 >= this.f35933a.size()) {
                return false;
            }
            if (this.f35933a.get(i2).isCompatible(sSLSocket)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int i = this.b;
        int size = this.f35933a.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f35933a.get(i);
            int i2 = i + 1;
            i = i2;
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.b = i2;
                break;
            }
        }
        if (connectionSpec != null) {
            this.f35934c = a(sSLSocket);
            Internal.f35902a.apply(connectionSpec, sSLSocket, this.d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.f35933a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean connectionFailed(IOException iOException) {
        this.d = true;
        if (!this.f35934c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        boolean z2 = true;
        if (!z) {
            z2 = true;
            if (!(iOException instanceof SSLProtocolException)) {
                if (iOException instanceof SSLException) {
                    return true;
                }
                z2 = false;
            }
        }
        return z2;
    }
}
