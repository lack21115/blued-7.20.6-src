package javax.net.ssl;

import java.util.EventObject;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLSessionBindingEvent.class */
public class SSLSessionBindingEvent extends EventObject {
    private final String name;

    public SSLSessionBindingEvent(SSLSession sSLSession, String str) {
        super(sSLSession);
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public SSLSession getSession() {
        return (SSLSession) this.source;
    }
}
