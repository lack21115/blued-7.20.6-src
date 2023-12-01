package okhttp3.internal.connection;

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
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/connection/ConnectionSpecSelector.class */
public final class ConnectionSpecSelector {

    /* renamed from: a  reason: collision with root package name */
    private final List<ConnectionSpec> f43869a;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f43870c;
    private boolean d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f43869a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        int i = this.b;
        while (true) {
            int i2 = i;
            if (i2 >= this.f43869a.size()) {
                return false;
            }
            if (this.f43869a.get(i2).isCompatible(sSLSocket)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public ConnectionSpec a(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int i = this.b;
        int size = this.f43869a.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f43869a.get(i);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.b = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec != null) {
            this.f43870c = b(sSLSocket);
            Internal.instance.apply(connectionSpec, sSLSocket, this.d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.f43869a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        this.d = true;
        if (!this.f43870c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
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
