package com.squareup.okhttp;

import java.net.Socket;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/Connection.class */
public interface Connection {
    Handshake getHandshake();

    Protocol getProtocol();

    Route getRoute();

    Socket getSocket();
}
