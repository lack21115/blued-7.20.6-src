package javax.net.ssl;

import java.util.EventListener;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLSessionBindingListener.class */
public interface SSLSessionBindingListener extends EventListener {
    void valueBound(SSLSessionBindingEvent sSLSessionBindingEvent);

    void valueUnbound(SSLSessionBindingEvent sSLSessionBindingEvent);
}
