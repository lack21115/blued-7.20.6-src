package org.conscrypt;

import javax.net.ssl.SSLException;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/HandshakeListener.class */
public abstract class HandshakeListener {
    public abstract void onHandshakeFinished() throws SSLException;
}
