package org.conscrypt;

import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/Java8ExtendedSSLSession.class */
public class Java8ExtendedSSLSession extends Java7ExtendedSSLSession {
    public Java8ExtendedSSLSession(ExternalSession externalSession) {
        super(externalSession);
    }

    @Override // javax.net.ssl.ExtendedSSLSession
    public final List<SNIServerName> getRequestedServerNames() {
        String requestedServerName = this.delegate.getRequestedServerName();
        if (requestedServerName == null) {
            return null;
        }
        return Collections.singletonList(new SNIHostName(requestedServerName));
    }
}
