package javax.net.ssl;

import java.util.EventListener;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/HandshakeCompletedListener.class */
public interface HandshakeCompletedListener extends EventListener {
    void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent);
}
