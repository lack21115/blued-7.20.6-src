package org.conscrypt;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/ApplicationProtocolSelectorAdapter.class */
public final class ApplicationProtocolSelectorAdapter {
    private static final int NO_PROTOCOL_SELECTED = -1;
    private final SSLEngine engine;
    private final ApplicationProtocolSelector selector;
    private final SSLSocket socket;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApplicationProtocolSelectorAdapter(SSLEngine sSLEngine, ApplicationProtocolSelector applicationProtocolSelector) {
        this.engine = (SSLEngine) Preconditions.checkNotNull(sSLEngine, "engine");
        this.socket = null;
        this.selector = (ApplicationProtocolSelector) Preconditions.checkNotNull(applicationProtocolSelector, "selector");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApplicationProtocolSelectorAdapter(SSLSocket sSLSocket, ApplicationProtocolSelector applicationProtocolSelector) {
        this.engine = null;
        this.socket = (SSLSocket) Preconditions.checkNotNull(sSLSocket, "socket");
        this.selector = (ApplicationProtocolSelector) Preconditions.checkNotNull(applicationProtocolSelector, "selector");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int selectApplicationProtocol(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return -1;
        }
        List<String> asList = Arrays.asList(SSLUtils.decodeProtocols(bArr));
        SSLEngine sSLEngine = this.engine;
        String selectApplicationProtocol = sSLEngine != null ? this.selector.selectApplicationProtocol(sSLEngine, asList) : this.selector.selectApplicationProtocol(this.socket, asList);
        if (selectApplicationProtocol == null || selectApplicationProtocol.isEmpty()) {
            return -1;
        }
        int i = 0;
        for (String str : asList) {
            if (selectApplicationProtocol.equals(str)) {
                return i;
            }
            i += str.length() + 1;
        }
        return -1;
    }
}
